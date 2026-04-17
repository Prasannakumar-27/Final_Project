package testCases;

import java.util.Scanner;

import org.testng.annotations.Test;

import pageObjects.BaseClass;
import pageObjects.CorporateWellnessPage;
import utilities.ExcelUtils;

public class TC_003_CorporateWellnessTest extends BaseClass {

    @Test
    public void verifyCorporateWellnessDemoForm() throws Exception {

        // ✅ Excel details
        String xlPath = ".\\testdata\\testData.xlsx";
        String sheetName = "Sheet1";

        // ✅ Read Corporate Wellness data from Excel
        String name = ExcelUtils.getCellData(xlPath, sheetName, 5, 1);
        String organization = ExcelUtils.getCellData(xlPath, sheetName, 6, 1);
        String mobile = ExcelUtils.getCellData(xlPath, sheetName, 7, 1);
        String email = ExcelUtils.getCellData(xlPath, sheetName, 8, 1);
        String orgSize = ExcelUtils.getCellData(xlPath, sheetName, 9, 1);
        String interest = ExcelUtils.getCellData(xlPath, sheetName, 10, 1);

        CorporateWellnessPage wellnessPage = new CorporateWellnessPage(driver);

        wellnessPage.openHealthAndWellnessPlans();

        wellnessPage.fillForm(
                name,
                organization,
                mobile,
                email
        );

        wellnessPage.selectOrganizationSize(orgSize);
        wellnessPage.selectInterestedIn(interest);

        wellnessPage.submitForm();

        // CAPTCHA manual pause
        Scanner sc = new Scanner(System.in);
        System.out.println("After validating CAPTCHA... Press ENTER");
        sc.nextLine();

        System.out.println("Alert message : " +
                wellnessPage.getAlertMessage());

        driver.navigate().to("https://www.practo.com/plus/corporate");
        sc.close();
    }
}
