package testCases;

import org.junit.Assert;
import org.testng.annotations.Test;
import pageObjects.BaseClass;
import pageObjects.DiagnosticPage;

public class TC_002_DiagnosticTest extends BaseClass {

    @Test
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