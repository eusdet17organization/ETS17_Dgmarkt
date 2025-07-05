package com.dgmarkt.step_definitions;

import com.dgmarkt.pages.BasePage;
import com.dgmarkt.pages.LoginPage;
import com.dgmarkt.pages.LoginPanelPage;
import com.dgmarkt.pages.MainPage;
import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.ConfigurationReader;
import com.dgmarkt.utilities.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;

public class LoginStepDefs extends BasePage {

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


    /* Forgotten Password Test */
    @When("The user clicks on My Account button and clicks on Login button")
    public void the_user_clicks_on_my_account_button_and_clicks_on_login_button() {
        myAccountDropdown.click();
        myAccountLoginText.click();
    }

    @Then("The user clicks on Forgotten Password Button")
    public void the_user_clicks_on_forgotten_password_button() {
        loginPage.forgottenPasswordButton.click();
    }

    @Then("The user verifies Forgotten Password Text")
    public void the_user_verifies_forgotten_password_text() {
        Assert.assertTrue(loginPage.forgottenPasswordText.isDisplayed());
        Assert.assertEquals("Forgotten Password", loginPage.forgottenPasswordText.getText());
    }

    @Then("The user enters {string} in the E-Mail Address field")
    public void the_user_enters_in_the_e_mail_address_field(String eMail) {
        loginPage.eMailAddressBox.sendKeys(eMail);
    }

    @Then("The user clicks on Continue Button")
    public void the_user_clicks_on_continue_button() {
        loginPage.forgottenPasswordContinueButton.click();
    }

    @Then("The user verifies that confirmation message is displayed")
    public void the_user_verifies_that_confirmation_message_is_displayed() {
        Assert.assertTrue(loginPage.forgottenPasswordConfirmationMessage.isDisplayed());
        Assert.assertEquals("An email with a confirmation link has been sent your email address.", loginPage.forgottenPasswordConfirmationMessage.getText());
    }


    /* User Logout Steps */
    @When("The user clicks on My Account button and clicks on Logout button")
    public void the_user_clicks_on_my_account_button_and_clicks_on_logout_button() {
        myAccountDropdown.click();
        loginPage.myAccountLogoutButton.click();
    }

    @Then("The user closes the Account Logout popup by clicking continue.")
    public void the_user_closes_the_account_logout_popup_by_clicking_continue() {
        loginPage.popupContinueButton.click();
    }


    /* User Logout Negative Test */
    @Then("The user clicks on My Account button")
    public void the_user_clicks_on_my_account_button() {
        myAccountDropdown.click();
    }

    @Then("The user verifies that they are unable to log out by clicking the My Account button from the opened dropdown")
    public void the_user_verifies_that_they_are_unable_to_log_out_by_clicking_the_my_account_button_from_the_opened_dropdown() {
        loginPage.myAccountMyAccountButton.click();
        Assert.assertTrue("Account", loginPage.myAccountAccountText.isDisplayed());
        Assert.assertEquals("Account", loginPage.myAccountAccountText.getText());

    }

    @Then("The user verifies that they are unable to log out by clicking the Order History button from the opened dropdown")
    public void the_user_verifies_that_they_are_unable_to_log_out_by_clicking_the_order_history_button_from_the_opened_dropdown() {
        loginPage.myAccountOrderHistoryButton.click();
        Assert.assertTrue("Order History", loginPage.myAccountOrderHistoryText.isDisplayed());
        Assert.assertEquals("Order History", loginPage.myAccountOrderHistoryText.getText());
    }

    @Then("The user verifies that they are unable to log out by clicking the Transactions button from the opened dropdown")
    public void the_user_verifies_that_they_are_unable_to_log_out_by_clicking_the_transactions_button_from_the_opened_dropdown() {
        loginPage.myAccountTransactionsButton.click();
        Assert.assertTrue("Your Transactions", loginPage.myAccountYourTransactionsText.isDisplayed());
        Assert.assertEquals("Your Transactions", loginPage.myAccountYourTransactionsText.getText());
    }

    @Then("The user verifies that they are unable to log out by clicking the Downloads button from the opened dropdown")
    public void the_user_verifies_that_they_are_unable_to_log_out_by_clicking_the_downloads_button_from_the_opened_dropdown() {
        loginPage.myAccountDownloadsButton.click();
        Assert.assertTrue("Downloads", loginPage.myAccountDownloadsText.isDisplayed());
        Assert.assertEquals("Downloads", loginPage.myAccountDownloadsText.getText());
    }


}
