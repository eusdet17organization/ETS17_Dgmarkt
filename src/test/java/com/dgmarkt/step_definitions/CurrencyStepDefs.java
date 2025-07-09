package com.dgmarkt.step_definitions;

import com.dgmarkt.pages.*;
import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CurrencyStepDefs {

    MainPage mainPage = new MainPage();
    SearchPage searchPage = new SearchPage();
    ViewCartPage viewCartPage=new ViewCartPage();
    CartIconPage cartIconPage=new CartIconPage();
    CheckoutPage checkoutPage=new CheckoutPage();

    public static String amountOfCurrency;
    public static String beforeCurrencySymbol;
    public static String afterCurrencySymbol;


    @When("User navigate to {string} page")
    public void user_navigate_to_page(String productPageName) {
        mainPage.navigateCategoryDropdown(productPageName);

    }

    @When("User click the Currency text")
    public void user_click_the_currency_text() {
        amountOfCurrency=searchPage.productPrice.get(0).getText();
        mainPage.currencyText.click();

    }

    @When("User click the any {string}")
    public void user_click_the_any(String curreny) {
        beforeCurrencySymbol=Driver.get().findElement(By.xpath("//button[@class='btn btn-link dropdown-toggle']//span")).getText();
        Driver.get().findElement(By.xpath("//button[text()='" + curreny + "']")).click();
        BrowserUtils.waitFor(1);
        afterCurrencySymbol=Driver.get().findElement(By.xpath("//button[@class='btn btn-link dropdown-toggle']//span")).getText();

    }


    /***
     * ürünler sayfasindayken o anki currency ile para birimi baska bir para birimiyle degistirilince kura göre
     * para miktari degisip degismedigi kontrolü yapiliyor.
     * Eger o anki currency ile yeni secilen currency ayni olursa islem degismediginden basarili sayiliyor.
     */
    @Then("The user verifies that the product price has changed numerically.")
    public void the_user_verifies_that_the_product_price_has_changed_numerically() {

        String unExpectedProductPrice;
        String actualAmountOfCurrency;

        if(!searchPage.productPrice.get(0).getText().equals(amountOfCurrency)){

            if(searchPage.productPrice.get(0).getText().contains("€")){
                 unExpectedProductPrice=searchPage.productPrice.get(0).getText().substring(0,searchPage.productPrice.get(0).getText().length()-1);
                 actualAmountOfCurrency=amountOfCurrency.substring(0,amountOfCurrency.length()-1);
            }else {
                unExpectedProductPrice = searchPage.productPrice.get(0).getText().substring(1);
                actualAmountOfCurrency=amountOfCurrency.substring(1);
            }

            Assert.assertNotEquals(unExpectedProductPrice,actualAmountOfCurrency);
        }

    }


    /***
     * ürünler sayfasindayken para birimi degistirilir (€ Euro,£ Pound Sterling,$ US Dollar)
     * sayfadaki ürünlerin para birimi degisiyormu kontrolü yapilir.
     * € ifadesi genellikle en sondadir, £ ve $  bastadir.
     * Buna göre parametre olarak Scenario outline ile degerler degisiyor mu tek tek hepsi karsilastirilir.
     * @param currency
     */
    @Then("User verifies {string} of product")
    public void user_verifies_of_product(String currency) {

        for (WebElement s : searchPage.productPrice) {
            if(s.getText().contains("€")) {
                char lastChar = s.getText().charAt(s.getText().length() - 1);
                Assert.assertTrue(currency.contains(String.valueOf(lastChar)));
            }else {
                char firstChar=s.getText().charAt(0);
                Assert.assertTrue(currency.contains(String.valueOf(firstChar)));
            }
        }


    }

    @Then("User verifies correct currency of product in cart")
    public void user_verifies_correct_currency_of_product_in_cart() {
        if(viewCartPage.productPriceInCart.getText().contains("€")) {
            char lastChar = viewCartPage.productPriceInCart.getText().charAt(viewCartPage.productPriceInCart.getText().length() - 1);
            Assert.assertEquals(String.valueOf(lastChar),"€");
        }else {
            char firstChar=viewCartPage.productPriceInCart.getText().charAt(0);
            Assert.assertEquals(String.valueOf(firstChar),"$");
        }

        }

    @Then("User verifies correct currency of product in checkout")
    public void user_verifies_correct_currency_of_product_in_checkout() {
        if(checkoutPage.unitPrice.contains("€")) {
            char lastChar = checkoutPage.unitPrice.charAt(checkoutPage.unitPrice.length() - 1);
            Assert.assertEquals(String.valueOf(lastChar),"€");
        }else {
            char firstChar=checkoutPage.unitPrice.charAt(0);
            Assert.assertEquals(String.valueOf(firstChar),"$");
        }
    }



    @Then("User adds product to cart")
    public void user_adds_product_to_cart() {
        viewCartPage.addProductToCart();
    }

    @When("User click viewCart icon")
    public void user_click_view_cart_icon() {
        Driver.get().findElement(By.id("cart")).click();
    }

    @Then("User verifies that the product in the cart with correct {string}")
    public void user_verifies_that_the_product_in_the_cart_with_correct(String currency) {


        if(viewCartPage.productPriceInCart.getText().contains("€")) {
            char lastChar = viewCartPage.productPriceInCart.getText().charAt(viewCartPage.productPriceInCart.getText().length() - 1);
            Assert.assertTrue(currency.contains(String.valueOf(lastChar)));
        }else {
            char firstChar=viewCartPage.productPriceInCart.getText().charAt(0);
            Assert.assertTrue(currency.contains(String.valueOf(firstChar)));
        }


    }

    @When("User click checkout button")
    public void user_click_checkout_button() {
        Driver.get().findElement(By.xpath("//i[@class='fa fa-share']")).click();
    }

    @When("User complete the order in checkout page")
    public void user_complete_the_order_in_checkout_page() {
        checkoutPage.orderComplete();

    }
    @Then("User verifies that the product in the checkout page with correct {string}")
    public void user_verifies_that_the_product_in_the_checkout_page_with_correct(String currency) {

        if(checkoutPage.unitPrice.contains("€")) {
            char lastChar =checkoutPage.unitPrice.charAt(checkoutPage.unitPrice.length() - 1);
            Assert.assertTrue(currency.contains(String.valueOf(lastChar)));
        }else {
            char firstChar=checkoutPage.unitPrice.charAt(0);
            Assert.assertTrue(currency.contains(String.valueOf(firstChar)));
        }

    }

    /***
     * currency dropdown tikladiktan sonra currency degeri dropdown isminde görünüyor mu testi yapiliyor.
     */
    @Then("User verifies that the currency has changed in the menu")
    public void user_verifies_that_the_currency_has_changed_in_the_menu() {
        if(!beforeCurrencySymbol.equals(afterCurrencySymbol)){
            Assert.assertNotEquals(beforeCurrencySymbol,afterCurrencySymbol);
        }
    }




}
