package com.dgmarkt.step_definitions;


import com.dgmarkt.utilities.Driver;
import org.junit.Assert;
import com.dgmarkt.pages.LoginPage;
import com.dgmarkt.pages.LoginPanelPage;
import com.dgmarkt.pages.MainPage;
import com.dgmarkt.pages.WistListPage;
import com.dgmarkt.utilities.BrowserUtils;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.dgmarkt.utilities.Driver.driver;

public class WishListStepDefs {
    WistListPage wistListPage = new WistListPage();
    LoginPanelPage loginPanelPage=new LoginPanelPage();

    MainPage mainPage=new MainPage();

    LoginPage loginPage = new LoginPage();

    @Then("user clicks from category to television")
    public void user_clicks_from_category_to_television() {
        loginPage.userLogin();
        BrowserUtils.waitFor(5);
        mainPage.clickMainButton("Category");

        mainPage.clickSubButton("Televisions");

    }
    @When("User hovers over the product and clicks the wish list button")
    public void user_hovers_over_the_product_and_clicks_the_wish_list_button() {
     wistListPage.addTheWishListWithHover(11);


    }
    @Then("User wish list sees added pop-ups")
    public void user_wish_list_sees_added_pop_ups() {
        String actualMessage = wistListPage.getSuccessMessage();
        String expectedMessage  = wistListPage.getSuccessMessageText();

        Assert.assertTrue("Success message is not displayed!", actualMessage.contains(expectedMessage));

        System.out.println("Success Message: " + actualMessage);
    }




    @Then("User confirms that the product has been added to the wish list")
    public void user_confirms_that_the_product_has_been_added_to_the_wish_list() {
        BrowserUtils.waitFor(5);
       wistListPage.clickWishList();
        Assert.assertTrue("Product name is incorrect!",
        wistListPage.getProductName().equalsIgnoreCase("Daewoo D24RTSDVD 24\" Smart LED TV With DVD"));
        System.out.println(" : Product details have been successfully verified:");
        System.out.println(" : Name: " + wistListPage.getProductName());

    }

    @Then("user confirms that the base has been deleted")
    public void user_confirms_that_the_base_has_been_deleted() {
        BrowserUtils.hover(wistListPage.removeButton);
        BrowserUtils.waitFor(1);
        wistListPage.removeButton.click();
        BrowserUtils.waitFor(1);
    }
    @Then("user  {string} sees your message")
    public void user_sees_your_message(String string) {
        Assert.assertTrue(Driver.get().findElement(By.cssSelector("#account-wishlist > div.alert.alert-success.alert-dismissible")).isDisplayed());
        System.out.println(wistListPage.getModifiedMassage());
    }

    @Then("User adds the product in the wist list to the cart")
    public void user_adds_the_product_in_the_wist_list_to_the_cart() {

    }

    @Then("User confirms that the product has been added to the cart")
    public void user_confirms_that_the_product_has_been_added_to_the_cart() {

    }


}
