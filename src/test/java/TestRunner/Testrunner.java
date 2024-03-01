package TestRunner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
		
		features= {".//FeatureFile/01_Course_details.feature",".//FeatureFile/02_select_Language_learning.feature",
				".//FeatureFile/03_Capture_the_error_Message.feature"},
		//features= {".//FeatureFile/"},
		glue="StepDefinition",
				plugin= {"pretty", "html:reports/myreport.html", 
						  "rerun:target/rerun.txt",
						  },
		
		dryRun=false,
		monochrome=true,
		publish=true
		//tags="@Smoke"
		//tags="@regression"
		)
public class Testrunner {

	
	
}