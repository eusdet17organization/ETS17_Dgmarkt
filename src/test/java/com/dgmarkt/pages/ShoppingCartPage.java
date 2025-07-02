package com.dgmarkt.pages;

import com.dgmarkt.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {



    @FindBy(xpath = "//strong[contains(., ' Checkout')]")
    public WebElement checkOutInCartIcon;

    @FindBy(xpath = "//button[contains(text(),'Checkout')]")
    public WebElement checkoutButton;

    @FindBy(id = "button-payment-address")
    public WebElement billingDetailsContinueButton;

    @FindBy(id = "button-shipping-address")
    public WebElement deliverDetailsContinueButton;

    @FindBy(id = "button-shipping-method")
    public WebElement deliveryMethodContinueButton;

    @FindBy(xpath = "//input[@type='checkbox']")
    public WebElement TermsAndConditionsCheckbox;

    @FindBy(xpath = "button-payment-method")
    public WebElement paymentMethodContinueButton;

    @FindBy(xpath = "button-confirm")
    public WebElement confirmOrderButton;


    @FindBy(id = "cart")
    public WebElement cartIcon;

    @FindBy(xpath = "(//p[@class='text-right']//strong)[1]")
    public WebElement viewCartIcon;

    @FindBy(xpath = "//div[@class='pull-right']")
    public WebElement checkOutButton;

    public void ClickCheckOutInCartIcon(){
        checkOutInCartIcon.click();
    }

    MainPage mainPage = new MainPage();
    SearchPage searchPage = new SearchPage();
   /* CheckoutPage checkoutPage=new CheckoutPage();




    public void completeOrder() {
        cartIcon.click();
        viewCartIcon.click();
        checkOutButton.click();
        checkoutPage.billingDetailsContinueButton.click();
        checkoutPage.deliverDetailsContinueButton.click();
        checkoutPage.deliveryMethodContinueButton.click();
        checkoutPage.TermsAndConditionsCheckbox.click();
        checkoutPage.paymentMethodContinueButton.click();
        checkoutPage.confirmOrderButton.click();
}

     */
}
