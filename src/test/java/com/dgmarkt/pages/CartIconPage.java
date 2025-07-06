package com.dgmarkt.pages;

import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.Driver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.DriverManager;
import java.time.Duration;
import java.util.List;

public class CartIconPage extends BasePage {


    @FindBy(id = "cart")
    WebElement cartIcon;

    @FindBy(css = "p.text-center")
    WebElement emptyCartMessage;


    @FindBy(xpath = "//td[@class='text-left cart-info']//a")
    private WebElement productNameInCart;

    @FindBy(css = ".cart-quantity")
    private WebElement productQuantityInCart;

    @FindBy(css = ".cart-product-price")
    private WebElement productPriceInCart;

    @FindBy(css = ".btn-danger.btn-xs.button-cart-remove")
    private WebElement removeButton;

    @FindBy(xpath = "//button[contains(text(),'View Cart')]")
    private WebElement viewCartButton;

    SearchPage searchPage=new SearchPage();

    public String celloTvPrice;


    public void clickCartIcon() {
        cartIcon.click();
    }

    public String getEmptyCartMessage() {
        return emptyCartMessage.getText();
    }


    public void addTheProductCartWithHover(int productIndex) {

        currencyText.click();
        Driver.get().findElement(By.xpath("//button[text()='$ US Dollar']")).click();

        try {
            // Tüm cart butonlarını listeye koy
            List<WebElement> cartButtons = Driver.get().findElements(By.cssSelector(".button-cart"));
            if (productIndex < cartButtons.size()) {
                JavascriptExecutor JS = (JavascriptExecutor) Driver.get();
                // scroll ediyoruz urunun uzerine
                JS.executeScript("arguments[0].scrollIntoView(true);", cartButtons.get(productIndex));
                Thread.sleep(500); // scrollun tamamlanmasini bekliyoruz

                // Butona clickliyoruz
                JS.executeScript("arguments[0].click();", cartButtons.get(productIndex));
            } else { // sayfamizdaki secilecek urunun indexine gore
                System.out.println("Requested product index is out of bounds. Total products: " + cartButtons.size());
            }
        } catch (Exception e) {
            System.out.println("Error adding product to cart: " + e.getMessage());
        }
    }


    public boolean verifySuccessMessage() {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(10));
            WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[contains(text(),'Success: You have added')]")));

            return successMessage.isDisplayed();
        } catch (Exception e) {
            System.out.println("Success message verification failed: " + e.getMessage());
            return false;
        }
    }

    public String getSuccessMessageText() {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(10));
            WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[contains(text(),'Success: You have added')]")));

            // succes mesaj donuyormu
            return successMessage.isDisplayed() ? successMessage.getText() : "";

        } catch (Exception e) {
            System.out.println("Could not get success message: " + e.getMessage());
            return "";
        }
    }
    public CartIconPage() {
        PageFactory.initElements(Driver.get(), this);
    }


    // cartin icindeki urun
    public String getProductName() {
        BrowserUtils.waitForVisibility(productNameInCart, 10);
        return productNameInCart.getText().trim();
    }

    public String getQuantity() {
        BrowserUtils.waitForVisibility(productQuantityInCart, 10);
        return productQuantityInCart.getText().replace("x", "").trim();
    }

    public String getPrice() {
        BrowserUtils.waitForVisibility(productPriceInCart, 10);
        return productPriceInCart.getText().trim();
    }

    public void clickRemoveButton() {
        BrowserUtils.waitForClickablility(removeButton, 10);
        removeButton.click();

    }






}

























