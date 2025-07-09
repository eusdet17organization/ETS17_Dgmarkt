package com.dgmarkt.step_definitions;
import com.dgmarkt.pages.*;
import com.dgmarkt.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;


public class CheckOutStepGeneralDefs {


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

    public String searchProduct;
    @Then("User searches for the {string} in the search bar")
    public void user_searches_for_the_in_the_search_bar(String product) {
        searchPage.searchText.sendKeys(product);
        searchPage.searchIconWithSearchText.click();
        searchProduct=product;


    }

    @When("User searches for the {string} Smart LED TV\" in the search bar")
    public void user_searches_for_the_smart_led_tv_in_the_search_bar(String product) {

    }
    @Then("User click the product and {string} button")
    public void user_click_the_product_and_button(String string) {
        cartIconPage.addTheProductCartWithHover(0);
        cartIconPage.clickCartIcon();
        BrowserUtils.waitFor(3);
        checkoutPage.CheckOutBtnInCart();
    }

}


