package com.ownai.e2e.pages.user;

import com.ownai.e2e.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.stereotype.Component;

@Component
public class CreateAccount extends AbstractPage {

    final private String successAlertXpath = "/html/body/div[1]/main/div[1]/div[2]/div/div/div";
    final private String createAccountXpath = "/html/body/div[1]/header/div[1]/div[2]/div/div/div[2]/div/div[4]/div[2]/ul/li[2]/a";
    final private String firstNameXpath = "/html/body/div[1]/main/div[2]/div/form/fieldset[1]/div[1]/div/input";

    final private String lastNameXpath  = "/html/body/div[1]/main/div[2]/div/form/fieldset[1]/div[2]/div/input";

    final private String emailXpath = "/html/body/div[1]/main/div[2]/div/form/fieldset[2]/div[1]/div/input";

    final private String passwordXpath = "/html/body/div[1]/main/div[2]/div/form/fieldset[2]/div[2]/div/input";

    final private String confirmPasswordXpath = "/html/body/div[1]/main/div[2]/div/form/fieldset[2]/div[3]/div/input";

    final private String buttonXpath = "/html/body/div[1]/main/div[2]/div/form/div/div[1]/button";

    @FindBy(how = How.XPATH, using = successAlertXpath)
    private WebElement successAlert;
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

    public CreateAccount(WebDriver driver) {
        super(driver);
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

    public void submit() throws InterruptedException {
        Thread.sleep(2000);
        new Actions(driver)
                .moveToElement(submitButton)
                .click()
                .build()
                .perform();
    }

    public String getSuccessAlertText() throws InterruptedException {
        Thread.sleep(2000);
        return successAlert.getText();
    }
}
