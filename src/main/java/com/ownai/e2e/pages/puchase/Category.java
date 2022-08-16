package com.ownai.e2e.pages.puchase;

import com.ownai.e2e.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;


@Component
public class Category extends AbstractPage {
    final private String productXpath = "/html/body/div[1]/main/div[3]/div[1]/div[4]/ol/li[2]/div/div[2]/div[2]/div/div[1]/form/button";

    @FindBy(how = How.XPATH, using = productXpath)
    private WebElement productElement;

    public Category(WebDriver driver) {
        super(driver);
    }

    public Product selectProduct() throws InterruptedException {
        //Thread.sleep(3000);
        new Actions(driver)
                .moveToElement(productElement)
                .click()
                .build()
                .perform();
       return new Product(driver);
    }

}
