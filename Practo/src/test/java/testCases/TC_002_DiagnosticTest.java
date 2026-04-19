package testCases;

import org.junit.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import pageObjects.DiagnosticPage;

public class TC_002_DiagnosticTest extends BaseClass {
	

	@Feature("Diagnostic Page")
	@Story("Search Top Cities")
    @Test(priority = 2)
    public void verifyTopCitiesInDiagnosticPage() {
    	
    	try {
    		logger.info("----------Diagnostic Test starts ----------");
        	
            DiagnosticPage diagnosticPage = new DiagnosticPage(driver);
            
            logger.info("Clicking diagnostic page");
            diagnosticPage.clickDiagnosticPage();
            
            logger.info("Printing Top Cities in Diagnostic Page");
            diagnosticPage.printTopCities();
    	}catch(Exception e) {
    		logger.error("----------Test Failed----------");
    		logger.debug("Debug logs...");
    		Assert.fail();
    	}
    	
    	
    }
}