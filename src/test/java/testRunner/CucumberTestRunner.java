package testRunner;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "",
                features = "src/test/resources/features/testFeatureFile.feature",
                glue = "src/test/java/stepdefs/")
public class CucumberTestRunner {
    
}
