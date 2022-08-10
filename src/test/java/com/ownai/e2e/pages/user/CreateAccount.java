package com.ownai.e2e.pages.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateAccount {
    @Autowired
    private WebDriver driver;

    final private String createAccountXpath = "/html/body/div[1]/header/div[1]/div[2]/div/div/div[2]/div/div[4]/div[2]/ul/li[2]/a";
    final private String firstNameXpath = "/html/body/div[1]/main/div[2]/div/form/fieldset[1]/div[1]/div/input";

    final private String lastNameXpath  = "/html/body/div[1]/main/div[2]/div/form/fieldset[1]/div[2]/div/input";

    final private String emailXpath = "/html/body/div[1]/main/div[2]/div/form/fieldset[2]/div[1]/div/input";

    final private String passwordXpath = "/html/body/div[1]/main/div[2]/div/form/fieldset[2]/div[2]/div/input";

    final private String confirmPasswordXpath = "/html/body/div[1]/main/div[2]/div/form/fieldset[2]/div[3]/div/input";

    final private String buttonXpath = "/html/body/div[1]/main/div[2]/div/form/div/div[1]/button";

    @FindBy(how = How.XPATH, xpath = firstNameXpath)
    private WebElement firstNameTextField;

    @FindBy(how = How.XPATH, xpath = lastNameXpath)
    private WebElement lastNameTextField;

    @FindBy(how = How.XPATH, xpath = emailXpath)
    private WebElement emailTextField;

    @FindBy(how = How.XPATH, xpath = passwordXpath)
    private WebElement passwordTextField;

    @FindBy(how = How.XPATH, xpath = confirmPasswordXpath)
    private WebElement confirmPasswordTextField;

    @FindBy(how = How.XPATH, xpath = buttonXpath)
    private WebElement submitButton;

    @FindBy(how = How.XPATH, xpath = createAccountXpath)
    private WebElement createAccountLink ;

    public CreateAccount setDriver(WebDriver driver){
        this.driver = driver;
        return this;
    }

    public CreateAccount moveToCreateAccount() throws InterruptedException {
        Thread.sleep(2000);
        new Actions(driver)
                .moveToElement(createAccountLink)
                .click()
                .build()
                .perform();
        return this;
    }

    public CreateAccount setName(String firstName) throws InterruptedException {
        Thread.sleep(2000);
        firstNameTextField.sendKeys(firstName);
        return this;
    }

    public CreateAccount setLastName(String lastName) throws InterruptedException {
        Thread.sleep(2000);
        lastNameTextField.sendKeys(lastName);
        return this;
    }

    public CreateAccount setEmail(String email) throws InterruptedException {
        Thread.sleep(2000);
       emailTextField.sendKeys(email);
        return this;
    }

    public CreateAccount setPassword(String password) throws InterruptedException {
        Thread.sleep(2000);
        passwordTextField.sendKeys(password);
        return this;
    }

    public CreateAccount confirmPassword(String confirmPassword) throws InterruptedException {
        Thread.sleep(2000);
        confirmPasswordTextField.sendKeys(confirmPassword);
        return this;
    }

    public LoginPage submit() throws InterruptedException {
        Thread.sleep(2000);
        new Actions(driver)
                .moveToElement(submitButton)
                .click()
                .build()
                .perform();
        return new LoginPage();
    }





}
