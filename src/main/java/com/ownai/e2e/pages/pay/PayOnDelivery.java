package com.ownai.e2e.pages.pay;

import com.ownai.e2e.pages.AbstractPage;
import com.ownai.e2e.pages.PaymentCompletePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

@Component
public class PayOnDelivery extends AbstractPage {
    private final String payOnDeliverRadioBtn = "/html/body/div[2]/main/div/div/div[3]/div[4]/ol/li[4]/div/form/fieldset/div[1]/div/div/div[4]/div[1]/input";
    private final String payOnDeliverySubmitXpath = "/html/body/div[2]/main/div/div/div[3]/div[4]/ol/li[4]/div/form/fieldset/div[1]/div/div/div[4]/div[2]/div[4]/div/button";
    private final String payOnDeliveryTermsandConditions = "/html/body/div[2]/main/div/div/div[3]/div[4]/ol/li[4]/div/form/fieldset/div[1]/div/div/div[4]/div[2]/div[3]/div/div/div/input";

    @FindBy(how = How.XPATH, using = payOnDeliverRadioBtn)
    WebElement payOnDeliveryRadioBtn;

    @FindBy(how = How.XPATH, using = payOnDeliveryTermsandConditions)
    WebElement payOnDeliveryTermsAndCondionsCheckBox;

    @FindBy(how = How.XPATH, using = payOnDeliverySubmitXpath)
    WebElement payOnDeliverySubmitBtn;

    public PayOnDelivery(WebDriver driver) {
        super(driver);
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

    public void submit(){
        new Actions(driver)
                .moveToElement(payOnDeliverySubmitBtn)
                .click()
                .build()
                .perform();
    }
}
