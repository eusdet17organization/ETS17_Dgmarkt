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

    @FindBy(xpath = "//*[@id=\"ajax-login-form\"]/div[2]/a")
    public WebElement forgottenPasswordButton;

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/ul/li[3]/a")
    public WebElement forgottenPasswordText;

    @FindBy(xpath = "//*[@id=\"input-email\"]")
    public WebElement eMailAddressBox;

    @FindBy(xpath = "//*[@id=\"content\"]/form/div/div[2]/input")
    public WebElement forgottenPasswordContinueButton;

    @FindBy(xpath = "//*[@id=\"account-login\"]/div[1]")
    public WebElement forgottenPasswordConfirmationMessage;

    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/div/div/div/div/div/div[3]/div[1]/div[2]/div/div/div")
    public WebElement loginFiveAttemptsErrorMessage;

    @FindBy(xpath = "/html/body/div[1]/div[3]/div[1]/div/div/div/div/div/div[3]/div[1]/div[1]/a")
    public WebElement closeLoginPage;

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

    public void fiveLoginAttempts(String eMail, String password) {
        myAccountDropdown.click();
        myAccountLoginText.click();
        myAccountLoginEmailAddressBox.sendKeys(eMail);
        myAccountLoginPasswordBox.sendKeys(password);
        myAccountLoginButtonSubmit.click();
        closeLoginPage.click();
        myAccountDropdown.click();
        myAccountLoginText.click();
        myAccountLoginEmailAddressBox.sendKeys(eMail);
        myAccountLoginPasswordBox.sendKeys(password);
        myAccountLoginButtonSubmit.click();
        closeLoginPage.click();
        myAccountDropdown.click();
        myAccountLoginText.click();
        myAccountLoginEmailAddressBox.sendKeys(eMail);
        myAccountLoginPasswordBox.sendKeys(password);
        myAccountLoginButtonSubmit.click();
        closeLoginPage.click();
        myAccountDropdown.click();
        myAccountLoginText.click();
        myAccountLoginEmailAddressBox.sendKeys(eMail);
        myAccountLoginPasswordBox.sendKeys(password);
        myAccountLoginButtonSubmit.click();
        closeLoginPage.click();
        myAccountDropdown.click();
        myAccountLoginText.click();
        myAccountLoginEmailAddressBox.sendKeys(eMail);
        myAccountLoginPasswordBox.sendKeys(password);
        myAccountLoginButtonSubmit.click();
        BrowserUtils.waitForVisibility(loginFiveAttemptsErrorMessage, 5);
    }

}
