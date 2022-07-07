package testRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features/testFeatureFile.feature", 
    glue = "stepdefs",
    // plugin = {""},
    tags = "@FunTest and not @smoke")
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

}
