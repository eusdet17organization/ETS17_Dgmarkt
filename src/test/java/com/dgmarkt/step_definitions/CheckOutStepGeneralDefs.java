package com.dgmarkt.step_definitions;

import com.dgmarkt.pages.*;
import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.dgmarkt.utilities.Driver.driver;

public class CheckOutStepGeneralDefs {

    MainPage mainPage = new MainPage();
    CartIconPage cartIconPage = new CartIconPage();
    SearchPage searchPage = new SearchPage();
    CheckoutPage checkoutPage = new CheckoutPage();
    LoginPage loginPage = new LoginPage();

    @Then("The user Login with MyAccount page")
    public void the_user_login_with_my_account_page() {
        loginPage.userLogin();

    }

    @When("User adds a product to cart with {string} button")
    public void user_adds_a_product_to_cart_with_button(String string) {
        BrowserUtils.waitFor(5);
        checkoutPage.addProductToCartWithStock();
    }

    @Then("User copmlete the order steps")
    public void user_copmlete_the_order_steps() {
        checkoutPage.completeOrder();
    }

    // *
    @Then("User navigate to search button")
    public void user_click_the_search_icon() {
        searchPage.searchIcon.click();

    }

    @Then("User searches for the product in the search bar")
    public void user_searches_for_the_product_in_the_search_bar() {

        searchPage.searchText.sendKeys("Cello C4020G 40\" Smart LED TV");
        searchPage.searchIconWithSearchText.click();


    }

    @Then("User click the product and {string} button")
    public void user_click_the_product_and_button(String string) {
        cartIconPage.addTheProductCartWithHover(0);
        cartIconPage.clickCartIcon();
        checkoutPage.CheckOutBtnInCart();
    }

}


