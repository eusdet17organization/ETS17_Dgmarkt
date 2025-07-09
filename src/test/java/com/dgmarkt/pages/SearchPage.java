package com.dgmarkt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage{

    @FindBy(xpath = "//div[@class='product-thumb']/div/div/following-sibling::div/div/h4")
    public List<WebElement> productName;

    @FindBy(xpath = "//p[@class='price']")
    public List<WebElement> productPrice;




}
