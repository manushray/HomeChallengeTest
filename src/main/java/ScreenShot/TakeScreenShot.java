package ScreenShot;

import java.io.File;
import java.sql.Timestamp;
import java.util.Date;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Challenge.HomeChallenge.Base.Base;






public class TakeScreenShot extends Base{

	public static void captureScreenshot(WebDriver driver,String caseName,int testStatus)
	{
		try {
		
		String statusValue=null;
		
		if(testStatus==1)
		{
			statusValue="pass";
		}			
		else
		{	
		     statusValue="fail";		
		}	
			
		Date date = new Date();
		Timestamp stamp= new Timestamp(date.getTime());
		String timeStamp= stamp.toString();
		String fileName=caseName+"_"+statusValue+"_"+timeStamp;
		
		TakesScreenshot t = (TakesScreenshot)driver;
		File source = t.getScreenshotAs(OutputType.FILE);
		
		
		
		FileUtils.copyFile(source,new File(prop.getProperty("ScreenShotPath")+"/"+fileName+".png"));
		System.out.println(prop.getProperty("ScreenShotPath")+"/"+fileName+".png");
		
		
		 
		
	
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	
	
}
