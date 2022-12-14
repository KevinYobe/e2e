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
public class PayWithZipit extends AbstractPage {
    private final String payWithzipitRadioBtn = "/html/body/div[2]/main/div/div/div[3]/div[4]/ol/li[4]/div/form/fieldset/div[1]/div/div/div[5]/div[1]/input";
    private final String payWithzipitSubmitXpath = "/html/body/div[2]/main/div/div/div[3]/div[4]/ol/li[4]/div/form/fieldset/div[1]/div/div/div[5]/div[2]/div[4]/div/button";
    private final String payWithzipitTermsandConditions = "/html/body/div[2]/main/div/div/div[3]/div[4]/ol/li[4]/div/form/fieldset/div[1]/div/div/div[5]/div[2]/div[3]/div/div/div/input";

    private final String applyDiscountXpath = "";

    @FindBy(how = How.XPATH, using = payWithzipitRadioBtn)
    WebElement zipitRadioRadioBtn;

    @FindBy(how = How.XPATH, using = payWithzipitTermsandConditions)
    WebElement zipitTermsAndCondionsCheckBox;

    @FindBy(how = How.XPATH, using = payWithzipitSubmitXpath)
    WebElement zipitSubmitBtn;

    public PayWithZipit(WebDriver driver) {
        super(driver);
    }

    public PayWithZipit selectRadioBtn() throws InterruptedException {
        Thread.sleep(5000);
        new Actions(driver)
                .moveToElement(zipitRadioRadioBtn)
                .click()
                .build()
                .perform();
        return this;
    }


    public PayWithZipit confirmTermsAndConditions() throws InterruptedException {
        Thread.sleep(5000);
        zipitTermsAndCondionsCheckBox.click();
        return this;
    }

    public void submit() throws InterruptedException {
        Thread.sleep(5000);
        new Actions(driver)
                .moveToElement(zipitSubmitBtn)
                .click()
                .build()
                .perform();
    }

    public void applyDiscountCode(String DiscountCode){
    }
}
