package Saucedemo.cucumber.stepDef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class CheckoutStepDefinitions {
    private final WebDriver driver;

    public CheckoutStepDefinitions(WebDriver driver) {
        this.driver = driver;
    }

    @Given("I am on the Saucedemo shopping cart")
    public void i_am_on_the_saucedemo_shopping_cart() {
        driver.get("https://www.saucedemo.com/cart.html");
    }

    @When("I proceed to checkout")
    public void i_proceed_to_checkout() {
        WebElement checkoutButton = driver.findElement(By.cssSelector(".checkout-button"));
        checkoutButton.click();
    }

    @When("I enter shipping information")
    public void i_enter_shipping_information() {
        WebElement nameField = driver.findElement(By.id("name"));
        nameField.sendKeys("John Doe");
    }

    @When("I enter payment information")
    public void i_enter_payment_information() {
        WebElement cardNumberField = driver.findElement(By.id("card-number"));
        cardNumberField.sendKeys("1234 5678 9012 3456");
    }

    @When("I enter payment information with missing details")
    public void i_enter_payment_information_with_missing_details() {
        WebElement cardNumberField = driver.findElement(By.id("card-number"));
        cardNumberField.sendKeys("1234 5678 9012");
    }

    @When("I confirm the order")
    public void i_confirm_the_order() {
        WebElement confirmOrderButton = driver.findElement(By.cssSelector(".confirm-order-button"));
        confirmOrderButton.click();
    }

    @Then("I should see the order confirmation")
    public void i_should_see_the_order_confirmation() {
        WebElement orderConfirmationPage = driver.findElement(By.cssSelector(".order-confirmation"));
        Assert.assertTrue("Order confirmation page is displayed", orderConfirmationPage.isDisplayed());
    }

    @Then("I should see an error message")
    public void i_should_see_an_error_message() {
        WebElement errorMessageElement = driver.findElement(By.cssSelector(".error-message"));
        Assert.assertTrue("Error message is displayed", errorMessageElement.isDisplayed());
    }
}
