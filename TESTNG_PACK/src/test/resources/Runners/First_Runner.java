package Runners;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;


@CucumberOptions(
		 format = {"pretty",
	                "html:target/cucumber-reports/cucumber-pretty",
	                "json:target/cucumber-reports/CucumberTestReport.json",
	                "rerun:target/cucumber-reports/rerun.txt"
	        },
	        features = {"FEA_FILES/Features/GoogleLaunch.feature"},
	        glue = {"STEP_defn"},
	        tags = "@Goole",
	        plugin = "json:target/cucumber-reports/CucumberTestReport.json",
	        monochrome=true
	        
		)

public class First_Runner  {
	private TestNGCucumberRunner testNGCucumberRunner;
	@BeforeClass(alwaysRun = true)
	public void setUpCucumber() {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
   }

	@Test(groups = "cucumber",description = "Runs Cucumber Feature", dataProvider = "feature")
    public void feature(CucumberFeatureWrapper cucumberFeature) {

        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());

    }
	
	@DataProvider
	public Object[][] feature(){
		return testNGCucumberRunner.provideFeatures();
	}
	
	 
	    @AfterClass(alwaysRun = true)
	    public void tearDownClass() throws Exception {
	        testNGCucumberRunner.finish();
	    }

}
