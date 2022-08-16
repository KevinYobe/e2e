package com.ownai.e2e.pages.checkout;

import com.ownai.e2e.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.springframework.stereotype.Component;

@Component
public class Checkout extends AbstractPage {
    private String email = "kev.yobe@gmail.com";
    private String firstName = "Kevin";
    private String lastName = "Yobe";
    private String company = "Ecocash Holdings";
    private String address = "2 Ledbury Close Mt Pleasant";
    private String city = "Harare";
    private String zipCode = "263";
    private String country = "Zimbabwe";
    private String phoneNumber = "+263774116711";

    final private String emailXpath = "/html/body/div[2]/main/div/div/div[3]/div[4]/ol/li[1]/div[2]/form[1]/fieldset/div/div/input";
    final private String firstNameXpath = "/html/body/div[2]/main/div/div/div[3]/div[4]/ol/li[1]/div[2]/form[2]/div/div[1]/div/input";
    final private String lastNameXpath = "/html/body/div[2]/main/div/div/div[3]/div[4]/ol/li[1]/div[2]/form[2]/div/div[2]/div/input";
    final private String companyXpath = "/html/body/div[2]/main/div/div/div[3]/div[4]/ol/li[1]/div[2]/form[2]/div/div[3]/div/input";
    final private String addressXpath = "/html/body/div[2]/main/div/div/div[3]/div[4]/ol/li[1]/div[2]/form[2]/div/fieldset/div/div[1]/div/input";
    final private String cityXpath = "/html/body/div[2]/main/div/div/div[3]/div[4]/ol/li[1]/div[2]/form[2]/div/div[4]/div/input";
    final private String zipCodeXpath = "/html/body/div[2]/main/div/div/div[3]/div[4]/ol/li[1]/div[2]/form[2]/div/div[7]/div/input";
    final private String countryXpath = "/html/body/div[2]/main/div/div/div[3]/div[4]/ol/li[1]/div[2]/form[2]/div/div[8]/div/select";
    final private String phoneNumberXpath = "/html/body/div[2]/main/div/div/div[3]/div[4]/ol/li[1]/div[2]/form[2]/div/div[9]/div/input";

    final private String selectShippingXpath = "/html/body/div[2]/main/div/div/div[3]/div[4]/ol/li[3]/div/div[3]/form/div[1]/table/tbody/tr[1]/td[1]/input";

    final private String submitBtnXpath = "/html/body/div[2]/main/div/div/div[3]/div[4]/ol/li[3]/div/div[3]/form/div[3]/div/button";

    @FindBy(how = How.XPATH, using = emailXpath)
    private WebElement emailTxtField;

    @FindBy(how = How.XPATH, using = firstNameXpath)
    private WebElement firstNameTxtField;

    @FindBy(how = How.XPATH, using = lastNameXpath)
    private WebElement lastNameTxtField;

    @FindBy(how = How.XPATH, using = companyXpath)
    private WebElement companyTxtField;

    @FindBy(how = How.XPATH, using = addressXpath)
    private WebElement addressTxtField;

    @FindBy(how = How.XPATH, using = cityXpath)
    private WebElement cityTxtField;

    @FindBy(how = How.XPATH, using = zipCodeXpath)
    private WebElement zipCodeTxtField;

    @FindBy(how = How.XPATH, using = countryXpath)
    private WebElement countryTxtField;

    @FindBy(how = How.XPATH, using = phoneNumberXpath)
    private WebElement phoneNumberTxtField;

    @FindBy(how = How.XPATH, using = selectShippingXpath)
    private WebElement selectShippingRadioBtn;

    @FindBy(how = How.XPATH, using = submitBtnXpath)
    private WebElement submitBtn;

    public Checkout(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public Checkout enterEmail() throws InterruptedException {
        Thread.sleep(2000);
        emailTxtField.sendKeys(email);
        return this;
    }

    public Checkout enterFirstName() throws InterruptedException {
        Thread.sleep(1000);
        firstNameTxtField.sendKeys(firstName);
        return this;
    }

    public Checkout enterLastName() throws InterruptedException {
        Thread.sleep(1000);
        lastNameTxtField.sendKeys(lastName);
        return this;
    }

    public Checkout enterCompany() throws InterruptedException {
        Thread.sleep(1000);
        companyTxtField.sendKeys(company);
        return this;
    }

    public Checkout enterAddress() throws InterruptedException {
        Thread.sleep(1000);
        addressTxtField.sendKeys(address);
        return this;
    }

    public Checkout enterCity() throws InterruptedException {
        Thread.sleep(1000);
        cityTxtField.sendKeys(city);
        return this;
    }

    public Checkout enterZipcode() throws InterruptedException {
        Thread.sleep(1000);
        zipCodeTxtField.sendKeys(zipCode);
        return this;
    }

    public Checkout selectCounty() throws InterruptedException {
        Thread.sleep(1000);
        Select select = new Select(countryTxtField);
        select.selectByVisibleText("Zimbabwe");
        return this;
    }

    public Checkout enterPhoneNumber() throws InterruptedException {
        Thread.sleep(1000);
        phoneNumberTxtField.sendKeys(phoneNumber);
        return this;
    }

    public Checkout selectShippingMethod(){
        new Actions(driver)
                .moveToElement(selectShippingRadioBtn)
                .click()
                .build()
                .perform();
        return this;
    }

    public AbstractPage submitForm(){
        new Actions(driver)
                .moveToElement(submitBtn)
                .click()
                .build()
                .perform();
        return new AbstractPage(driver);
    }
}
