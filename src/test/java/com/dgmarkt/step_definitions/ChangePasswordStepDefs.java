package com.dgmarkt.step_definitions;

import com.dgmarkt.pages.ChangePasswordPage;
import com.dgmarkt.pages.LoginPage;
import com.dgmarkt.pages.MainPage;
import com.dgmarkt.utilities.ConfigurationReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ChangePasswordStepDefs {
    LoginPage  loginPage = new LoginPage();
    MainPage mainPage = new MainPage();
    ChangePasswordPage changePasswordPage = new ChangePasswordPage();
    @When("The user logs into the account")
    public void the_user_logs_into_the_account() {
       loginPage.userLogin(ConfigurationReader.get("modifyEmail"), ConfigurationReader.get("modifyPassword"));
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
    @When("The user wants to change the password by filling in only the password field.")
    public void the_user_wants_to_change_the_password_by_filling_in_only_the_password_field() {
        changePasswordPage.changePasswordWithOnlyNewPassword();
    }
    @Then("It is verified that the user is unable to change the password.")
    public void it_is_verified_that_the_user_is_unable_to_change_the_password() {
        String actual = changePasswordPage.changePasswordErrorMessage.getText();
        String expected = "Password confirmation does not match password!";
        Assert.assertEquals(expected, actual);
    }
    @When("The user wants to change the password by filling in only the confirm password field.")
    public void the_user_wants_to_change_the_password_by_filling_in_only_the_confirm_password_field() {
        changePasswordPage.confirmPasswordBox.sendKeys(ConfigurationReader.get("modifyNewPassword"));
        changePasswordPage.changePasswordContinueButton.click();
    }
    @Then("It is confirmed that the password change was unsuccessful.")
    public void it_is_confirmed_that_the_password_change_was_unsuccessful() {
        String actual = changePasswordPage.changePasswordErrorMessage.getText();
        String expected = "Password must be between 4 and 20 characters!";
        Assert.assertEquals(expected, actual);
    }
    @When("The user tries to change the password without filling any fields.")
    public void the_user_tries_to_change_the_password_without_filling_any_fields() {
        changePasswordPage.changePasswordContinueButton.click();
    }
    @When("The user attempts to change the password by entering the same passwords.")
    public void the_user_attempts_to_change_the_password_by_entering_the_same_passwords() {
        changePasswordPage.passwordBox.sendKeys(ConfigurationReader.get("modifyPassword"));
        changePasswordPage.confirmPasswordBox.sendKeys(ConfigurationReader.get("modifyPassword"));
        changePasswordPage.changePasswordContinueButton.click();
    }

}
