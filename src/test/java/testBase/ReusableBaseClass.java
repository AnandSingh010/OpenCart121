package testBase;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;//log4j
import org.apache.logging.log4j.Logger;//log4j
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class ReusableBaseClass {
	
	
	public static WebDriver driver;
	public Logger logger; //log4j
	public Properties p;
	
	@BeforeClass(groups= {"Sanity","Regression","master"})
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException 
	{
		
		//loading config.properties file
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p= new Properties();
		p.load(file);
		
		logger = LogManager.getLogger(this.getClass());
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			
			DesiredCapabilities cap = new DesiredCapabilities();
			
			if(os.equalsIgnoreCase("windows")) {
				
				cap.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("linux"))
			{
				cap.setPlatform(Platform.LINUX);
			}
			else {
				System.out.println("No matching os");
			}
			
			
			switch(br.toLowerCase())
			{
			
			case "chrome" : cap.setBrowserName("chrome");break;
			case "firefox" : cap.setBrowserName("firefox"); break;
			default: System.out.println("No matching browser");return;
			
			}
			
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
			
		}
		
		if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
			
			switch(br.toLowerCase()) {
			case "chrome": driver= new ChromeDriver();break;
			case "firefox": driver= new FirefoxDriver();break;
			case "edge" : driver=new  EdgeDriver();break;
			default : System.out.println("Invalid browser name..");return;
			
		}
		
		
		
		}
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appURL"));// reading url from properties file.
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups= {"Sanity","Regression","master"})
	public void teardown() {
		driver.quit();
	}
	
	
	public String randomeString() {
		String generatedString =RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public String randomAlphaNumeric() {
		String generatedString =RandomStringUtils.randomAlphabetic(5);
		String generatedNum=RandomStringUtils.randomNumeric(3);
		return (generatedString+generatedNum);
	}
	
	public String captureScreen(String tname) throws IOException{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.hh.ss").format(new Date());
		
		TakesScreenshot tk = (TakesScreenshot) driver;
		File sourceFile = tk.getScreenshotAs(OutputType.FILE);
		String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\"+ tname +"_"+ timeStamp + ".png";
		
		File targetFile = new File(targetFilePath);
		sourceFile.renameTo(targetFile);
		return targetFilePath;
		
	}
	
}
