package com.dgmarkt.step_definitions;

import com.dgmarkt.pages.LoginPage;
import com.dgmarkt.pages.ShoppingCartPage;
import com.dgmarkt.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckOutStepDefs {

   LoginPage loginPage = new LoginPage();
   ShoppingCartPage shoppingCartPage = new ShoppingCartPage();


    @When("User clicks the {string} button")
    public void user_clicks_the_button(String string) {
        shoppingCartPage.ClickCheckOutInCartIcon();
    }
    @Then("The user fills in the {string} page and clicks {string} button.")
    public void the_user_fills_in_the_page_and_clicks_button(String string, String string2) {
     shoppingCartPage.CheckoutOptionsCoBttn();
     shoppingCartPage.fillAllBillingDetails();
     //shoppingCartPage.checkSameAddressBox();
     shoppingCartPage.acceptPrivacyPolicy();
     shoppingCartPage.clickBillingContinueButton();

    }
    @Then("In the {string} section, the user selects {string} and clicks the {string} button")
    public void in_the_section_the_user_selects_and_clicks_the_button(String string, String string2, String string3) {

     shoppingCartPage.clickDeliveryDetailsContinueButton();
    }
    @Then("Select {string} on the {string} page and click on the {string} button.")
    public void select_on_the_page_and_click_on_the_button(String string, String string2, String string3) {
     shoppingCartPage.clickDeliveryMethodContinueButton();

    }
    @Then("The user selects the {string} as cash and clicks on the {string} box without leaving a comment and clicks on the {string} button")
    public void the_user_selects_the_as_cash_and_clicks_on_the_box_without_leaving_a_comment_and_clicks_on_the_button(String string, String string2, String string3) {

     shoppingCartPage.acceptPrivacyPolicy();
     shoppingCartPage.clickPaymentMethodContinueButton();


    }
    @Then("The user checks the product in the {string} section and clicks the {string} button")
    public void the_user_checks_the_product_in_the_section_and_clicks_the_button(String string, String string2) {



     shoppingCartPage.confirmOrderBtn();

    }
    @Then("The user completes the order and goes to the page with the message {string}")
    public void the_user_completes_the_order_and_goes_to_the_page_with_the_message(String string) {
     shoppingCartPage.orderDoneHeader();


    }

}
