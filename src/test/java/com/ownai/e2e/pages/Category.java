package com.ownai.e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;


public class Category {
    final private String productXpath = "/html/body/div[1]/main/div[3]/div[1]/div[4]/ol/li[2]/div/div[2]/div[2]/div/div[1]/form/button";

    @FindBy(how = How.XPATH, using = productXpath)
    private WebElement productElement;

    public Product selectProduct(WebDriver driver) throws InterruptedException {
        //Thread.sleep(3000);
        new Actions(driver)
                .moveToElement(productElement)
                .click()
                .build()
                .perform();
       return new Product();
    }

}
