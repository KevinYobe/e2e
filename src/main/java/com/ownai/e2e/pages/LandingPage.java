package com.ownai.e2e.pages;

import com.ownai.e2e.pages.puchase.Category;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

@Component
public class LandingPage extends AbstractPage {

    final private String categoryXpath = "/html/body/div[1]/main/div[2]/div/div[2]/div/div[2]/div/div[1]/div/div[1]/a/img";

    @FindBy(how = How.XPATH, using = categoryXpath)
    private WebElement categoryImg;

    public LandingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void selectCategoryGroceries(){
        new Actions(driver)
                .moveToElement(categoryImg)
                .click()
                .build()
                .perform();
    }

}
