package com.dgmarkt.step_definitions;

import com.dgmarkt.pages.BasePage;
import com.dgmarkt.pages.LoginPage;
import com.dgmarkt.pages.LoginPanelPage;
import com.dgmarkt.pages.MainPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static com.dgmarkt.utilities.Driver.driver;

public class LogoutStepDefs extends BasePage {

    LoginPanelPage loginPanelPage = new LoginPanelPage();

    MainPage mainPage = new MainPage();

    LoginPage loginPage = new LoginPage();


    /* User Logout Steps */
    @When("The user clicks on My Account button and clicks on Logout button")
    public void the_user_clicks_on_my_account_button_and_clicks_on_logout_button() {
        myAccountDropdown.click();
        loginPage.myAccountLogoutButton.click();
    }

    @Then("The user closes the Account Logout popup by clicking continue")
    public void the_user_closes_the_account_logout_popup_by_clicking_continue() {
        loginPage.popupContinueButton.click();
    }


    /* User Logout Negative Test */
    @Then("The user clicks on My Account button")
    public void the_user_clicks_on_my_account_button() {
        myAccountDropdown.click();
    }

    @Then("The user verifies that they are unable to log out by clicking the My Account button from the opened dropdown")
    public void the_user_verifies_that_they_are_unable_to_log_out_by_clicking_the_my_account_button_from_the_opened_dropdown
            () {
        loginPage.myAccountMyAccountButton.click();
        Assert.assertTrue("Account", loginPage.myAccountAccountText.isDisplayed());
        Assert.assertEquals("Account", loginPage.myAccountAccountText.getText());

    }

    @Then("The user verifies that they are unable to log out by clicking the Order History button from the opened dropdown")
    public void the_user_verifies_that_they_are_unable_to_log_out_by_clicking_the_order_history_button_from_the_opened_dropdown
            () {
        loginPage.myAccountOrderHistoryButton.click();
        Assert.assertTrue("Order History", loginPage.myAccountOrderHistoryText.isDisplayed());
        Assert.assertEquals("Order History", loginPage.myAccountOrderHistoryText.getText());
    }

    @Then("The user verifies that they are unable to log out by clicking the Transactions button from the opened dropdown")
    public void the_user_verifies_that_they_are_unable_to_log_out_by_clicking_the_transactions_button_from_the_opened_dropdown
            () {
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


    /* User Logout with Browser Back Button */
    @Then("The user clicks on the browser “Back” button")
    public void the_user_clicks_on_the_browser_back_button() {
        driver.navigate().back();
    }

    @Then("The user closes the Sign Up Newsletter pop up")
    public void the_user_closes_the_sign_up_newsletter_pop_up() {
        mainPage.closePopUp();
    }

    @Then("The user verifies that they are on the main page")
    public void the_user_verifies_that_they_are_on_the_main_page() {
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://dgmarkt.com/";
        Assert.assertEquals("Main Page, Kullanıcı olarak çıkış işleminizi yaptınız. Tekrar giriş yapmak için ilgili adımları takip ediniz.", actualURL, expectedURL);
    }

}
