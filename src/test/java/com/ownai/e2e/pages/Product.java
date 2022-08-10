package com.ownai.e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.stereotype.Component;

@Component
public class Product {

    WebDriver driver;
    final private String addToCartXpath = "/html/body/div[1]/main/div[3]/div[1]/div[4]/ol/li[2]/div/div[2]/div[2]/div/div[1]/form/button";

    private final String alertXpath = "/html/body/div[3]/aside[1]/div[2]/div/div/div[3]/div[2]/a[2]";

    @FindBy(how = How.XPATH, using = addToCartXpath)
    private WebElement addToCart;

    @FindBy(how = How.XPATH, using = alertXpath)
    private WebElement alertBtn;

    public Product setDriver(WebDriver driver) {
        this.driver = driver;
        return this;
    }


    public Product addToCart() throws InterruptedException {
       // Thread.sleep(5000);
        new Actions(driver)
                .moveToElement(addToCart)
                .click()
                .build()
                .perform();
        return this;
    }

    public Cart confirmAlert() throws InterruptedException {
       Thread.sleep(3000);
        new Actions(driver)
                .moveToElement(alertBtn)
                .click()
                .build()
                .perform();
        return new Cart();
    }


}
