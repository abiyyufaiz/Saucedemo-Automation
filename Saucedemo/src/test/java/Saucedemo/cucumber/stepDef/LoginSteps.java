package Saucedemo.cucumber.stepDef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Assert;
import static org.junit.Assert.assertTrue;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class LoginSteps {

    private final WebDriver driver;

    public LoginSteps(WebDriver driver) {
        this.driver = driver;
    }

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("I enter valid username and password")
    public void i_enter_valid_username_and_password() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @When("I enter invalid username and password")
    public void i_enter_invalid_username_and_password() {
        driver.findElement(By.id("user-name")).sendKeys("invalid_user");
        driver.findElement(By.id("password")).sendKeys("invalid_password");
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("I should be logged in")
    public void i_should_be_logged_in() {
        WebElement welcomeMessage = driver.findElement(By.xpath("//div[@class='title' and contains(text(),'Welcome,')]"));
        assertTrue("Welcome message is displayed", welcomeMessage.isDisplayed());
    }

    @Then("I should see an error message")
    public void i_should_see_an_error_message() {
        WebElement errorMessageElement = null;
        Assert.assertTrue("Error message is displayed", errorMessageElement.isDisplayed());

        String errorMessageText = errorMessageElement.getText();
        Assert.assertTrue("Error message text is as expected", errorMessageText.contains("expected_error_message_text"));
    }
}
