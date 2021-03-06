package Challenge.HomeChallenge.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;



public class Base 
{
	public static WebDriver driver;
	public static Properties prop;
	public static Logger log= LogManager.getLogger(Base.class);
	
	
	//Constructor using for reading the config properties file
	public Base(){
		WebDriverManager.firefoxdriver().setup();
		WebDriverManager.chromedriver().setup();
		
		
		try {
			prop =new Properties();
			String dir_path =System.getProperty("user.dir");
			FileInputStream ip= new FileInputStream(dir_path+"/src/main/java/Challenge/HomeChallenge/Configuration/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//Method used to initialize the Browser and launching the URL 
	public static void initialisation()  {
		
		
		String browserName=  prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			driver=new ChromeDriver();
		}else if(browserName.equals("ff")) {
			driver= new FirefoxDriver();
		}else if(browserName.equals("safari")) {
			driver= new SafariDriver();
		}
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		log.info("Class Base > initialisation method has been invoked ");
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	
	//Method for waiting the element to be visible 
	public static void waitForElement(WebDriver driver, WebElement element)  {
		
		try{
		WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(element));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        
	}catch (Exception e){
		
	}
		
	}
	
	//Method for waiting the element to be clickable 
public static void clickForElement(WebDriver driver, WebElement element)  {
		
		try{
		WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        
	}catch (Exception e){
		
	}
		
	}
}
