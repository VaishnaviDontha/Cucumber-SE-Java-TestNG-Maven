package stepdefs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class loginDefination {

    WebDriver driver;

    // @Given("Launch chrome browser")
    // public void launch_chrome_browser() {

    //     WebDriverManager.chromedriver().setup();
    //     driver = new ChromeDriver();

    //     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    //     driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

    //     driver.get("https://the-internet.herokuapp.com/login");
    // }

    // @And("Enter {string} and {string}")
    // public void enter_and(String uname, String pwd) {

    //     driver.findElement(By.cssSelector("#username")).sendKeys(uname);
    //     driver.findElement(By.cssSelector("#password")).sendKeys(pwd);

    // }

    // @When("Hit login button")
    // public void hit_login_button() {

    //     driver.findElement(By.cssSelector(".radius")).submit();

    // }

    // @Then("User must see the text {string}")
    // public void user_must_see_the_text(String expectedString) {

    //     String actualString = driver.findElement(By.cssSelector("#flash")).getText();
    //     System.out.println(actualString);


    // }

}
