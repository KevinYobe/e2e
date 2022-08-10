package com.ownai.e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class Shipping {

    private WebDriver driver;

    private String firstName = "Kevin";
    private String lastName = "Yobe";
    private String company = "Ecocash Holdings";
    private String address = "2 Ledbury Close Mt Pleasant";
    private String city = "Harare";
    private String zipCode = "263";
    private String country = "Zimbabwe";
    private String phoneNumber = "+263774116711";

    final private String firstNameXpath = "/html/body/div[2]/main/div/div/div[3]/div[4]/ol/li[1]/div[2]/form[2]/div/div[1]/div/input";
    final private String lastNameXpath = "/html/body/div[2]/main/div/div/div[3]/div[4]/ol/li[1]/div[2]/form[2]/div/div[2]/div/input";
    final private String companyXpath = "/html/body/div[2]/main/div/div/div[3]/div[4]/ol/li[1]/div[2]/form/div/fieldset/div/div[1]/div/input";
    final private String addressXpath = "/html/body/div[2]/main/div/div/div[3]/div[4]/ol/li[1]/div[2]/form/div/fieldset/div/div[1]/div/input";
    final private String cityXpath = "/html/body/div[2]/main/div/div/div[3]/div[4]/ol/li[1]/div[2]/form/div/div[4]/div/input";
    final private String zipCodeXpath = "/html/body/div[2]/main/div/div/div[3]/div[4]/ol/li[1]/div[2]/form[2]/div/div[7]/div/input";
    final private String countryXpath = "/html/body/div[2]/main/div/div/div[3]/div[4]/ol/li[1]/div[2]/form/div/div[8]/div/select";
    final private String phoneNumberXpath = "/html/body/div[2]/main/div/div/div[3]/div[4]/ol/li[1]/div[2]/form/div/div[9]/div/input";

    final private String selectShippingXpath = "/html/body/div[2]/main/div/div/div[3]/div[4]/ol/li[3]/div/div[3]/form/div[1]/table/tbody/tr[1]/td[1]/input";

    final private String submitBtnXpath = "/html/body/div[2]/main/div/div/div[3]/div[4]/ol/li[3]/div/div[3]/form/div[3]/div/button";


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

    public Shipping setDriver(WebDriver driver) {
        this.driver = driver;
        return this;
    }


    public Shipping enterFirstName() throws InterruptedException {
        Thread.sleep(1000);
        firstNameTxtField.sendKeys(firstName);
        return this;
    }

    public Shipping enterLastName() throws InterruptedException {
        Thread.sleep(1000);
        lastNameTxtField.sendKeys(lastName);
        return this;
    }

    public Shipping enterCompany() throws InterruptedException {
        Thread.sleep(1000);
        companyTxtField.sendKeys(company);
        return this;
    }

    public Shipping enterAddress() throws InterruptedException {
        Thread.sleep(1000);
        addressTxtField.sendKeys(address);
        return this;
    }

    public Shipping enterCity() throws InterruptedException {
        Thread.sleep(1000);
        cityTxtField.sendKeys(city);
        return this;
    }

    public Shipping enterZipcode() throws InterruptedException {
        Thread.sleep(1000);
        zipCodeTxtField.sendKeys(zipCode);
        return this;
    }

    public Shipping selectCounty() throws InterruptedException {
        Thread.sleep(1000);
        Select select = new Select(countryTxtField);
        select.selectByVisibleText("Zimbabwe");
        return this;
    }

    public Shipping enterPhoneNumber() throws InterruptedException {
        Thread.sleep(1000);
        phoneNumberTxtField.sendKeys(phoneNumber);
        return this;
    }

    public Shipping selectShippingMethod(){
        new Actions(driver)
                .moveToElement(selectShippingRadioBtn)
                .click()
                .build()
                .perform();
        return this;
    }

    public PayWithZipit submitForm(){
        new Actions(driver)
                .moveToElement(submitBtn)
                .click()
                .build()
                .perform();
        return new PayWithZipit();
    }
}
