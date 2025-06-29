package com.dgmarkt.pages;

import com.dgmarkt.utilities.BrowserUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.sql.DriverManager;

public class CartIconPage extends BasePage {


    SearchPage searchPage=new SearchPage();


    @FindBy(id = "cart")
    WebElement cartIcon;

    @FindBy(css = "p.text-center")
    WebElement emptyCartMessage;

    @FindBy(css = ".dropdown-toggle.search-button") // arama
    public WebElement searchButton;

    @FindBy(css = "input[name='search']") // input
    public WebElement searchInput;


    /*
    stale element hatasi
    @FindBy(xpath = "//a[contains(text(),'Belkin Standard HDMI cable')]")p
    ublic WebElement productLink;
     */


    @FindBy(css = "div.product-image img[alt='Belkin Standard HDMI cable']")
    public WebElement productImage;




    @FindBy(css = "#button-car")
    public WebElement addToCartButton;

    public void clickCartIcon() {
        cartIcon.click();
    }

    public String getEmptyCartMessage() {
        return emptyCartMessage.getText();
    }



    // calistiramadim
    public void searchButton2(String searchText) {

        BrowserUtils.waitForClickablility(searchButton, 10);
        searchButton.click();


        BrowserUtils.waitForVisibility(searchInput, 10);
        searchInput.clear();
        searchInput.sendKeys(searchText);
        searchInput.sendKeys(Keys.ENTER);
    }

    public void setSearchButton1 (){
        BrowserUtils.waitForVisibility(searchPage.searchIcon, 10);
        searchPage.searchIcon.click();
        searchPage.searchIcon.clear();
        searchPage.searchIcon.sendKeys("Belkin Standard HDMI cable");
        BrowserUtils.waitFor(2);
        BrowserUtils.waitForClickablility(searchPage.searchIconWithSearchText, 10);
        searchPage.searchIconWithSearchText.click();
        BrowserUtils.waitFor(3);



    }
}



