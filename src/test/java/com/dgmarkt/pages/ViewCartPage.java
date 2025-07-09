package com.dgmarkt.pages;

import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.Driver;
import io.cucumber.core.cli.Main;
import io.cucumber.java.it.Ma;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewCartPage extends BasePage{

    @FindBy(xpath = "//strong[contains(., 'View Cart')]")
    private WebElement viewCartButton;

    @FindBy(xpath = "//h1[contains(text(),'Shopping Cart')]")
    private WebElement shoppingCartBanner;

    @FindBy(xpath = "//span[@class='cart-product-price']")
    public WebElement productPriceInCart;

    SearchPage searchPage=new SearchPage();
    CheckoutPage checkoutPage=new CheckoutPage();

    public String productPageFullName;
    public String productPagePrice;

    public void clickViewCartButton() {
        viewCartButton.click();
    }

    public boolean isShoppingCartBannerDisplayed() {
        return shoppingCartBanner.isDisplayed();
    }

    public String getShoppingCartBannerText() {
        return shoppingCartBanner.getText();
    }



    public void addProductToCart(){

        for (int i = 0; i < searchPage.productName.size(); i++) {
            searchPage.productName.get(i).click();
            if (checkoutPage.productAvailability.getText().equals("In Stock")) {
//                productPageFullName=Driver.get().findElement(By.tagName("h1")).getText();
//                productPagePrice=Driver.get().findElement(By.xpath("//p[@class='price']")).getText();
                checkoutPage.addToCartButton.click();
                break;
            }
            Driver.get().navigate().back();

        }
    }
}
