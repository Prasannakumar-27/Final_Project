package testCases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.BaseClass;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import pageObjects.HomePage;
import pageObjects.HospitalDetailPage;
import pageObjects.HospitalListPage;
import utilities.ExcelUtils;

public class TC_001_Identify_Hospitals extends BaseClass {
	

	@Feature("Hospital Search")
	@Story("Search hospital by filtering")
    @Test(priority = 1)
    public void identifyHospitals() throws Exception {
		logger.info("----------Identifying Hospital Test starts ----------");
        // Excel file details
        String xlPath = ".\\testdata\\testData.xlsx";
        String sheetName = "Sheet1";

        // Read data from Excel instead of properties
        String location = ExcelUtils.getCellData(xlPath, sheetName, 1, 1);
        String hospitalSearch = ExcelUtils.getCellData(xlPath, sheetName, 2, 1);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        
        HomePage home = new HomePage(driver);
        home.selectLocation(location);
        logger.info("Given Location input and selected the correct location");
        home.selectHospital(hospitalSearch);
        logger.info("Given Hospital input and selected Hospital");

        HospitalListPage listPage = new HospitalListPage(driver);
        List<WebElement> hospitalLinks = listPage.getHospitalLinks();

        List<String> urls = new ArrayList<>();

        for (WebElement link : hospitalLinks) {
            js.executeScript("arguments[0].scrollIntoView(true);", link);
            urls.add(link.getAttribute("href"));
        }
        
        logger.info("Getting hospitals");
        for (String url : urls) {
            driver.navigate().to(url);

            HospitalDetailPage detail = new HospitalDetailPage(driver);

            double rating = detail.getRating();
            boolean open247 = detail.isOpen247();

            if (open247 && rating > 3.5) {
                detail.clickReadMore();
                boolean parking = detail.hasParking();

                System.out.println(
                        "Hospital: " + detail.getHospitalName()
                                + " | Rating: " + rating
                                + " | Open 24x7 | Parking: "
                                + (parking ? "Available" : "Not Mentioned")
                );
            }
            logger.info("Captured every hospital that matched the criteria");
            driver.navigate().back();
            
            logger.info("Redirected to previous page");
        }
    }
}
