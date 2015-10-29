package com.epam.klymenko.ui.pages;

import com.epam.klymenko.core.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Liliia_Klymenko on 10/27/2015.
 */
public class ItemPage {

      public ItemPage()
    {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h1")
    public WebElement ItemName;


}
