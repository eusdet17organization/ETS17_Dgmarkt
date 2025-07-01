package com.dgmarkt.step_definitions;

import com.dgmarkt.pages.MainPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CategoryStepDefs {
    MainPage mainPage = new MainPage();

    @When("The user clicks on the {string} subcategory.")
    public void the_user_clicks_on_the_subcategory(String subCategory) {
        mainPage.clickSubButton(subCategory);


    }
    @Then("The user verifies that the {string} subcategory page is displayed.")
    public void the_user_verifies_that_the_subcategory_page_is_displayed(String subCategory) {
        String actualTitle = mainPage.subCategoryTitle.getText();
        Assert.assertEquals(subCategory + " subcategory page is not displayed", subCategory, actualTitle);

    }
}
