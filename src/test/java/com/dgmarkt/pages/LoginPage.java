package com.dgmarkt.pages;

import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.ConfigurationReader;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.dgmarkt.utilities.Driver.driver;


public class LoginPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"input-email\"]")
    public WebElement myAccountLoginEmailAddressBox;

    @FindBy(xpath = "//*[@id=\"input-password\"]")
    public WebElement myAccountLoginPasswordBox;

    @FindBy(xpath = "//*[@id=\"ajax-login-form\"]/div[3]/button[1]")
    public WebElement myAccountLoginButtonSubmit;

    @FindBy(css = ".alert.alert-success")
    public WebElement loginSuccessfulMessage;

    @FindBy(css = ".alert.alert-danger")
    public WebElement loginErrorMessage;


    public void userLogin() {
        myAccountDropdown.click();
        myAccountLoginText.click();
        myAccountLoginEmailAddressBox.sendKeys(ConfigurationReader.get("userEmailAddress"));
        myAccountLoginPasswordBox.sendKeys(ConfigurationReader.get("userPassword"));
        myAccountLoginButtonSubmit.click();
    }

    public String verifyWelcomeMessage() {
        BrowserUtils.waitForVisibility(loginSuccessfulMessage, 5);
        WebElement confirmationPopUp = driver.findElement(By.cssSelector(".alert.alert-success"));
        String actual = confirmationPopUp.getText();
        String expected = "Congratulation! Login Successfully\n" + "×";
        Assert.assertEquals(actual, expected);
        return BrowserUtils.getText(confirmationPopUp);
    }

    public void userLogin(String eMail, String password) {
        myAccountDropdown.click();
        myAccountLoginText.click();
        myAccountLoginEmailAddressBox.sendKeys(eMail);
        myAccountLoginPasswordBox.sendKeys(password);
        myAccountLoginButtonSubmit.click();
    }

    public String verifyErrorMessage() {
        BrowserUtils.waitForVisibility(loginErrorMessage, 5);
        WebElement errorMessage = driver.findElement(By.cssSelector(".alert.alert-danger"));
        String actual = errorMessage.getText();
        String expected = "Warning: No match for E-Mail Address and/or Password.\n" + "×";
        Assert.assertEquals(actual, expected);
        return BrowserUtils.getText(errorMessage);
    }
}
