package com.ownai.e2e.pages.user;

import com.ownai.e2e.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

@Component
public class LoginPage extends AbstractPage{

    final private String usernameXpath = "/html/body/div[1]/main/div[2]/div/div[3]/div[1]/div[2]/form/fieldset/div[2]/div/input";

    final private String passwordXpath = "/html/body/div[1]/main/div[2]/div/div[3]/div[1]/div[2]/form/fieldset/div[3]/div/input";

    final private String buttonXpath = "/html/body/div[1]/main/div[2]/div/div[3]/div[1]/div[2]/form/fieldset/div[4]/div[1]/button";

    final private String loginXpath = "/html/body/div[1]/header/div[1]/div[2]/div/div/div[2]/div/div[4]/div[2]/ul/li[1]/a";

    @FindBy(how = How.XPATH, xpath = loginXpath)
    private WebElement loginLink;

    @FindBy(how = How.XPATH, xpath = usernameXpath)
    private WebElement usernameTextField;

    @FindBy(how = How.XPATH, xpath = passwordXpath)
    private WebElement passwordTextField;

    @FindBy(how = How.XPATH, xpath = buttonXpath)
    private WebElement button;

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public LoginPage moveToLogin() throws InterruptedException {
        Thread.sleep(1000);
        new Actions(driver)
                .moveToElement(loginLink)
                .click()
                .build()
                .perform();
        return this;
    }
    public LoginPage setUsername(String username) throws InterruptedException {
        Thread.sleep(1000);
        usernameTextField.sendKeys(username);
        return this;
    }

    public LoginPage setPassword(String password) throws InterruptedException {
        Thread.sleep(1000);
        passwordTextField.sendKeys(password);
        return this;
    }

    public AbstractPage submit() throws InterruptedException {
        Thread.sleep(5000);
       new Actions(driver)
               .moveToElement(button)
               .click()
               .build()
               .perform();
       return new AbstractPage(driver);
    }

}
