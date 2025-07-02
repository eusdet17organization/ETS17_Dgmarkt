package com.dgmarkt.step_definitions;

import com.dgmarkt.pages.ViewCartPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ViewCartStepDefs {
    ViewCartPage viewCartPage = new ViewCartPage();



    @When("The User click the {string} button")
    public void the_user_click_the_button(String buttonName) {
        if (buttonName.equals("View Cart")) {
            viewCartPage.clickViewCartButton();
        }
    }

    @Then("The user sees the {string} banner and accesses the cart")
    public void the_user_sees_the_banner_and_accesses_the_cart(String expectedBanner) {
        Assert.assertTrue(viewCartPage.isShoppingCartBannerDisplayed());
        System.out.println("viewCartPage.getShoppingCartBannerText() = " + viewCartPage.getShoppingCartBannerText());

    }
}
