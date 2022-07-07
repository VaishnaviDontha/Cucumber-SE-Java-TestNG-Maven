package stepdefs;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class loginDatatables {

    WebDriver driver;

    @Given("Launch chrome browser")
    public void launch_chrome_browser() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        driver.get("https://the-internet.herokuapp.com/login");
    }

    @When("Enter username and password")
    public void enter_username_and_password(DataTable table) throws Throwable {

        // List<List<String>> rows = table.asLists(String.class);

        // driver.findElement(By.cssSelector("#username")).sendKeys(rows.get(0).get(0));
        // driver.findElement(By.cssSelector("#password")).sendKeys(rows.get(0).get(1));

        for (Map<String, String > data : table.asMaps(String.class, String.class)) {

            System.out.println(data.get("username"));
            driver.findElement(By.cssSelector("#username")).sendKeys(data.get("username"));
            
            System.out.println(data.get("password"));
            driver.findElement(By.cssSelector("#password")).sendKeys(data.get("password")); 
            
        }

    }

    @Then("Hit login button")
    public void hit_login_button() {

        driver.findElement(By.xpath("//button[@type='submit']")).submit();

    }

    @After
    public void tearDown() {

        driver.quit();
        
    }

}
