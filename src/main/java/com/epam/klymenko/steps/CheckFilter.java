package com.epam.klymenko.steps;

import com.epam.klymenko.core.SetUp;
import com.epam.klymenko.ui.helpers.SubcategoryHelper;
import com.epam.klymenko.ui.pages.CategoryPage;
import com.epam.klymenko.ui.pages.HomePage;
import com.epam.klymenko.ui.pages.SubcategoryPage;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.junit.Assert;

/**
 * Created by Lili on 27.10.2015.
 */
public class CheckFilter extends SetUp {

    private SubcategoryHelper subcategoryHelper;
    private SubcategoryPage subcategoryPage;
    HomePage homepage;
    CategoryPage categoryPage;

    private int expected = 1;
    private String name;

    @Given("I am on pn.com.ua")
    public void openHomePage(){
        homepage = new HomePage();
        homepage.go();
    }

    @When("Select category")
    public void selectCategory(){
        homepage.selectCatalog();
    }

    @When("Select sub category")
    public void selectSubCategory(){
        categoryPage = new CategoryPage();
        categoryPage.selectSubcatalog();
    }

    @When("Sort items by price")
    public void setMinPrice(){
        subcategoryPage = new SubcategoryPage();
        subcategoryPage.setMinPrice.click();
    }

    @When("Take the name of the cheapest good")
    public String selectCheapestGood(){
        return subcategoryPage.selectFirstItem().ItemName.getText();
    }

    @When("Enter the name into search box")
    public void enterNameIntoSearch() {
        name = selectCheapestGood();
        subcategoryPage.search.sendKeys(name);
        subcategoryPage.searchSubmit.click();
    }

    @Then("The search result is equal to 1")
    public void searchResultEqualToExpected(){
        String actualResult = subcategoryPage.amountOfSearchResults.getText();
        Assert.assertEquals("The search result is equal to 1", Integer.parseInt(actualResult), expected);
    }

    @Then("The name of the product is equal to the specified name")
    public void nameProductIsEqualToSpecifiedName(){
        Assert.assertSame("The name of the product is equal to the specified name",
                name , subcategoryPage.MANUFACTURER);
    }

    @When("Select manufacturer")
    public void selectManufacturer(){
        new SubcategoryPage().setManufact.click();
    }


    @Then("The amount of goods is equal to the number displayed next to the name")
    public void AmounGoodsIsEqualToNumberDisplayedNextToName(){
        new SubcategoryHelper();
        Assert.assertEquals("The results match the search parameters",
                subcategoryHelper.getAmountOfManufacturers(), subcategoryHelper.getAmountOfItemsOnPage());
    }

    @Then("The names of the goods begin with the selected")
    public void namesOfGoodsBeginWithSelected(){
        new SubcategoryHelper();
        Assert.assertTrue("The names of the goods begin with the selected",
                subcategoryHelper.namesBeginWithManufactName());
    }

    @When("Set min and max price")
    public void setMinAndMaxPrice(){
        subcategoryPage = new SubcategoryPage();
        subcategoryPage.setMaxPrice.click();
        subcategoryPage.setMinPrice.click();
    }


    @Then("The results match the search parameters")
    public void resultsMatchSearchParameters(){
        Assert.assertTrue("The results match the search parameters", new SubcategoryHelper().elementsIsOnRange());
    }
}
