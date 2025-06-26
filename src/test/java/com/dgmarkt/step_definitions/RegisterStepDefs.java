package com.dgmarkt.step_definitions;

import com.dgmarkt.pages.RegisterPage;
import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.util.List;

public class RegisterStepDefs {

    RegisterPage registerPage = new RegisterPage();
    Faker faker = new Faker();



    @Given("User navigate the register account page")
    public void user_navigate_the_register_account_page() {
        registerPage.myAccountDropdown.click();
        registerPage.myAccountRegisterText.click();
    }

    @When("User fills in mandatory fields")
    public void user_fills_in_mandatory_fields() {
        registerPage.userRegister();
    }

    @Then("User verifies that the message {string} appears")
    public void user_verifies_that_the_message_appears(String message) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.get();
        String actual = (String) js.executeScript("return document.evaluate(\"//p[contains(text(), 'Thank you for registering with Your Store!')]\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.innerText;");
        Assert.assertEquals(message, actual);

    }

    @When("User click the Privacy Policy Text")
    public void user_click_the_privacy_policy_text() {
        registerPage.privacyPolicyText.click();
    }

    @Then("User verifies that opened Privacy Policy pop-up")
    public void user_verifies_that_opened_privacy_policy_pop_up() {
        Assert.assertTrue(Driver.get().findElement(By.xpath("//h4[text()='Privacy Policy']")).isDisplayed());
    }

    @Then("User verifies placeholder and textbox equal")
    public void user_verifies_placeholder_and_textbox_equal(List<String> textboxName) {

        Assert.assertEquals(textboxName, BrowserUtils.getElementsPlaceholder(registerPage.AllTextBoxPlaceholderName));

    }

    @When("User fills password and password confirm field")
    public void user_fills_password_and_password_confirm_field() {
        registerPage.password.sendKeys("123456789");
        registerPage.password.sendKeys("123456789");
    }

    @Then("User verifies that password and password confirm are masked")
    public void user_verifies_that_password_and_password_confirm_are_masked() {
        Assert.assertEquals(registerPage.password.getAttribute("type"), "password");
        Assert.assertEquals(registerPage.passwordConfirm.getAttribute("type"), "password");
    }

    @When("User fills in mandatory field {string},{string},{string},{string},{string},{string}")
    public void user_fills_in_mandatory_field(String firstName, String lastName, String email, String telephone, String password, String passwordConfirm) {
        registerPage.userRegister(firstName, lastName, email, telephone, password, passwordConfirm);
        registerPage.privacyPolicyCheckBox.click();
        registerPage.continueButton.click();

    }


    @Then("The warning message under {string} should contain {string}")
    public void the_warning_message_under_should_contain(String field, String expectedMessage) {
        String actualMessage = Driver.get().findElement(By.xpath("//div[@class='for-error error-" + field + " text-danger']")).getText();
        Assert.assertEquals(expectedMessage, actualMessage);

    }

    @When("User click the continue button")
    public void user_click_the_continue_button() {
       registerPage.continueButton.click();
    }

    @Then("The warning message should contain {string}")
    public void the_warning_message_should_contain(String message) {
        String actual=Driver.get().findElement(By.xpath("//span[contains(text(),' Warning: You must agree to the Privacy Policy!')]")).getText();
        Assert.assertEquals(message,actual);

    }

}
