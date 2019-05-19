package Challenge.HomeChallenge;

/*This class will add the Question,Answers,Adding of answer block & Remove the answer block*/
public class NewEmbedFlowCustomize extends LoginPage{

	
	public boolean flowcustMethod(String ans1,String ans2,String ans3) {
		 typeQuestiontext.sendKeys(prop.getProperty("embed_question"));
	     clickForElement(driver,addAnsbtn);
	     log.info("Addition of Answer button is next");
	     addAnsbtn.click();
	     log.info("Addition of Answer button & Removing it is going to happen");
	     removeoptionbtn.click();
	     answerclass1.click();
	     answerclass1.sendKeys(ans1);
	     answerclass2.click();
	     answerclass2.sendKeys(ans2);
	     answerclass3.click();
	     answerclass3.sendKeys(ans3);
	     correctansbtn.click();
	     frwdbtn.click();
	     return true;
	     
	}
	
	public NewEmbedFlowSelectAds selectAdTabMethod(){
		return new NewEmbedFlowSelectAds();
	}
}
