package com.ownai.e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PayOnDelivery {
    private WebDriver driver;
    private final String payOnDeliverRadioBtn = "/html/body/div[2]/main/div/div/div[3]/div[4]/ol/li[4]/div/form/fieldset/div[1]/div/div/div[4]/div[1]/input";
    private final String payOnDeliverySubmitXpath = "/html/body/div[2]/main/div/div/div[3]/div[4]/ol/li[4]/div/form/fieldset/div[1]/div/div/div[4]/div[2]/div[4]/div/button";
    private final String payOnDeliveryTermsandConditions = "/html/body/div[2]/main/div/div/div[3]/div[4]/ol/li[4]/div/form/fieldset/div[1]/div/div/div[4]/div[2]/div[3]/div/div/div/input";

    @FindBy(how = How.XPATH, using = payOnDeliverRadioBtn)
    WebElement payOnDeliveryRadioBtn;

    @FindBy(how = How.XPATH, using = payOnDeliveryTermsandConditions)
    WebElement payOnDeliveryTermsAndCondionsCheckBox;

    @FindBy(how = How.XPATH, using = payOnDeliverySubmitXpath)
    WebElement payOnDeliverySubmitBtn;


    public PayOnDelivery setDriver(WebDriver driver){
        this.driver = driver;
        return this;
    }

    public PayOnDelivery selectRadioBtn(){
        new Actions(driver)
                .moveToElement(payOnDeliveryRadioBtn)
                .click()
                .build()
                .perform();
        return this;
    }

    public PayOnDelivery confirmTermsAndConditions(){
        new Actions(driver)
                .moveToElement(payOnDeliveryTermsAndCondionsCheckBox)
                .click()
                .build()
                .perform();
        return this;
    }

    public PaymentCompletePage submit(){
        new Actions(driver)
                .moveToElement(payOnDeliverySubmitBtn)
                .click()
                .build()
                .perform();
        return new PaymentCompletePage();
    }
}
