package com.dgmarkt.pages;

import com.dgmarkt.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewCartPage extends BasePage{

    @FindBy(xpath = "//strong[contains(., 'View Cart')]")
    private WebElement viewCartButton;

    @FindBy(xpath = "//h1[contains(text(),'Shopping Cart')]")
    private WebElement shoppingCartBanner;

    public void clickViewCartButton() {
        viewCartButton.click();
    }

    public boolean isShoppingCartBannerDisplayed() {
        return shoppingCartBanner.isDisplayed();
    }

    public String getShoppingCartBannerText() {
        return shoppingCartBanner.getText();
    }
}
