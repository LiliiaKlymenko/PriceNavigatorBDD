package com.epam.klymenko.ui.pages;

import com.epam.klymenko.core.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Liliia_Klymenko on 10/27/2015.
 */
public class CategoryPage {

    @FindBy(xpath = "//div[3]/a")
    public WebElement linkSubcatalog;

    public CategoryPage()
    {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public SubcategoryPage selectSubcatalog()
    {
        linkSubcatalog.click();
        return new SubcategoryPage();
    }
}
