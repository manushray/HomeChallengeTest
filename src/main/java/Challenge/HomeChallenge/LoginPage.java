package Challenge.HomeChallenge;



import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import Challenge.HomeChallenge.Base.Base;


/* This class is worked as primary class for all the classes present under Pages Package
 *  which contains all the web element of the application using Page Object Model and un-mocking the client at end of the code */
public class LoginPage extends Base{
	
	public static String winHandleBefore = driver.getWindowHandle();
	public String winHandle;
	
	//Used page Object Model for identifying the elements
		@FindBy(id="username")
		WebElement login;
		
		@FindBy(id="password")
		WebElement pwd;
		
		@FindBy(id="logInButton")
		WebElement loginbtn;
		
		@FindBy(xpath="//a[contains(text(),'Clients & Sites')]")
		WebElement clientSitedrpbtn;
		
		@FindBy(xpath="//a[contains(text(),'Mock As Client')]")
		WebElement mockclientBtn;
		
		
		@FindBy(xpath="//span[contains(@aria-labelledby,'select2-clientUUIDForMock-container')]")
		WebElement mockdropdwnbtn;
		
		
		@FindBy(id="select2-clientUUIDForMock-result-nzfp-0013cf64-e8d1-488e-a712-9b5099c3e2ba")
		WebElement mockselectsubmtbtn;
		
		@FindBy(id="submitMockBtn")
		WebElement submitmockbtn;
		
		@FindBy(className="code-link")
		WebElement codelinkbtn;
		
		@FindBy(id="create")
		WebElement createbtn;
		
		@FindBy(className="select2-search__field")
		WebElement searchbox;
		
		@FindBy(xpath="//li[contains(text(),'believable-magenta-cattle-pg12je19ig@e.rainforestqa.com')]")
		WebElement mockoptionselectionbtn;
		
		
		@FindBy(name="embedname")
		WebElement embedname;
		
		@FindBy(xpath="//div[contains(text(),'Right Rail Embed')]")
		WebElement rightembedbtn;
		
		@FindBy(css="#getstarted > div > form > div.ctas.c0146 > button")
		WebElement letsstartbtn;
		
		
		@FindBy(xpath="//div[contains(@id,'app')]/aside/nav/a/span")
		WebElement createembedbtn;
		
		@FindBy(name="search")
		WebElement searchbtn;
		
		@FindBy(xpath="//span[contains(text(),'Add Question')]")
		WebElement addQuestionbtn;
		
		@FindBy(xpath="//span[contains(text(),'Add Answer')]")
		WebElement addAnsbtn;
		
		
		@FindBy(xpath="//div[contains(@data-text,'Type your question here')]")
		WebElement typeQuestiontext;
		
		@FindBy(css="#customize > div.grouper > div:nth-child(1) > div.formatselector.c0158 > div > div.format.c0159.text1.active")
		WebElement addquestionbackgrndbtn;
		            
		
		@FindBy(css="#customize > div.grouper > div:nth-child(2) > div.embededitor.c0161.rail > div > div > div > div.structure.body > div > div.answerset.c0168.text1.answeramount-4 > div:nth-child(4) > div > div.editorelement.delete.c0172.top.right > div")
		WebElement removeoptionbtn;
		
		@FindBy(xpath="//div[contains(@class,'embed-container')]/div[2]/div[2]/div[1]/div[2]/div[1]")
		WebElement overlaywebtogglebtn;
		
		@FindBy(xpath="//div[contains(@class,'mobile-embed-container')]/div[2]/div[2]/div[1]/div[2]/div[2]")
		WebElement overlaymobiletogglebtn;
		
		@FindBy(xpath="//div[contains(@id,'main')]/div[1]/span[2]/button")
		WebElement frwdbtn;
		
		@FindBy(css="#customize > div.grouper > div:nth-child(2) > div.embededitor.c0161.rail > div > div > div > div.structure.body > div > div.answerset.c0168.text1.answeramount-3 > div:nth-child(2) > div > div.editorelement.correct.c0173.text1.isValid-null.isCorrect-false > div.icon")
		WebElement correctansbtn;
		
		@FindBy(xpath="//div[contains(@class,'callouts c0193')]/div[1]/div[1]/div[2]/div[1]/div[2]")
		WebElement mktrsrchtogbtn;
		
		@FindBy(xpath="//div[contains(@class,'callouts c0193')]/div[3]/div[1]/div[2]/div[1]/div[2]")
		WebElement rewrdtogbtn;
		
		
		@FindBy(xpath="//div[contains(@id,'main')]/div[2]/div[5]/button[2]")
		WebElement finishretrnlibbtn;
		
		@FindBy(css="#library > div:nth-child(2) > div > div > div.cover > div.details > div.name")
		WebElement textvalidatelocation;
		
		@FindBy(xpath="//div[contains(@class,'answerset c0168 text1 answeramount-3')]/div[1]/div[1]/span[3]/div")
		WebElement answerclass1;
				
		@FindBy(xpath="//div[contains(@class,'answerset c0168 text1 answeramount-3')]/div[2]/div[1]/span[3]/div")
		WebElement answerclass2;
		
		@FindBy(xpath="//div[contains(@class,'answerset c0168 text1 answeramount-3')]/div[3]/div[1]/span[3]/div")
		WebElement answerclass3;
		
		@FindBy(css="#customize > div.grouper > div:nth-child(2) > div.embededitor.c0161.rail > div > div > div > div.structure.body > div > div.question.c0166.valid-true > h3 > div")
		WebElement question;
		
		@FindBy(id="unMockBtn")
		WebElement unmockbtn;
		//Initializing the Page element in page factory 
		public LoginPage() {
			
			PageFactory.initElements(driver, this);//this is pointing to current class object
		}
		
		/*This method will take the username,password from the Test class and click on the submit button after which it will
		 * go through the client site drop down and mock the client dynamically, Once the mocking of client is done it will
		 * click on the "here" link to redirect to next page where embed library will be present in a new dashboard
		 */
		public boolean loginmethod(String username, String passwrd) throws Exception {

			login.clear();
			login.sendKeys(username);
			pwd.clear();
			pwd.sendKeys(passwrd);
			loginbtn.click();
			log.info("Application has gone through the login page page successfully");
			clientSitedrpbtn.click();
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			
			mockclientBtn.click();
			
			mockdropdwnbtn.click();
			
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

			searchbox.click();
			searchbox.sendKeys(prop.getProperty("client_to_be_mocked"));
			driver.findElement(By.xpath("//li[contains(text(),'"+prop.getProperty("client_to_be_mocked")+"')]")).click();

			log.info("Selection of client for mocking is done successfully");

	        submitmockbtn.click();
	        codelinkbtn.click();
	        

	     // Perform the click operation that opens new window

	     // Switch to new window opened
	     for(String winHandle : driver.getWindowHandles()){
	         driver.switchTo().window(winHandle);
	     }
	     
	     searchbtn.click();
	     // Perform the actions on new window

	     log.info(" Here link has been clicked and user is now on a new Dashbard");
		return true;			
	
}
		//As the code Architecture is using Page Object Model hence returning the next page/class as an object
		public NewEmbedFlowSelectplacement newembedflowmethod(){
			return new NewEmbedFlowSelectplacement();
		}
		
		//Method for unmocking the client
		public void unmockMethod(){
			unmockbtn.click();
		}
		
		//Method for counting the number of Embed created
		public int listEmbedeMethod() {
			int count=0;	
			List<WebElement> elements = driver.findElements(By.tagName("div"));
			for(WebElement wb : elements) {
				if(wb.getAttribute("class").contains("overlay")) {
					count++;						
				}
			}
			log.info("Embed Created count is:"+count);
			return count;
			}

}