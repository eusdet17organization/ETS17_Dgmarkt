package com.dgmarkt.step_definitions;

import com.dgmarkt.pages.LoginPage;
import com.dgmarkt.pages.LoginPanelPage;
import com.dgmarkt.pages.MainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartIconStepDefs {

    LoginPanelPage loginPanelPage=new LoginPanelPage();

    MainPage mainPage=new MainPage();

    LoginPage loginPage = new LoginPage();
    @Given("User clicks on cart icon")
    public void user_clicks_on_cart_icon() {

        throw new io.cucumber.java.PendingException();
    }
    @Then("{string} must see your message")
    public void must_see_your_message(String string) {

        throw new io.cucumber.java.PendingException();}


    @When("User adds a product to cart")
    public void user_adds_a_product_to_cart() {

        throw new io.cucumber.java.PendingException();
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
