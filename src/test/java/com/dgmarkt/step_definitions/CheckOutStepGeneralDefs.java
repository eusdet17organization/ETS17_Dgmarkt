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

    protected String product;
    @Then("When User click the search icon {string} and search")
    public void when_user_click_the_search_icon_and_search(String product) {
        BrowserUtils.waitForClickablility(searchPage.searchIcon,5);
        searchPage.searchIcon.click();
        BrowserUtils.waitForClickablility(searchPage.searchText,5);
        searchPage.searchText.sendKeys(product);
        this.product=product;
        BrowserUtils.waitForClickablility(searchPage.searchIconWithSearchText,5);
        searchPage.searchIconWithSearchText.click();
    }

    @Then("User click the product and {string} button")
    public void user_click_the_product_and_button(String string) {
        cartIconPage.addTheProductCartWithHover(0);
        cartIconPage.clickCartIcon();
        Assert.assertTrue(Driver.get().findElement(By.partialLinkText(product)).getText().contains(product));
        System.out.println(" : Product details have been successfully verified:");
        System.out.println(" : Name: " + cartIconPage.getProductName());
        checkoutPage.CheckOutBtnInCart();

    }

}


