package com.epam.klymenko.ui.pages;

import com.epam.klymenko.core.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Liliia_Klymenko on 10/27/2015.
 */
public class HomePage {

    @FindBy(className = "main_page_link_catalog")
    public WebElement linkCatalog;

    String baseURL = "pn.com.ua";

    public HomePage()
    {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void go() {
        Driver.getDriver().get(baseURL);
    }

    public CategoryPage selectCatalog()
    {
        linkCatalog.click();
        return new CategoryPage();
    }
}
