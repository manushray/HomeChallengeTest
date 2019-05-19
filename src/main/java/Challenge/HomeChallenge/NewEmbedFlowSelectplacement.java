package Challenge.HomeChallenge;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/*This class will create the embed with the given name , selecting the "Right Rail Embed" and move on the tab by clicking on the forward/next arrow*/
public class NewEmbedFlowSelectplacement extends LoginPage{

	public boolean newembedflow() {
		
		 createembedbtn.click();
	     embedname.sendKeys(prop.getProperty("embed_creation_name"));
	     log.info("Passing of embed name is done successfully");
	     letsstartbtn.click();
	     driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	     rightembedbtn.click();
	     WebElement ele=driver.findElement(By.className("formatcontainer"));
	     ele.findElement(By.cssSelector("#customize > div.grouper > div:nth-child(1) > div.formatselector.c0158 > div > div.format.c0159.text1.inactive")).click();
	     driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	     log.info("Embed name tab functionality is done successfully");
	     return true;
	}
	
	public NewEmbedFlowCustomize customizeMethod(){
		return new NewEmbedFlowCustomize();
	}
}
