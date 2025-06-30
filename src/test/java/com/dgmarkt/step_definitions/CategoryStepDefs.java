package com.dgmarkt.step_definitions;

import com.dgmarkt.pages.MainPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CategoryStepDefs {
    MainPage mainPage = new MainPage();

    @When("The user clicks on the Television subcategory.")
    public void the_user_clicks_on_the_television_subcategory() {
        mainPage.clickSubButton("Televisions");

    }

    @Then("The user verifies that the Television subcategory page is displayed.")
    public void the_user_verifies_that_the_television_subcategory_page_is_displayed() {
        String actualTitle = mainPage.subCategoryTitle.getText();
        String expectedTitle = "Televisions";
        Assert.assertEquals("Television subcategory page is not displayed", expectedTitle, actualTitle);
    }

    @When("The user clicks on the Health & Beauty subcategory.")
    public void the_user_clicks_on_the_health_beauty_subcategory() {
        mainPage.clickSubButton("Health & Beauty");
    }

    @Then("The user verifies that the Health & Beauty subcategory page is displayed.")
    public void the_user_verifies_that_the_health_beauty_subcategory_page_is_displayed() {
        String actualTitle = mainPage.subCategoryTitle.getText();
        String expectedTitle = "Health & Beauty";
        Assert.assertEquals("Health & Beauty subcategory page is not displayed", expectedTitle, actualTitle);
    }

    @When("The user clicks on the TV Accessories subcategory.")
    public void the_user_clicks_on_the_tv_accessories_subcategory() {
        mainPage.clickSubButton("TV Accessories");
    }

    @Then("The user verifies that the TV Accessories subcategory page is displayed.")
    public void the_user_verifies_that_the_tv_accessories_subcategory_page_is_displayed() {
        String actualTitle = mainPage.subCategoryTitle.getText();
        String expectedTitle = "TV Accessories";
        Assert.assertEquals("TV Accessories subcategory page is not displayed", expectedTitle, actualTitle);
    }

    @When("The user clicks on the Networking subcategory.")
    public void the_user_clicks_on_the_networking_subcategory() {
        mainPage.clickSubButton("Networking");
    }

    @Then("The user verifies that the Networking subcategory page is displayed.")
    public void the_user_verifies_that_the_networking_subcategory_page_is_displayed() {
        String actualTitle = mainPage.subCategoryTitle.getText();
        String expectedTitle = "Networking";
        Assert.assertEquals("Networking subcategory page is not displayed", expectedTitle, actualTitle);
    }

}
