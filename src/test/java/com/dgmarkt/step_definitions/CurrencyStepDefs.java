package com.dgmarkt.step_definitions;

import com.dgmarkt.pages.MainPage;
import com.dgmarkt.pages.SearchPage;
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
}
