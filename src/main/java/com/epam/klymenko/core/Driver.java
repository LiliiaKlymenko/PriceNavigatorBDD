package com.epam.klymenko.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Liliia_Klymenko on 10/27/2015.
 */
public class Driver {

    private static WebDriver driver;
    static int count = 0;

    public static WebDriver runDriver() {
        driver = new FirefoxDriver();
        count +=1;
        return driver;
    }

    public static WebDriver getDriver() {
        if (count==0) {
            return runDriver();
        }
        else
            return  driver;
    }

    public static void open(String url) {
        driver.navigate().to(url);
    }

    public static void close() {
        driver.close();
    }
}