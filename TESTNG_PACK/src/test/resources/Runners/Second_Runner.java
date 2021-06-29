package Runners;




import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(
		 plugin = {"pretty"
	        },
	        features = {"FEA_FILES/Features/MavenLaunch.feature"},
	        glue = {"STEP_defn"},
	        tags = "@MavenLaunch",
	        monochrome=true
	        
		)

public class Second_Runner {
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
