package com.dgmarkt.pages;

import com.dgmarkt.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangePasswordPage extends BasePage{
    @FindBy(xpath = "//button[@class=\"close\"]")
    public WebElement loginSuccessfulCloseButton;

    @FindBy(xpath = "//a[text()='My Account']")
    public WebElement myAccountButton2;

    @FindBy(xpath = "//a[text()='Password']")
    public WebElement passwordButton;

    @FindBy(id = "input-password")
    public WebElement passwordBox;
    @FindBy (id = "input-confirm")
    public WebElement confirmPasswordBox;

    @FindBy(xpath = "//input[@value='Continue']")
    public WebElement changePasswordContinueButton;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    public WebElement changePasswordSuccessMessage;

    @FindBy(xpath = "//div[@class='text-danger']")
    public WebElement changePasswordErrorMessage;

    public void setChangePassword(){
        passwordBox.sendKeys(ConfigurationReader.get("modifyNewPassword"));
        confirmPasswordBox.sendKeys(ConfigurationReader.get("modifyNewPassword"));
        changePasswordContinueButton.click();
    }
    public void changePasswordWithOnlyNewPassword(){
        passwordBox.sendKeys(ConfigurationReader.get("modifyNewPassword"));
        changePasswordContinueButton.click();
    }

}
