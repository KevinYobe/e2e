package com.ownai.e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PayWithCassavaPay {

    private WebDriver driver;
    private final String cassavapayOnlineRadioBtnXpath = "/html/body/div[2]/main/div/div/div[3]/div[4]/ol/li[4]/div/form/fieldset/div[1]/div/div/div[2]/div[1]/input";
    private final String cassavapayOnlineSubmitBtnXpath = "/html/body/div[2]/main/div/div/div[3]/div[4]/ol/li[4]/div/form/fieldset/div[1]/div/div/div[2]/div[2]/div[4]/div/button";
    private final String cassavaPayTermsandConditions = "/html/body/div[2]/main/div/div/div[3]/div[4]/ol/li[4]/div/form/fieldset/div[1]/div/div/div[2]/div[2]/div[3]/div/div/div/input";

    @FindBy(how = How.XPATH, using = cassavapayOnlineRadioBtnXpath)
    WebElement cassavaPayRadioBtn;

    @FindBy(how = How.XPATH, using = cassavaPayTermsandConditions)
    WebElement cassavaPayTermsAndCondionsCheckBox;

    @FindBy(how = How.XPATH, using = cassavapayOnlineSubmitBtnXpath)
    WebElement cassavaPaySubmitBtn;

    public PayWithCassavaPay setDriver(WebDriver driver){
        this.driver = driver;
        return this;
    }
    public PayWithCassavaPay selectRadioBtn(){
        new Actions(driver)
                .moveToElement(cassavaPayRadioBtn)
                .click()
                .build()
                .perform();
        return this;
    }

    public PayWithCassavaPay confirmTermsAndConditions(){
        new Actions(driver)
                .moveToElement(cassavaPayTermsAndCondionsCheckBox)
                .click()
                .build()
                .perform();
        return this;
    }

    public PaymentCompletePage submit(){
        new Actions(driver)
                .moveToElement(cassavaPaySubmitBtn)
                .click()
                .build()
                .perform();
        return new PaymentCompletePage();
    }
}
