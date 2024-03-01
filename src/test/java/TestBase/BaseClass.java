package TestBase;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class BaseClass {
	public static WebDriver driver;
	JavascriptExecutor js;
	WebDriverWait mywait;
	public Logger logger;
	@BeforeClass
	@Parameters({"browser","execution_env","os"})
	public void createdriver(String br,String env,String os) throws MalformedURLException
	{
		//java -jar selenium-server-4.18.1.jar standalone
		logger=LogManager.getLogger(this.getClass());
		logger.info("------------------Opening the Browser---------------");
		if(env.equalsIgnoreCase("remote"))
		{
			
			
			
			DesiredCapabilities capabilities=new DesiredCapabilities();
			
			//os
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("No matching os..");
				return;
			}
			
			//browser
			switch(br.toLowerCase())
			{
			case "chrome" : capabilities.setBrowserName("chrome"); break;
			case "edge" : capabilities.setBrowserName("MicrosoftEdge"); break;
			default: System.out.println("No matching browser.."); return;
			}
			
			driver = new RemoteWebDriver(new URL ("http://localhost:4444/wd/hub"), capabilities);
			
		    }
		else if(env.equalsIgnoreCase("local"))
		{
				//launching browser based on condition - locally
			if(br.equalsIgnoreCase("chrome")) {
				driver=new ChromeDriver();
					
				}
				else if(br.equalsIgnoreCase("edge")) {
					driver=new EdgeDriver();
					//driver.get(prop.getProperty("link"));
				}
				else {
					System.out.println("There are no browser");
				}
			}
	   
	   driver.get("https://www.coursera.org/");
	   logger.info("------------------Launching the URL---------------");
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	@AfterClass
	public void tearDown()
	{
		logger.info("------------------Closing the Browser---------------");
		driver.quit();
	}

	public static String captureScreen(String name) 
	{
		
		
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + name + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		sourceFile.renameTo(targetFile);
		return targetFilePath;
		
	}

}
