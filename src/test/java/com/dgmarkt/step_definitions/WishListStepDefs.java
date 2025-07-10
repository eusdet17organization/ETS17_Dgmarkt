package com.dgmarkt.step_definitions;


import com.dgmarkt.pages.*;
import com.dgmarkt.utilities.ConfigurationReader;
import com.dgmarkt.utilities.Driver;
import org.junit.Assert;
import com.dgmarkt.utilities.BrowserUtils;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.dgmarkt.utilities.Driver.driver;

public class WishListStepDefs {
    SearchPage searchPage= new SearchPage();
    CartIconPage cartIconPage = new CartIconPage();
    WistListPage wistListPage = new WistListPage();
    LoginPanelPage loginPanelPage = new LoginPanelPage();

    MainPage mainPage = new MainPage();

    LoginPage loginPage = new LoginPage();
    protected String product;

    @When("User click the search icon {string} and search")
    public void user_click_the_search_icon_and_search(String product) {

        BrowserUtils.waitForClickablility(searchPage.searchIcon,5);
        searchPage.searchIcon.click();
        BrowserUtils.waitForClickablility(searchPage.searchText,5);
        searchPage.searchText.sendKeys(product);
        this.product=product;
        BrowserUtils.waitForClickablility(searchPage.searchIconWithSearchText,5);
        searchPage.searchIconWithSearchText.click();


    }

    @When("User hovers over the product and clicks the wish list button")
    public void user_hovers_over_the_product_and_clicks_the_wish_list_button() {
        wistListPage.addTheWishListWithHover(0);


    }

    @Then("User wish list sees added pop-ups")
    public void user_wish_list_sees_added_pop_ups() {
        String actualMessage = wistListPage.getSuccessMessage();
        String expectedMessage = wistListPage.getSuccessMessageText();
        Assert.assertTrue("Success message is not displayed!", actualMessage.contains(expectedMessage));
        System.out.println("Success Message: " + actualMessage);
    }


    @Then("User confirms that the product has been added to the wish list")
    public void user_confirms_that_the_product_has_been_added_to_the_wish_list() {

        wistListPage.clickWishList();
        //Assert.assertTrue("Product name is incorrect!", wistListPage.getProductName().contains(product));
        Assert.assertTrue(Driver.get().findElement(By.partialLinkText(product)).getText().contains(product));
        System.out.println(" : Product details have been successfully verified:");
        System.out.println(" : Name: " + wistListPage.getProductName());

        }


    @Then("user confirms that the base has been deleted")
    public void user_confirms_that_the_base_has_been_deleted() {
        BrowserUtils.hover(wistListPage.removeButton);
        BrowserUtils.waitForVisibility(By.xpath("//a[@data-original-title='Remove']"),1);
        wistListPage.removeButton.click();

    }

    @Then("user  {string} sees your message")
    public void user_sees_your_message(String string) {
        Assert.assertTrue(Driver.get().findElement(By.cssSelector("#account-wishlist > div.alert.alert-success.alert-dismissible")).isDisplayed());
        System.out.println(wistListPage.getModifiedMassage());
    }

    @Then("User adds the product in the wist list to the cart")
    public void user_adds_the_product_in_the_wist_list_to_the_cart() {
        wistListPage.clickCart.click();
    }

    @Then("User add to cart sees added pop-ups")
    public void user_add_to_cart_sees_added_pop_ups() {
        String actualMessage = wistListPage.getSuccessMessage();
        String expectedMessage = wistListPage.getSuccessMessageText();
        Assert.assertTrue("Success message is not displayed!", actualMessage.contains(expectedMessage));
        System.out.println("Success Message: " + actualMessage);
    }


    @Then("User confirms that the product has been added to the cart")
    public void user_confirms_that_the_product_has_been_added_to_the_cart() {

        cartIconPage.clickCartIcon();
        //Assert.assertTrue("Product name is incorrect!",wistListPage.getProductNameinCartİcon().contains(product));
        Assert.assertTrue(Driver.get().findElement(By.partialLinkText(product)).getText().contains(product));
        System.out.println(" : Product details have been successfully verified:");
       // System.out.println(" : Name: " + wistListPage.getProductNameinCartİcon());


    }



    @Then("User wish list sees added pop-ups clicks to login")
    public void user_wish_list_sees_added_pop_ups_clicks_to_login() {
       wistListPage.clickLoginLinkWithJS();


    }

    @Then("user logs in  clicks to wish list button")
    public void user_logs_in_clicks_to_wish_list_button() {
     wistListPage.userLoginWishList();


    }
}
