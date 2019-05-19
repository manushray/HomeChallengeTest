package Challenge.HomeChallenge;


/*This class will make Market Research & Reward to Off by clicking on the toggle button*/
public class NewEmbedFlowRevenue extends LoginPage{

	public boolean revenueMethod() {
	     waitForElement(driver,mktrsrchtogbtn);
	     mktrsrchtogbtn.click();
	     waitForElement(driver,rewrdtogbtn);
	     rewrdtogbtn.click(); 
	     frwdbtn.click();
	     log.info("Flow of Revenue is done successfully");
	     return true;
	}
	
	public NewEmbedFlowPublish publishTabMethod(){
		return new NewEmbedFlowPublish();
	}
}
