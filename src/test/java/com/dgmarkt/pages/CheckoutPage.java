package com.dgmarkt.pages;

import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static com.dgmarkt.utilities.Driver.driver;

public class CheckoutPage extends BasePage {

    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    MainPage mainPage = new MainPage();


    @FindBy(id = "cart")
    public WebElement cartIcon;

    @FindBy(xpath = "(//p[@class='text-right']//strong)[1]")
    public WebElement viewCartIcon;

    @FindBy(xpath = "//div[@class='pull-right']")
    public WebElement checkOutButton;

    @FindBy (id = "button-cart")
     public WebElement addToCartButton;
    // search sayfasindaki productNameye ulasamadim buraya tasidim.
    @FindBy(xpath = "//div[@class='product-thumb']/div/div/following-sibling::div/div/h4")
    public List<WebElement> productName;

    // urunun stok durumu
    @FindBy(xpath = "//li[contains(text(),'Availability')]/span")
    public WebElement productAvailability;

    // cart icindeki checkout
    @FindBy (xpath = "//*[@id=\"cart\"]/ul/li[2]/div/p/a[2]")
    WebElement checkOutBtnInCart;

    public void CheckOutBtnInCart (){
        BrowserUtils.clickWithJS(checkOutBtnInCart);
    }

    // urunun altindaki check out
    @FindBy (xpath = "//*[@id=\"button-cart\"]")
    WebElement checkOutBand;


    // Method: Dinamik stokta varmi yok mu olarak kontrol ederek urunu sepete ekletiyoruz
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


///------------------Seneryo2 User adds a product to cart with "Search" button -------------------------///////
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));








}

