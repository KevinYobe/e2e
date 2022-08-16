package com.ownai.e2e.pages.cart;

import com.ownai.e2e.pages.AbstractPage;
import com.ownai.e2e.pages.shipping.Shipping;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

@Component
public class Cart extends AbstractPage {
    private final String checkoutBtnXpath = "/html/body/div[2]/main/div[2]/div/div[3]/div[1]/ul/li[1]/button";

    @FindBy(how = How.XPATH, using = checkoutBtnXpath)
    private WebElement checkoutBtn;

    public Cart(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    public AbstractPage proceedToCheckout() throws InterruptedException {
        Thread.sleep(10000);
        new Actions(driver)
                .moveToElement(checkoutBtn)
                .click()
                .build()
                .perform();
        return new AbstractPage(driver);
    }

    public Shipping checkoutRegisteredUser() throws InterruptedException {
        Thread.sleep(10000);
        new Actions(driver)
                .moveToElement(checkoutBtn)
                .click()
                .build()
                .perform();
        return new Shipping(driver);
    }
}
