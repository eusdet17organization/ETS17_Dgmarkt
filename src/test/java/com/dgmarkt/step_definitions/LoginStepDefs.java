package com.dgmarkt.step_definitions;

import com.dgmarkt.pages.LoginPage;
import com.dgmarkt.pages.LoginPanelPage;
import com.dgmarkt.pages.MainPage;
import com.dgmarkt.utilities.ConfigurationReader;
import com.dgmarkt.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {

    LoginPanelPage loginPanelPage = new LoginPanelPage();

    MainPage mainPage = new MainPage();

    LoginPage loginPage = new LoginPage();


    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("User enters valid credentials")
    public void user_enters_valid_credentials() {
        loginPanelPage.loginPanel();
        mainPage.closePopUp();
    }

    @Then("User verifies that main page is visible")
    public void user_verifies_that_main_page_is_visible() {
        Assert.assertTrue(Driver.get().getTitle().equals("Your Store"));
    }


    /*    User Login Steps      */
    @When("The user clicks on My Account button and clicks on Login button after enters valid credentials")
    public void the_user_clicks_on_my_account_button_and_clicks_on_login_button_after_enters_valid_credentials() {
        loginPage.userLogin();

    }

    @Then("The user verifies that welcome message is displayed")
    public void the_user_verifies_that_welcome_message_is_displayed() {
        loginPage.verifyWelcomeMessage();
        System.out.println(loginPage.verifyWelcomeMessage());
    }


    /* Positive Login Test with Different Credentials */
    /* Negative Login Test */
    @When("The user clicks on My Account button and clicks on Login button after enters {string} and {string}")
    public void the_user_clicks_on_my_account_button_and_clicks_on_login_button_after_enters_and(String eMail, String password) {
        loginPage.userLogin(eMail, password);
    }

    @Then("The user verifies that error message is displayed")
    public void the_user_verifies_that_error_message_is_displayed() {
        loginPage.verifyErrorMessage();
        System.out.println(loginPage.verifyErrorMessage());
    }


}
