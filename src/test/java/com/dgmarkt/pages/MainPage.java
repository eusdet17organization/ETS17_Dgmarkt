package com.dgmarkt.pages;

import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage{
    @FindBy(xpath = "//a[@class='a-close-newsletter']")
    public WebElement popUpButton;
    @FindBy(xpath = "//div[@class='container-inner']/h1")
    public WebElement subCategoryTitle;

    public void closePopUp() {
        popUpButton.click();
    }
    public void clickMainButton(String buttonName) {
        Driver.get().findElement(
                By.xpath("//a[@class='a-top-link']//span[text()='" + buttonName + "']")).click();

    }
    public void clickSubButton(String subButtonName) {
        clickMainButton("Category");
        Driver.get().findElement(
                By.xpath("//div[@class='row']/div/h4/a[text()='" + subButtonName + "']")).click();


        }

    /***
     * Parametre ile Category dropdown altindaki Health & Beauty,Televisions,TV Accessories,Networking alt category'lere gider
     * @param dropdownMenu
     */
    public void navigateCategoryDropdown(String dropdownMenu){
            BrowserUtils.hover(Driver.get().findElement(By.xpath("//a[@class='a-top-link']//span[text()='Category']")));
            Driver.get().findElement(By.linkText(dropdownMenu)).click();
        }
}
