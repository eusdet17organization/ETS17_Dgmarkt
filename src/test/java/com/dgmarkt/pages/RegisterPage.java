package com.dgmarkt.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RegisterPage extends BasePage{

    @FindBy(id = "input-firstname")
    public WebElement firstName;

    @FindBy(id = "input-lastname")
    public WebElement lastName;

    @FindBy(id = "input-register-email")
    public WebElement email;

    @FindBy(id = "input-telephone")
    public WebElement telephone;

    @FindBy(id = "input-register-password")
    public WebElement password;

    @FindBy(id = "input-confirm")
    public WebElement passwordConfirm;

    @FindBy(xpath = "//input[@name='agree']")
    public WebElement privacyPolicyCheckBox;

    @FindBy(xpath = "//b[text()='Privacy Policy']")
    public WebElement privacyPolicyText;

    @FindBy(xpath = "//input[@value='Continue']")
    public WebElement continueButton;

    @FindBy(xpath = "(//input[@placeholder])[position() >= 4 and position() <= 9]")
    public List<WebElement> AllTextBoxPlaceholderName;



    public void userRegister(){
        Faker faker=new Faker();
        firstName.sendKeys(faker.name().firstName());
        lastName.sendKeys(faker.name().lastName());
        email.sendKeys(faker.internet().emailAddress());
        telephone.sendKeys(faker.phoneNumber().phoneNumber());
        password.sendKeys("123456789");
        passwordConfirm.sendKeys("123456789");
        privacyPolicyCheckBox.click();
        continueButton.click();
    }

    public void userRegister(String firstName, String lastName, String email, String telephone, String password, String passwordConfirm){
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.email.sendKeys(email);
        this.telephone.sendKeys(telephone);
        this.password.sendKeys(password);
        this.passwordConfirm.sendKeys(passwordConfirm);

    }

}
