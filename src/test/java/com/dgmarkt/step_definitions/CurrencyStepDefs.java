package com.dgmarkt.step_definitions;

import com.dgmarkt.pages.CartIconPage;
import com.dgmarkt.pages.MainPage;
import com.dgmarkt.pages.SearchPage;
import com.dgmarkt.pages.ViewCartPage;
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


    @When("User navigate to {string} page")
    public void user_navigate_to_page(String productPageName) {
        mainPage.navigateCategoryDropdown(productPageName);
    }

    @When("User click the Currency text")
    public void user_click_the_currency_text() {
        mainPage.currencyText.click();
    }

    @When("User click the any {string}")
    public void user_click_the_any(String curreny) {
        Driver.get().findElement(By.xpath("//button[text()='" + curreny + "']")).click();
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

}
