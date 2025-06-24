package com.dgmarkt.pages;

import com.dgmarkt.utilities.Driver;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public abstract class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    protected Select select;


}
