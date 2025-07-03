package com.dgmarkt.pages;

import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.Driver;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import static com.dgmarkt.utilities.Driver.driver;

public class ShoppingCartPage extends BasePage {

    Faker faker = new Faker();



    @FindBy(xpath = "//strong[contains(., ' Checkout')]")
    public WebElement checkOutInCartIcon;

    @FindBy(xpath = "//*[@id=\"button-account\"]")
    public WebElement checkoutOptionsCoBttn;


    @FindBy(id = "input-payment-firstname")
    private WebElement firstNameInput;

    @FindBy(id = "input-payment-lastname")
    private WebElement lastNameInput;

    @FindBy(id = "input-payment-email")
    private WebElement emailInput;

    @FindBy(id = "input-payment-telephone")
    private WebElement telephoneInput;

    @FindBy(css = "input[name='company']")
    public WebElement companyInput;

    @FindBy(id = "input-payment-address-1")
    public WebElement address1Input;

    @FindBy(id = "input-payment-city")
    public WebElement cityInput;

    @FindBy(id = "input-payment-postcode")
    public WebElement postcodeInput;

    @FindBy(id = "input-payment-country")
    public WebElement countrySelect;

    @FindBy(id = "input-payment-zone")
    public WebElement regionSelect;

    @FindBy(id = "input-payment-password")
    public WebElement passwordInput;

    @FindBy(id = "input-payment-confirm")
    public WebElement confirmPasswordInput;



    @FindBy(css = "input[type='checkbox'][name='agree']")
    public WebElement privacyPolicyCheckbox;


    @FindBy(id = "button-confirm")
    public  WebElement confirmOrderBtn;

    @FindBy(css = "#header > div.breadcrumbs > div > div > h1")
    WebElement OrderDone;


    public void ClickCheckOutInCartIcon() {
        checkOutInCartIcon.click();
    }

    public void CheckoutOptionsCoBttn() {
        checkoutOptionsCoBttn.click();
    }


    public void enterFirstName() {
        String firstName = faker.name().firstName();
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName() {
        String lastName = faker.name().lastName();
        lastNameInput.sendKeys(lastName);
    }

    public void enterEmail() {
        String email = faker.internet().emailAddress();
        emailInput.sendKeys(email);
    }

    public void enterTelephone() {
        String phone = faker.numerify("5#########");
        telephoneInput.sendKeys(phone);
    }

    public void enterAddress() {
        String address = faker.address().streetAddress();
        address1Input.sendKeys(address);
    }

    public void enterCity() {
        String city = faker.address().city();
        cityInput.sendKeys(city);
    }

    public void enterPostcode() {
        String postcode = faker.address().zipCode();
        postcodeInput.sendKeys(postcode);
    }
    public void enterPassword() {

        passwordInput.sendKeys("2574dGlogin");
        confirmPasswordInput.sendKeys("2574dGlogin");
    }

    public void enterCompany (){
        String company = "Sdet";
        companyInput.sendKeys(company);
    }


    // ortak
   public void acceptPrivacyPolicy(){
            WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(privacyPolicyCheckbox));
            privacyPolicyCheckbox.click();}

    // her continue tusu icin ayri bir method yaptik
    public void clickBillingContinueButton() {
            WebElement billingContinueButton = driver.findElement(By.id("button-register"));
            // Butonun tıklanabilir olmasını bekletiyoruz
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(billingContinueButton));
            // Butona tıkla
            billingContinueButton.click();
    }

    public void clickDeliveryDetailsContinueButton() {
        WebElement deliveryDetailsButton = driver.findElement(By.id("button-shipping-address"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(deliveryDetailsButton));
            deliveryDetailsButton.click();


    }

    public void clickDeliveryMethodContinueButton() {
            WebElement deliveryMethodButton = driver.findElement(By.id("button-shipping-method"));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(deliveryMethodButton));
            deliveryMethodButton.click();
    }

    public void clickPaymentMethodContinueButton() {
        // Önce Terms & Conditions checkbox'ını işaretlemek icin isaretliyse gecmek icin
            WebElement agreeCheckbox = driver.findElement(By.cssSelector("input[type='checkbox'][name='agree']"));
            if (!agreeCheckbox.isSelected()) {
                agreeCheckbox.click();
            }
            WebElement paymentMethodButton = driver.findElement(By.id("button-payment-method"));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(paymentMethodButton));
            paymentMethodButton.click();
    }








    public void confirmOrderBtn(){
        confirmOrderBtn.click();
    }

    public void orderDoneHeader(){

            WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(10));
            // h1 elementini bulamiyor bekleme atmamiz lazim
            WebElement orderHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//h1[contains(text(),'Your order has been placed!')]")
            ));

            String expectedMessage = "Your Order Has Been Placed!";
            String actualMessage = orderHeader.getText();

            Assert.assertEquals(expectedMessage, actualMessage);
            System.out.println("actualMessage = " + actualMessage);
    }




    public void selectCountry() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(countrySelect));
        Select countryDropdown = new Select(countrySelect);
        // "United Kingdom" seçiyoruz
        countryDropdown.selectByVisibleText("United Kingdom");
    }

    public void selectRegion() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(regionSelect));
        Select regionDropdown = new Select(regionSelect);
        //index 1'den başlayarak rastgele bir bölge seçtiriyoruz index 0 select region oldugu icin
        List<WebElement> options = regionDropdown.getOptions();
        regionDropdown.selectByVisibleText("Cardiff");


        /* rastgele bolge secimi yapmak istedim olmadi
        if (options.size() > 1) {
            int randomIndex = new Random().nextInt(options.size() - 1) + 1;
            regionDropdown.selectByIndex(randomIndex);}
        */
    }


    public void fillAllBillingDetails() {
        enterFirstName();
        enterLastName();
        enterEmail();
        enterTelephone();
        enterPassword();
        enterCompany();
        enterAddress();
        enterCity();
        enterPostcode();
        selectCountry();
        selectRegion();

    }


}








