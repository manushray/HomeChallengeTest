package Challenge.HomeChallenge;

/*This class will click on the finish & return to Library button */
public class NewEmbedFlowPublish extends LoginPage {

	public boolean publishMethod() throws Exception{
		
			log.info("Clicking on Finish & return to library page");
			 clickForElement(driver,finishretrnlibbtn);//This method will wait till the element become clickable
			 Thread.sleep(1800);
			 finishretrnlibbtn.click();
			 return true;
		
	 	}
	
	public Validation validatingMethod(){
		return new Validation();
	}
}
