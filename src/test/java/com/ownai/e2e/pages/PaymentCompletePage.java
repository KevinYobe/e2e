package com.ownai.e2e.pages;

import com.ownai.e2e.pages.user.CreateAccount;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PaymentCompletePage {

    private final String successMessageXpath = "/html/body/div[1]/main/div[2]/div/div[1]/h1";
    private final String continueShoppingBthXpath = "/html/body/div[1]/main/div[2]/div/div[3]/div/div/a";
    private final String createAccountXpathBthXpath = "/html/body/div[1]/main/div[2]/div/div[4]/div[2]/a";

    @FindBy(how = How.XPATH, using = successMessageXpath)
    WebElement successMessageText;

    @FindBy(how = How.XPATH, using = continueShoppingBthXpath)
    WebElement continueShoppingBtn;

    @FindBy(how = How.XPATH, using = createAccountXpathBthXpath)
    WebElement createAccountBth;

    public String getSuccessMessage(){
        return successMessageText.getText();
    }

    public LandingPage continueShopping(){
        continueShoppingBtn.click();
        return new LandingPage();
    }

    public CreateAccount createAccount(){
        createAccountBth.click();
        return new CreateAccount();
    }
}
