package com.dgmarkt.pages;

import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.ConfigurationReader;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li/a/span")
    public WebElement myAccountButton;

    @FindBy(xpath = "//*[@id=\"pt-login-link\"]")
    public WebElement myAccountLoginButton;

    @FindBy(xpath = "//*[@id=\"input-email\"]")
    public WebElement myAccountLoginEmailAddressBox;

    @FindBy(xpath = "//*[@id=\"input-password\"]")
    public WebElement myAccountLoginPasswordBox;

    @FindBy(xpath = "//*[@id=\"ajax-login-form\"]/div[3]/button[1]")
    public WebElement myAccountLoginButtonSubmit;

    @FindBy(css = ".alert.alert-success")
    public WebElement loginSuccessfulMessage;


    public void userLogin() {
        myAccountButton.click();
        myAccountLoginButton.click();
        myAccountLoginEmailAddressBox.sendKeys(ConfigurationReader.get("userEmailAddress"));
        myAccountLoginPasswordBox.sendKeys(ConfigurationReader.get("userPassword"));
        myAccountLoginButtonSubmit.click();
    }

    public String verifyWelcomeMessage() {
        return BrowserUtils.getText(loginSuccessfulMessage);
    }
}
