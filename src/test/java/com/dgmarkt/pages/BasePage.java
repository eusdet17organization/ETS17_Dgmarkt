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

    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li/a/span")
    public WebElement myAccountDropdown;

    @FindBy(id = "pt-register-link")
    public WebElement myAccountRegisterText;

    @FindBy(xpath = "//*[@id=\"pt-login-link\"]")
    public WebElement myAccountLoginText;

    @FindBy(id = "search-by-category")
    public WebElement searchIcon;

    @FindBy(id = "btn-search-category")
    public WebElement searchIconWithSearchText;

    @FindBy(id = "text-search")
    public WebElement searchText;

    @FindBy(xpath = "//span[text()='Currency']")
    public WebElement currencyText;


}
