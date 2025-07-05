package com.dgmarkt.pages;

import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.ConfigurationReader;
import com.dgmarkt.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WistListPage extends BasePage{

    @FindBy(css = "[class='btn btn-danger']")
    public WebElement removeButton;

    @FindBy(css = "[data-original-title='Add to Cart']")
    public WebElement clickCart;
    @FindBy(xpath = "//a[@data-original-title='Remove']")
    public WebElement wishListRemove;
    @FindBy(id = "wishlist-total")
    public WebElement wishListTotal;
    @FindBy(xpath = "(//a[text()='Networking'])[3]")
    public WebElement networking;
    @FindBy(xpath = "//button[@title='Add to Wish List']")
    public WebElement wishListad;
    @FindBy(css = "#account-wishlist > div.alert.alert-success.alert-dismissible")
    public WebElement verifyend;
    @FindBy(css = "#product-category > div.alert.alert-fix.alert-success.alert-dismissible > a:nth-child(2)")
    public WebElement loginWishList;

    public String getModifiedMassage(){
        return verifyend.getText();
    }

    @FindBy(css = "#content > div.table-responsive > table > tbody > tr > td:nth-child(3)")
    public WebElement getProduckNameWl;

    @FindBy(css = "#cart > ul > li:nth-child(1) > table > tbody > tr > td.text-left.cart-info > a")
    private WebElement productNameInCart;

    @FindBy(xpath = "//*[@id=\"input-email\"]")
    public WebElement wishListLoginEmailAddressBox;

    @FindBy(xpath = "//*[@id=\"input-password\"]")
    public WebElement wishListRemoveLoginPasswordBox;
    @FindBy(css = "#content > div > div:nth-child(2) > div > form > input")
    public WebElement wishListLoginButtonSubmit;
    public void userLoginWishList() {



        wishListLoginEmailAddressBox.sendKeys(ConfigurationReader.get("userEmailAddress"));
        wishListRemoveLoginPasswordBox.sendKeys(ConfigurationReader.get("userPassword"));
        wishListLoginButtonSubmit.click();
}
    public String getProductNameinCartİcon() {
        BrowserUtils.waitForVisibility(productNameInCart, 10);
        return productNameInCart.getText().trim();
    }

    public String getProductName() {
        BrowserUtils.waitForVisibility(getProduckNameWl, 10);
        return getProduckNameWl.getText().trim();
    }
    public void clickWishList() {
        wishListTotal.click();
    }

    @FindBy(css = ".alert-success")
    public WebElement successMessage;

    public void cartProductAdd() {
        clickCart.click();
    }

    public void wishListTop() {
        wishListTotal.click();
    }

    public void delete() {
        wishListRemove.click();
    }

    public void selectCategori() {
        networking.click();
    }

    public void wishListsadd() {
        wishListad.click();
    }

    public String getHeaderText(String headerName) {
        return Driver.get().findElement(By.xpath(" //a[text()='" + headerName + "']")).getText();
    }
    public void addTheWishListWithHover(int productIndex) {
        try {
            // Tüm cart butonlarını listeye koy
            List<WebElement> wishListButtons = Driver.get().findElements(By.xpath("//button[@title='Add to Wish List']"));
            if (productIndex < wishListButtons.size()) {
                JavascriptExecutor js = (JavascriptExecutor) Driver.get();
                // elementin görünür olabilmesi icin scroll ediyoruz urunun uzerine
                js.executeScript("arguments[0].scrollIntoView(true);", wishListButtons.get(productIndex));
                Thread.sleep(500); // Scroll'un tamamlanmasini bekliyoruz
                // Butona click
                js.executeScript("arguments[0].click();", wishListButtons.get(productIndex));
            } else { // sayfamizdaki girilecek index sayisina gore
                System.out.println("Requested product index is out of bounds. Total products: " + wishListButtons.size());
            }
        } catch (Exception e) {
            System.out.println("Error adding product to cart: " + e.getMessage());
        }
    }


    public String getSuccessMessageText() {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(10));
            WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector("[class='alert alert-fix alert-success alert-dismissible']")));

            // succes mesaj donuyormu
            return successMessage.isDisplayed() ? successMessage.getText() : "";

        } catch (Exception e) {
            System.out.println("Could not get success message: " + e.getMessage());
            return "";
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


    // 2. Success mesajını doğrulama metodu
    public String getSuccessMessage() {
        // Explicit wait ile mesajın görünür olmasını bekle
        WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(successMessage));

        // Mesaj metnini döndür
        return successMessage.getText();
    }
    public void clickLoginLinkWithJS() {
        try {

            // Login linkini bul
            WebElement loginLink = new WebDriverWait(Driver.get(), Duration.ofSeconds(5))
                    .until(ExpectedConditions.presenceOfElementLocated(
                            By.xpath("//a[contains(text(),'login')]")
                    ));

            // JS ile tıkla
            ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].click();", loginLink);

        } catch (Exception e) {
            System.out.println("Login linki bulunamadı veya tıklanamadı: " + e.getMessage());
        }
    }

}








