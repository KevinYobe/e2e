package com.ownai.e2e.pages.pay;

import com.ownai.e2e.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

@Component
public class PayWithPayPal extends AbstractPage {
    private final String payPalRadioBtnXpath = "/html/body/div[2]/main/div/div/div[3]/div[4]/ol/li[4]/div/form/fieldset/div[1]/div/div/div[3]/div[1]/input";
    private final String payPayTermsandConditions = "/html/body/div[2]/main/div/div/div[3]/div[4]/ol/li[4]/div/form/fieldset/div[1]/div/div/div[3]/div[2]/div[2]/div/div/div/input";
    private final String PayPalSubmitBtnXpath = "/html/body/div[2]/main/div/div/div[3]/div[4]/ol/li[4]/div/form/fieldset/div[1]/div/div/div[3]/div[2]/div[3]/div/button";

    @FindBy(how = How.XPATH, using = payPalRadioBtnXpath)
    WebElement payPalRadioBtn;

    @FindBy(how = How.XPATH, using = payPayTermsandConditions)
    WebElement payPalTermsAndCondionsCheckBox;

    @FindBy(how = How.XPATH, using = PayPalSubmitBtnXpath)
    WebElement payPalSubmitBtn;

    public PayWithPayPal(WebDriver driver) {
        super(driver);
    }

    public PayWithPayPal selectRadioBtn() throws InterruptedException {
        Thread.sleep(5000);
        new Actions(driver)
                .moveToElement(payPalRadioBtn)
                .click()
                .build()
                .perform();
        return this;
    }

    public PayWithPayPal confirmTermsAndConditions() throws InterruptedException {
        Thread.sleep(5000);
        new Actions(driver)
                .moveToElement(payPalTermsAndCondionsCheckBox)
                .click()
                .build()
                .perform();
        return this;
    }

    public void submit() throws InterruptedException {
        Thread.sleep(5000);
        new Actions(driver)
                .moveToElement(payPalSubmitBtn)
                .click()
                .build()
                .perform();
    }
}
