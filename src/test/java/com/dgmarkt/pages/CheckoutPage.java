package com.dgmarkt.pages;

import com.dgmarkt.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckoutPage extends BasePage {




    @FindBy(id = "cart")
    public WebElement cartIcon;

    @FindBy(xpath = "(//p[@class='text-right']//strong)[1]")
    public WebElement viewCartIcon;

    @FindBy(xpath = "//div[@class='pull-right']")
    public WebElement checkOutButton;

    @FindBy (id = "button-cart")
     public WebElement addToCartButton;





    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    MainPage mainPage = new MainPage();
    SearchPage searchPage = new SearchPage();




    @FindBy(xpath = "//div[@class='product-thumb']/div/div/following-sibling::div/div/h4")
    public List<WebElement> productName;

    @FindBy(xpath = "//li[contains(text(),'Availability')]/span")
    public WebElement productAvailability;



    // Method:
    public void addProductToCartWithStock() {
        mainPage.clickMainButton("Category");
        mainPage.clickSubButton("Televisions");

        for (int i = 0; i < productName.size(); i++) {
            productName.get(i).click();
            if (productAvailability.getText().equals("In Stock")) {
                addToCartButton.click();
                break;
            }
            Driver.get().navigate().back();
        }
        //Driver.get().navigate().back();
    }



    /* public void addProductToCart() {
        mainPage.clickMainButton("Category");
        mainPage.clickSubButton("TELEVISIONS");


        for (int i = 0; i < searchPage.productName.size(); i++) {
            searchPage.productName.get(i).click();
            if (checkoutPage.productAvailability.getText().equals("In Stock")) {
                checkoutPage.addToCartButton.click();
                break;
            }
            Driver.get().navigate().back();

        }
    }
*/
    public void completeOrder() {
        cartIcon.click();
        viewCartIcon.click();
        checkOutButton.click();
        shoppingCartPage.billingDetailsContinueButton.click();
        shoppingCartPage.deliverDetailsContinueButton.click();
        shoppingCartPage.deliveryMethodContinueButton.click();
        //shoppingCartPage.privacyPolicyCheckbox.click();
        shoppingCartPage.clickPaymentMethodContinueButton();
        shoppingCartPage.confirmOrderBtn();
    }


}

