package com.epam.klymenko.ui.helpers;

import com.epam.klymenko.ui.pages.SubcategoryPage;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Lili on 27.10.2015.
 */
public class SubcategoryHelper {

    SubcategoryPage subcategoryPage;

    public boolean elementsIsOnRange(){
        List<WebElement> list = subcategoryPage.listItemsPrices;
        for (WebElement element : list)
        {
            int elementPrice = Integer.parseInt(element.getText());
            if (elementPrice>subcategoryPage.MAX_PRICE && elementPrice<subcategoryPage.MIN_PRICE)
                return false;
        }
        return true;
    }

    public int getAmountOfManufacturers(){
        return Integer.parseInt(subcategoryPage.amountOfManufacturers.getText());
    }

    public int getAmountOfItemsOnPage(){
        return Integer.parseInt(subcategoryPage.amountOfSearchResults.getText());
    }

    public boolean namesBeginWithManufactName(){

        String manufactName = subcategoryPage.setManufact.getText();
        List<WebElement> list = subcategoryPage.listItemsPrices;

        for (WebElement element : list)
        {
            String elementName = element.getText();
            if (!elementName.startsWith(manufactName))
                return false;
        }
        return true;
    }
}
