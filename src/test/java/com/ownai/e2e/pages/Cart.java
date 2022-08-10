package com.ownai.e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.stereotype.Component;

@Component
public class Cart {

    private WebDriver driver;
    private final String checkoutBtnXpath = "/html/body/div[2]/main/div[2]/div/div[3]/div[1]/ul/li[1]/button";

    @FindBy(how = How.XPATH, using = checkoutBtnXpath)
    private WebElement checkoutBtn;

    public Cart setDriver(WebDriver driver){
        this.driver=driver;
        return this;
    }

    public Checkout proceedToCheckout() throws InterruptedException {
        Thread.sleep(10000);
        new Actions(driver)
                .moveToElement(checkoutBtn)
                .click()
                .build()
                .perform();
        return new Checkout();
    }

    public Shipping checkoutRegisteredUser() throws InterruptedException {
        Thread.sleep(10000);
        new Actions(driver)
                .moveToElement(checkoutBtn)
                .click()
                .build()
                .perform();
        return new Shipping();
    }
}
