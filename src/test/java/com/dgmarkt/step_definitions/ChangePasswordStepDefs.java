package com.dgmarkt.step_definitions;

import com.dgmarkt.pages.ChangePasswordPage;
import com.dgmarkt.pages.LoginPage;
import com.dgmarkt.pages.MainPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ChangePasswordStepDefs {
    LoginPage  loginPage = new LoginPage();
    MainPage mainPage = new MainPage();
    ChangePasswordPage changePasswordPage = new ChangePasswordPage();
    @When("The user logs into the account")
    public void the_user_logs_into_the_account() {
       loginPage.userLogin();
       changePasswordPage.loginSuccessfulCloseButton.click();
    }
    @When("The user navigates to the change password page")
    public void the_user_navigates_to_the_change_password_page() {
        changePasswordPage.myAccountDropdown.click();
        changePasswordPage.myAccountButton2.click();
        changePasswordPage.passwordButton.click();
    }
    @When("The user enters the current password, sets a new password, and confirms it.")
    public void the_user_enters_the_current_password_sets_a_new_password_and_confirms_it() {
        changePasswordPage.setChangePassword();

    }

    @Then("The user verifies that the password change was successful")
    public void the_user_verifies_that_the_password_change_was_successful() {
        String actual = changePasswordPage.changePasswordSuccessMessage.getText();
        String expected = "Success: Your password has been successfully updated.";
        Assert.assertEquals(expected, actual);
    }
}
