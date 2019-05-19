package Challenge.HomeChallenge;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
/*This code is to validate all the 3 condition given in the task to validate 
a. Check if the embed created exists with the given name
b. Click on that embed and check if the count of content available is 1
c. Check if the titles of the question and option answers match with the value
entered through the script steps*/

public class Validation extends LoginPage {
	List<String> ans=new ArrayList<String>();
	
	//This method will validate the Embed name
	public String validationEmbedNameCreatedMethod() {
		searchbtn.sendKeys(prop.getProperty("embed_creation_name"));
	     waitForElement(driver,textvalidatelocation);
	     String embedresult=textvalidatelocation.getText();
	     log.info("Validation of Embed created name & its count:"+embedresult);
	     return embedresult;
	}
	
	//This method will count the number of Embed created with the given name 
	public int validationEmbedNoOfCreatedMethod() {

	     int count=listEmbedeMethod();
	     log.info("Validation of Embed created name & its count:"+count);
	     return count;
	}
	
	//This method will validate the Question which has been asked earlier
	public String validationQuestionMethod() {
	     textvalidatelocation.click();
	     waitForElement(driver,answerclass1);
	     waitForElement(driver,answerclass3);	    
	     driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	     waitForElement(driver,question);
	     String questionText=question.getText();
	     log.info("Validation of 1st Answer is done & the Values is:"+questionText);
	     return questionText;
	}
	
	//This method will validate the Answer which has been given earlier in the code while creating the embed
	public List<String> validationAnswerMethod(){
	     WebElement answerclass1tovalidateAns=driver.findElement(By.cssSelector("#customize > div.grouper > div:nth-child(2) > div.embededitor.c0161.rail > div > div > div > div.structure.body > div > div.answerset.c0168.text1.answeramount-3 > div:nth-child(1) > div > span.text > div"));
	     String ans1=answerclass1tovalidateAns.getText();
	     ans.add(ans1);
	     log.info("Validation of 1st Answer is done & the Values is:"+ans1);
	     WebElement answerclass2tovalidateAns2=driver.findElement(By.cssSelector("#customize > div.grouper > div:nth-child(2) > div.embededitor.c0161.rail > div > div > div > div.structure.body > div > div.answerset.c0168.text1.answeramount-3 > div:nth-child(2) > div > span.text > div"));
	     String ans2=answerclass2tovalidateAns2.getText();
	     ans.add(ans2);
	     log.info("Validation of 2nd  Answer is done & the Values is:"+ans2);
	     WebElement answerclass3tovalidateAns3=driver.findElement(By.cssSelector("#customize > div.grouper > div:nth-child(2) > div.embededitor.c0161.rail > div > div > div > div.structure.body > div > div.answerset.c0168.text1.answeramount-3 > div:nth-child(3) > div > span.text > div"));
	     String ans3=answerclass3tovalidateAns3.getText();
	     ans.add(ans3);
	     log.info("Validation of 3rd  Answer is done & the Values is:"+ans3);
	     driver.close();
	     // Switch back to original browser (first window)
	     driver.switchTo().window(winHandleBefore);
	     
	     return ans;
}

}