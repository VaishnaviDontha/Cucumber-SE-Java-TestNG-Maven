package stepdefs;

import io.cucumber.java.en.*;

public class testDefination {
    
    @Given("Test given step")
    public void test_given_step() {
        
        System.out.println("Given Statement Step");
        
    }

    @When("Test when step")
    public void test_when_step() {
 
        System.out.println("When Statement Step");
    }
    
    @Then("Test then step")
    public void test_then_step() {
 
        System.out.println("Then Statement Step");
    }

    @And("Test and step")
    public void test_and_step() {
 
        System.out.println("And Statement Step");
    }
 
}
