package com.dgmarkt.step_definitions;

import com.dgmarkt.pages.*;
import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

public class CartIconStepDefs {


    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();
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
        mainPage.navigateCategoryDropdown("Televisions");
        cartIconPage.addTheProductCartWithHover(5);
    }

    @Then("{string} message is displayed")
    public void message_is_displayed(String string) {
        cartIconPage.verifySuccessMessage();
        String successMessage = cartIconPage.getSuccessMessageText();
        Assert.assertTrue("Success message should be displayed", !successMessage.isEmpty());
        System.out.println("Success Message: " + successMessage);
    }


    @Then("User should see added product in cart")
    public void user_should_see_added_product_in_cart() throws InterruptedException {
        // Success message'ı kapat
        try {
            WebElement closeButton = Driver.get().findElement(By.cssSelector(".alert-success .close"));
            closeButton.click();
        } catch (Exception e) {
            // Mesaj zaten kapanmiyor
        }

        BrowserUtils.waitFor(1);
        cartIconPage.clickCartIcon();

        BrowserUtils.waitFor(2);

    }

    @Then("Product name, price and quantity should be displayed correctly")
    public void product_name_price_and_quantity_should_be_displayed_correctly() {
        BrowserUtils.waitFor(2);
        // Büyük-küçük harf
        Assert.assertTrue("Product name is incorrect!",
                cartIconPage.getProductName().equalsIgnoreCase("Cello C4020G 40\" Smart LED TV"));

        Assert.assertEquals("Product quantity is incorrect!",
                "1",
                cartIconPage.getQuantity());

        Assert.assertEquals("Product price is incorrect!",
                "$158.00",
                cartIconPage.getPrice());

        // dogrulama mesajlari
        System.out.println(" : Product details have been successfully verified:");
        System.out.println(" : Name: " + cartIconPage.getProductName());
        System.out.println(" : Quantity: " + cartIconPage.getQuantity());
        System.out.println(" : Price: " + cartIconPage.getPrice() + " ");

    }


    @Then("User clicks the “Remove” button")
    public void user_clicks_the_remove_button() {
        cartIconPage.clickRemoveButton();
        cartIconPage.clickCartIcon();
        System.out.println("cartIconPage.getEmptyCartMessage() = " + cartIconPage.getEmptyCartMessage());
    }




}
