package TestCases;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import TestBase.BaseClass;
import pageObject.WebDevelopmentCourses;

class RegressionTesting extends BaseClass
{



	@Test(priority=0)
	public void Select_the_WebDevelopment_Skill() throws InterruptedException, IOException
	{
		WebDevelopmentCourses WDC=new WebDevelopmentCourses(driver);
	    logger.info("------------------Search for WebDevelopment Courses --------------");
		WDC.SearchWebDevelpoment();
		//Thread.sleep(3000);
		logger.info("------------------Select the WebDevelopment Skill---------------");
		WDC.clickonWebDevelopment();
		
	}
	@Test(priority=1)
	public void Select_the_English_And_Beginner() throws InterruptedException
	{
		WebDevelopmentCourses WDC=new WebDevelopmentCourses(driver);
		//Thread.sleep(4000);
		logger.info("------------------Select the English Language---------------");
		WDC.selecttheEnglishLanguage();
		//Thread.sleep(4000);
		logger.info("------------------Select the Level of course---------------");
		WDC.selectthelevel();
		
	}
	@Test(priority=2)
	public void Fetch_the_Course_Details() throws InterruptedException, IOException
	{
		WebDevelopmentCourses WDC=new WebDevelopmentCourses(driver);
		JavascriptExecutor js=(JavascriptExecutor)driver;
     	js.executeScript("window.scrollBy(0,-700)");
     	Thread.sleep(3000);
     	logger.info("------------------Fetching the Course details---------------");
     	WDC.CoursesDetails();
	}
}