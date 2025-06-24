package com.dgmarkt.step_definitions;

import com.dgmarkt.utilities.ConfigurationReader;
import com.dgmarkt.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefs {
    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }
    @When("User enters valid credentials")
    public void user_enters_valid_credentials() {

    }
    @Then("User verifies that main page is visible")
    public void user_verifies_that_main_page_is_visible() {



    }
}
