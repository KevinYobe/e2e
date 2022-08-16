package com.ownai.e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

@Component
public class PaymentCompletePage extends AbstractPage{

    private final String successMessageXpath = "/html/body/div[1]/main/div[2]/div/div[1]/h1";
    private final String continueShoppingBthXpath = "/html/body/div[1]/main/div[2]/div/div[3]/div/div/a";
    private final String createAccountXpathBthXpath = "/html/body/div[1]/main/div[2]/div/div[4]/div[2]/a";

    @FindBy(how = How.XPATH, using = successMessageXpath)
    WebElement successMessageText;

    @FindBy(how = How.XPATH, using = continueShoppingBthXpath)
    WebElement continueShoppingBtn;

    @FindBy(how = How.XPATH, using = createAccountXpathBthXpath)
    WebElement createAccountBth;

    public PaymentCompletePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public String getSuccessMessage(){
        return successMessageText.getText();
    }

    public AbstractPage createAccount(){
        createAccountBth.click();
        return new AbstractPage(driver);
    }

    public AbstractPage continueShopping(){
        continueShoppingBtn.click();
        return new AbstractPage(driver);
    }


}
