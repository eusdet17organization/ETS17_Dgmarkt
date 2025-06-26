package com.dgmarkt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage{
    @FindBy(xpath = "//a[@class='a-close-newsletter']")
    public WebElement popUpButton;
    public void closePopUp() {
        popUpButton.click();
    }
}
