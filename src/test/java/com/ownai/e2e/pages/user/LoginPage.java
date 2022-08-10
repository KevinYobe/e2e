package com.ownai.e2e.pages.user;

import com.ownai.e2e.pages.LandingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.stereotype.Component;

@Component
public class LoginPage {

    final private String usernameXpath = "/html/body/div[1]/main/div[2]/div/div[3]/div[1]/div[2]/form/fieldset/div[2]/div/input";

    final private String passwordXpath = "/html/body/div[1]/main/div[2]/div/div[3]/div[1]/div[2]/form/fieldset/div[3]/div/input";

    final private String buttonXpath = "/html/body/div[1]/main/div[2]/div/div[3]/div[1]/div[2]/form/fieldset/div[4]/div[1]/button";

    final private String loginXpath = "/html/body/div[1]/header/div[1]/div[2]/div/div/div[2]/div/div[4]/div[2]/ul/li[1]/a";

    private WebDriver driver;

    @FindBy(how = How.XPATH, xpath = loginXpath)
    private WebElement loginLink;

    @FindBy(how = How.XPATH, xpath = usernameXpath)
    private WebElement usernameTextField;

    @FindBy(how = How.XPATH, xpath = passwordXpath)
    private WebElement passwordTextField;

    @FindBy(how = How.XPATH, xpath = buttonXpath)
    private WebElement button;

    public LoginPage setDriver(WebDriver driver){
        this.driver = driver;
        return this;
    }

    public LoginPage moveToLogin() throws InterruptedException {
        Thread.sleep(5000);
        new Actions(driver)
                .moveToElement(loginLink)
                .click()
                .build()
                .perform();
        return this;
    }
    public LoginPage setUsername(String username) throws InterruptedException {
        Thread.sleep(5000);
        usernameTextField.sendKeys(username);
        return this;
    }

    public LoginPage setPassword(String password) throws InterruptedException {
        Thread.sleep(5000);
        passwordTextField.sendKeys(password);
        return this;
    }

    public LandingPage submit() throws InterruptedException {
        Thread.sleep(5000);
       new Actions(driver)
               .moveToElement(button)
               .click()
               .build()
               .perform();
       return new LandingPage();
    }

}
