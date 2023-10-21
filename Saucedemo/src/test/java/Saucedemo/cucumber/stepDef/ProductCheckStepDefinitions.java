package Saucedemo.cucumber.stepDef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class ProductCheckStepDefinitions {
    private final WebDriver driver;

    public ProductCheckStepDefinitions(WebDriver driver) {
        this.driver = driver;
    }

    @Given("I am on the Saucedemo product page")
    public void i_am_on_the_saucedemo_product_page() {
        driver.get("https://www.saucedemo.com/inventory.html");
    }

    @When("I select a product")
    public void i_select_a_product() {
        WebElement productElement = driver.findElement(By.xpath("//div[@class='product' and contains(text(),'Sauce Labs Backpack')]"));
        productElement.click();
    }

    @Then("I should see the product details")
    public void i_should_see_the_product_details() {
        WebElement productDetailsElement = driver.findElement(By.cssSelector(".product-details"));
        Assert.assertTrue("Product details are displayed", productDetailsElement.isDisplayed());
    }

    @When("I select an unavailable product")
    public void i_select_an_unavailable_product() {
        WebElement unavailableProductElement = driver.findElement(By.cssSelector(".unavailable-product"));
        unavailableProductElement.click();
    }

    @Then("I should see a message indicating unavailability")
    public void i_should_see_a_message_indicating_unavailability() {
        WebElement unavailabilityMessageElement = driver.findElement(By.cssSelector(".unavailability-message"));
        Assert.assertTrue("Unavailability message is displayed", unavailabilityMessageElement.isDisplayed());
    }
}
