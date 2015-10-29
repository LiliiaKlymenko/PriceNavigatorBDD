package com.epam.klymenko.core;

import com.epam.klymenko.ui.pages.CategoryPage;
import com.epam.klymenko.ui.pages.HomePage;
import com.sun.corba.se.pept.broker.Broker;
import org.jbehave.core.annotations.*;
import org.jbehave.core.steps.Steps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Liliia_Klymenko on 10/27/2015.
 */

public class SetUp extends Steps {


    protected WebDriver driver;

    @BeforeScenario
    public void Init()
    {
        driver = new Driver().getDriver();
        Driver.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @AfterScenario
    public void TearDown()
    {
        driver.close();
    }

}
