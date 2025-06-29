package com.dgmarkt.step_definitions;

import com.dgmarkt.pages.*;
import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartIconStepDefs {



    SearchPage searchPage=new SearchPage();

    CartIconPage cartIconPage = new CartIconPage();

    @Given("User clicks on cart icon")
    public void user_clicks_on_cart_icon() {
        cartIconPage.clickCartIcon();
    }
    @Then("{string} must see your message")
    public void must_see_your_message(String string) {
        Assert.assertTrue(Driver.get().findElement(By.cssSelector("p.text-center")).isDisplayed());
        System.out.println(cartIconPage.getEmptyCartMessage());


        }


    @When("User adds a product to cart")
    public void user_adds_a_product_to_cart() {
        BrowserUtils.waitForClickablility(cartIconPage.searchButton, 10);
        cartIconPage.searchButton.click();

        BrowserUtils.waitForVisibility(cartIconPage.searchInput, 10);
        cartIconPage.searchInput.clear();
        cartIconPage.searchInput.sendKeys("Belkin Standard HDMI cable");
        cartIconPage.searchInput.sendKeys(Keys.ENTER);

        BrowserUtils.waitFor(2);
        cartIconPage.productImage.click();




    }

    @Then("{string} message is displayed")
    public void message_is_displayed(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @Then("User should see added product in cart")
    public void user_should_see_added_product_in_cart() {

        throw new io.cucumber.java.PendingException();
    }
    @Then("Product name, price and quantity should be displayed correctly")
    public void product_name_price_and_quantity_should_be_displayed_correctly() {

        throw new io.cucumber.java.PendingException();
    }

    @Then("User clicks the “Remove” button")
    public void user_clicks_the_remove_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
