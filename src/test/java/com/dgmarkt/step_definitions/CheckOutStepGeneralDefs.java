package com.dgmarkt.step_definitions;

import com.dgmarkt.pages.CheckoutPage;
import com.dgmarkt.pages.LoginPage;
import com.dgmarkt.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckOutStepGeneralDefs {

    CheckoutPage checkoutPage = new CheckoutPage();
    LoginPage loginPage = new LoginPage();
    @Then("The user Login with MyAccount page")
    public void the_user_login_with_my_account_page() {
        loginPage.userLogin();

    }

    @When("User adds a product to cart with {string} button")
    public void user_adds_a_product_to_cart_with_button(String string) {
        BrowserUtils.waitFor(2);

        checkoutPage.addProductToCartWithStock();




    }

    @Then("User copmlete the order steps")
    public void user_copmlete_the_order_steps() {
        checkoutPage.completeOrder();
    }
}
