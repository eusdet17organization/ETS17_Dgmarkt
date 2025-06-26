package com.dgmarkt.pages;

import com.dgmarkt.utilities.ConfigurationReader;
import com.dgmarkt.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPanelPage extends BasePage{

    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailBox;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//input[@name='login']")
    public WebElement loginButton;


    /**
     * Site korumasi icin panel'deki ilk login islemi
     */
    public void loginPanel(){
        emailBox.sendKeys(ConfigurationReader.get("mainUsername"));
        passwordBox.sendKeys(ConfigurationReader.get("mainPassword"));
        loginButton.click();
    }

}
