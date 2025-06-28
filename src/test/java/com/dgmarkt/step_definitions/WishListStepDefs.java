package com.dgmarkt.step_definitions;


import com.dgmarkt.pages.LoginPage;
import com.dgmarkt.pages.LoginPanelPage;
import com.dgmarkt.pages.MainPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WishListStepDefs {
    LoginPanelPage loginPanelPage=new LoginPanelPage();

    MainPage mainPage=new MainPage();

    LoginPage loginPage = new LoginPage();
    @When("User hovers over the product and clicks the wish list button")
    public void user_hovers_over_the_product_and_clicks_the_wish_list_button() {

    }
    @Then("User wish list sees added pop-ups")
    public void user_wish_list_sees_added_pop_ups() {

    }
    @Then("User clicks on the wish list that appears in the pop-up")
    public void user_clicks_on_the_wish_list_that_appears_in_the_pop_up() {

    }
    @Then("User confirms that the product has been added to the wish list")
    public void user_confirms_that_the_product_has_been_added_to_the_wish_list() {

    }

    @When("the user clicks the close button on the top right of the product")
    public void the_user_clicks_the_close_button_on_the_top_right_of_the_product() {
        
    }
    @Then("user confirms that the base has been deleted")
    public void user_confirms_that_the_base_has_been_deleted() {

    }
    @Then("user  Success: You have modified your wish list!sees your message")
    public void user_success_you_have_modified_your_wish_list_sees_your_message() {

    }



}
