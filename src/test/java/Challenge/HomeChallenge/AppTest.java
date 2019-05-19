package Challenge.HomeChallenge;




import java.util.List;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Challenge.HomeChallenge.Base.Base;
import ScreenShot.TakeScreenShot;


/*This Class has all the Test data, Assertions and a common method which is used to count the category 
 * of the application */

//This is used for Report Generation purpose by using Extent Reporting
@Listeners(Challenge.HomeChallenge.ExtentReportListener.ExtentReportNG.class)
public class AppTest extends Base
{
   LoginPage loginpage;
   NewEmbedFlowSelectplacement newembed;
   NewEmbedFlowCustomize cust;
   NewEmbedFlowSelectAds selectAd;
   NewEmbedFlowRevenue rev;
   NewEmbedFlowPublish publish;
   Validation valid;
   boolean flag;
   String[] anslist=prop.getProperty("embed_answers").split(",");
   
 
   
   /*This Method is used to call the method from the Base class where the drivers,location of config file  are initialized and opening of URL is done  */
   @BeforeClass
   	public void beforeclassmethod() throws Exception{
	   initialisation();
	   loginpage=new LoginPage();
	   newembed=new NewEmbedFlowSelectplacement();
	   cust=new NewEmbedFlowCustomize();
	   selectAd=new NewEmbedFlowSelectAds();
	   rev=new NewEmbedFlowRevenue();
	   publish=new NewEmbedFlowPublish();
	   valid=new Validation();
   	}
   
    public AppTest()
    {
        super();
    }

   /*Actual Test cases starts from here I have used Priority tag to run my test cases can also use other annotation like Depend etc*/ 
   /*This method is used to test login page*/
    @Test(priority=1)
    public void loginPageTest() throws Exception {
    
    	 flag=loginpage.loginmethod(prop.getProperty("new_username"),prop.getProperty("newuser_pass"));
    	newembed=loginpage.newembedflowmethod();
    	Assert.assertEquals(flag,true);
    }

    //Test Case for create the embed with the given name , selecting the "Right Rail Embed" and move on the tab by clicking on the forward/next arrow
    @Test(priority=2)
    public void newEmbedFlowTest()  {
    	flag=newembed.newembedflow();
    	Assert.assertEquals(flag,true);
    }

    //Test Case for add the Question,Answers,Adding of answer block & Remove the answer block*/
    @Test(priority=3)
    public void newEmbedFlowCustomizeTest()  {
    	cust=newembed.customizeMethod();
    	flag=cust.flowcustMethod(anslist[0],anslist[1],anslist[2]);
    	Assert.assertEquals(flag,true);
    }
    
    //Test Case for Web & Mobile Overly Ad as On
    @Test(priority=4)
    public void newEmbedFlowSelectAdsTest()  {
    	selectAd=cust.selectAdTabMethod();
    	flag=selectAd.selectAdMethod();
    	Assert.assertEquals(flag,true);
    	
    }
    
    //Test Case for Market Research & Reward to Off by clicking on the toggle button*/
    @Test(priority=5)
    public void newEmbedFlowRevenueTest() {
    	rev=selectAd.revenueTabMethod();
    	flag=rev.revenueMethod();
    	Assert.assertEquals(flag,true);
    	
    }
    
    //Test Case for finish & return to Library button
    @Test(priority=6)
    public void newEmbedFlowPublishTest() throws Exception {
    	publish=rev.publishTabMethod();
    	flag=publish.publishMethod();
    	Assert.assertEquals(flag,true);
    	
    }
    
    /* Test Case for validate all the 3 condition given in the task to validate 
    a. Check if the embed created exists with the given name
    b. Click on that embed and check if the count of content available is 1
    c. Check if the titles of the question and option answers match with the value
    entered through the script steps */
    
    @Test(priority=7)
    public void newEmbedFlowValidationTest()  {
    	valid=publish.validatingMethod();
    	String NameOfEmbedCreated=valid.validationEmbedNameCreatedMethod();
    	log.info("Name of Embed Created:"+NameOfEmbedCreated);
    	Assert.assertEquals(NameOfEmbedCreated,prop.getProperty("embed_creation_name"));
    	int count=valid.validationEmbedNoOfCreatedMethod();
    	log.info("Number of Embed Created with the given name:"+count);
    	Assert.assertEquals(count,1);
    	String ques=valid.validationQuestionMethod();
    	log.info("Quesstion asked was:"+ques);
    	Assert.assertEquals(ques,prop.getProperty("embed_question"));
    	List<String> answerlist=valid.validationAnswerMethod();
    	for(int i=0;i<answerlist.size();i++){
    		log.info("Answers are:"+answerlist.get(i));
    		Assert.assertEquals(anslist[i],answerlist.get(i));
    	}
    	loginpage.unmockMethod();
    }
    
    @AfterMethod
	public void tearDown(ITestResult result) {
		TakeScreenShot.captureScreenshot(driver,result.getName(),result.getStatus());
	}
    
    @AfterClass
    public void teardownclass(){
    	driver.quit();
    }
	
}
