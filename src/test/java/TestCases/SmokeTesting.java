package TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObject.ErrorMessage;
import pageObject.LanguageLearningCourses;
import pageObject.WebDevelopmentCourses;

public class SmokeTesting extends BaseClass{
	
	
	@Test(priority=1)
	public void user_search_the_web_development_courses() throws InterruptedException, IOException {
		
		WebDevelopmentCourses WDC=new WebDevelopmentCourses(driver);
		WDC.SearchWebDevelpoment();
		
		
	}

	@Test(priority=2)
	public void user_click_on_the_web_development_skill_in_the_filter() throws InterruptedException, IOException {
		
		WebDevelopmentCourses WDC=new WebDevelopmentCourses(driver);
		WDC.clickonWebDevelopment();
		
	}

	@Test(priority=3)
	public void user_search_the_language_learning() throws IOException {
		LanguageLearningCourses LLC=new LanguageLearningCourses(driver);
		LLC.HomePage();
		
		
		
	}

	@Test(priority=4)
	public void user_click_on_the_language_learning_in_filter() throws IOException {
		LanguageLearningCourses LLC=new LanguageLearningCourses(driver);
		LLC.selectLanguageLearning();
		
	}

	@Test(priority=5)
	public void user_navigate_to_the_form() throws InterruptedException {
		ErrorMessage EM=new ErrorMessage(driver);
		
		EM.navigateToForm();
		
	}


}