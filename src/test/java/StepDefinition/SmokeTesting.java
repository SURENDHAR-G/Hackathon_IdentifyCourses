package StepDefinition;

import java.io.IOException;



import factory.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.ErrorMessage;
import pageObject.LanguageLearningCourses;
import pageObject.WebDevelopmentCourses;

public class SmokeTesting {
	//public WebDriver driver=new ChromeDriver();
	WebDevelopmentCourses WDC=new WebDevelopmentCourses(Base.getDriver());
	LanguageLearningCourses LLC=new LanguageLearningCourses(Base.getDriver());
	@Given("user search the WebDevelopment courses")
	public void user_search_the_web_development_courses() throws InterruptedException, IOException {
		
	   
		WDC.SearchWebDevelpoment();
		
		
	}

	@When("user click on the webDevelopment Skill in the Filter")
	public void user_click_on_the_web_development_skill_in_the_filter() throws InterruptedException, IOException {
		
		
		WDC.clickonWebDevelopment();
		
	}

	@When("user search the Language Learning")
	public void user_search_the_language_learning() throws IOException {
		
		LLC.HomePage();
		
		
		
	}

	@When("user Click on the Language Learning  in Filter")
	public void user_click_on_the_language_learning_in_filter() throws IOException {
		LLC.selectLanguageLearning();
		
	}

	@Then("user navigate to the Form")
	public void user_navigate_to_the_form() throws InterruptedException {
		ErrorMessage EM=new ErrorMessage(Base.getDriver());
		
		EM.navigateToForm();
		
	}


}
