package com.epam.klymenko.ui.pages;

import com.epam.klymenko.core.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by Liliia_Klymenko on 10/27/2015.
 */
public class SubcategoryPage {

    public static final int MAX_PRICE = 9000;
    public static final int MIN_PRICE = 3000;
    public static final String MANUFACTURER = "ASUS";

    private final String minxPath = "//a[contains(text(),'" + MIN_PRICE + "')][1]";
    private final String maxxPath = "//a[contains(text(),'" + MAX_PRICE + "')][2]";
    private final String manufactxPath = "//a[contains(text(),'" + MANUFACTURER + "')]";

    @FindBy(xpath = "//div[3]/div[3]/div/a")
    public WebElement firstItem;

    @FindBy(xpath = "//div[22]/div/a")
    public WebElement lastItem;

    @FindBy(xpath = "//div[@class='price']/strong")
    public List<WebElement> listItemsPrices;

    @FindBy(xpath = "//div[@class='name']/a")
    public List<WebElement> listItemsNames;

    @FindBy(xpath = minxPath)
    public WebElement setMinPrice;

    @FindBy(xpath = maxxPath)
    public WebElement setMaxPrice;

    @FindBy(xpath = manufactxPath)
    public WebElement setManufact;

    @FindBy(xpath = "//input[@id='edit-name-1']")
    public WebElement search;

    @FindBy(id= "edit-submit-1")
    public WebElement searchSubmit;

    @FindBy(xpath = "//b")
    public WebElement amountOfSearchResults;

    @FindBy(xpath = "//div[2]/span")
    public WebElement amountOfSearchResultsInCategory;

    @FindBy(xpath = manufactxPath + "/following-sibling::i[1]")
    public WebElement amountOfManufacturers;

    public SubcategoryPage()
    {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public ItemPage selectFirstItem()
    {
        firstItem.click();
        return new ItemPage();
    }

    public String getAmountOfSearchResults()
    {
        return amountOfSearchResults.getText();
    }


    public String getAmountOfSearchResultsInCategory()
    {
        return amountOfSearchResultsInCategory.getText().substring(1,2);
    }


}
