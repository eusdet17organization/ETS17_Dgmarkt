package com.dgmarkt.pages;

import com.dgmarkt.utilities.Driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public abstract class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    protected Select select;

    @FindBy(xpath = "//span[text()='My Account']")
    public WebElement myAccountDropdown;

    @FindBy(id = "pt-register-link")
    public WebElement registerText;




}
