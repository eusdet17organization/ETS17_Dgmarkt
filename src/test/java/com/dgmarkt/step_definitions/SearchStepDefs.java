package com.dgmarkt.step_definitions;

import com.dgmarkt.pages.SearchPage;
import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.Browser;

import java.util.List;

public class SearchStepDefs {

    SearchPage searchPage=new SearchPage();

    @When("User click the search icon")
    public void user_click_the_search_icon() {
        searchPage.searchIcon.click();
    }
    @When("User enter {string} and search")
    public void user_enter_and_search(String product) {
        searchPage.searchText.sendKeys(product);
        searchPage.searchIconWithSearchText.click();

    }
    @Then("User verifies {string} results")
    public void user_verifies_results(String product) {
        List<String> searchProduct = BrowserUtils.getElementsText(searchPage.productName);
        for (String s:searchProduct){
            Assert.assertTrue(s.toLowerCase().contains(product.toLowerCase().trim()));
        }
    }

    @Then("User verifies {string} message")
    public void user_verifies_message(String message) {
        String actual = Driver.get().findElement(By.xpath("(//div[@id='content']//p)[2]")).getText();
        Assert.assertEquals(message,actual);
    }

}
