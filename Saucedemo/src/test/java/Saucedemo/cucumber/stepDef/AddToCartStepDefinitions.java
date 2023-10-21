package Saucedemo.cucumber.stepDef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class AddToCartStepDefinitions {
    private final WebDriver driver;

    public AddToCartStepDefinitions(WebDriver driver) {

        this.driver = driver;
    }

    @Given("I am on the Saucedemo product page")
    public void i_am_on_the_saucedemo_product_page() {
        driver.get("https://www.saucedemo.com/inventory.html");
    }

    @When("I select a product")
    public void i_select_a_product() {
    }

    @When("I add the product to the cart")
    public void i_add_the_product_to_the_cart() {
        // Find the product element by its name
        Object productName = new Object();
        WebElement productElement = driver.findElement(By.xpath("//div[@class='inventory_item_name' and text()='" + productName + "']"));

        productElement.click();
    }

    @Then("the product should be added to the cart")
    public void the_product_should_be_added_to_the_cart() {
        WebElement cartElement = driver.findElement(By.cssSelector(".cart-icon"));
        Assert.assertTrue("Product is added to the cart", cartElement.isDisplayed());
    }

    @When("I select an unavailable product")
    public void i_select_an_unavailable_product() {
        WebElement unavailableProductElement = driver.findElement(By.cssSelector(".unavailable-product"));
        unavailableProductElement.click();
    }

    @Then("I should see an error message")
    public void i_should_see_an_error_message() {
        WebElement errorMessageElement = driver.findElement(By.cssSelector(".error-message"));
        Assert.assertTrue("Error message is displayed", errorMessageElement.isDisplayed());
    }
}
