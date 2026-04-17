package testCases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pageObjects.*;
import utilities.ExcelUtils;

public class TC_001_Identify_Hospitals extends BaseClass {

    @Test
    public void identifyHospitals() throws Exception {

        // Excel file details
        String xlPath = ".\\testdata\\testData.xlsx";
        String sheetName = "Sheet1";

        // Read data from Excel instead of properties
        String location = ExcelUtils.getCellData(xlPath, sheetName, 1, 1);
        String hospitalSearch = ExcelUtils.getCellData(xlPath, sheetName, 2, 1);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        HomePage home = new HomePage(driver);
        home.selectLocation(location);
        home.selectHospital(hospitalSearch);

        HospitalListPage listPage = new HospitalListPage(driver);
        List<WebElement> hospitalLinks = listPage.getHospitalLinks();

        List<String> urls = new ArrayList<>();

        for (WebElement link : hospitalLinks) {
            js.executeScript("arguments[0].scrollIntoView(true);", link);
            urls.add(link.getAttribute("href"));
        }

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

            driver.navigate().back();
        }
    }
}
