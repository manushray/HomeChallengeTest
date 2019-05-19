package Challenge.HomeChallenge;

import java.util.concurrent.TimeUnit;


/*This class will make Web & Mobile Overly Ad as On*/
public class NewEmbedFlowSelectAds extends LoginPage {

	public boolean selectAdMethod() {
		 waitForElement(driver,overlaywebtogglebtn);
	     overlaywebtogglebtn.click();
	     driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	     waitForElement(driver,overlaymobiletogglebtn);
	     overlaymobiletogglebtn.click();
	     overlaymobiletogglebtn.click();
	     frwdbtn.click();
	     log.info("Selection of Ad Flow is done successfully");
	     return true;
	}
	
	public NewEmbedFlowRevenue revenueTabMethod(){
		return new NewEmbedFlowRevenue();
	}
}
