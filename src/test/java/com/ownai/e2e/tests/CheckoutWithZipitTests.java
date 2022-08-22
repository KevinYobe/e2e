package com.ownai.e2e.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.ownai.e2e.model.Login;
import com.ownai.e2e.pages.LandingPage;
import com.ownai.e2e.pages.PaymentCompletePage;
import com.ownai.e2e.pages.cart.Cart;
import com.ownai.e2e.pages.checkout.Checkout;
import com.ownai.e2e.pages.pay.PayWithZipit;
import com.ownai.e2e.pages.puchase.Category;
import com.ownai.e2e.pages.puchase.Product;
import com.ownai.e2e.pages.user.LoginPage;
import com.ownai.e2e.service.LoginService;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class CheckoutWithZipitTests {

    @Autowired
    ExtentReports extentReports;
    @Autowired
    private Category category;

    @Autowired
    private  Product product;

    @Autowired
    private LandingPage landingPage;

    @Autowired
    private Cart cart;

    @Autowired
    private Checkout checkout;

    @Autowired
    private PayWithZipit payment;

    @Autowired
    private PaymentCompletePage paymentCompletePage;

    @Autowired
    private LoginService loginService;

    @Autowired
    private LoginPage loginPage;
    @DisplayName("Test if a user can checkout with zipit as guest")
    @Test
    public void can_user_checkout_with_zipit_as_guest() throws InterruptedException {
        ExtentTest test = extentReports.createTest("Test Case - Checkout with on zipit as guest");

        landingPage.selectCategoryGroceries();
        category.selectProduct();
        product.addToCart().confirmAlert();

        cart.proceedToCheckout();
        checkout
                .enterEmail()
                .enterFirstName()
                .enterLastName()
                .enterCompany()
                .enterAddress()
                .enterCity()
                .selectCounty()
                .enterPhoneNumber()
                .selectShippingMethod()
                .submitForm();

        payment.selectRadioBtn().confirmTermsAndConditions().submit();
        String completePayment = paymentCompletePage.getSuccessMessage();
        if(completePayment.contains("Thank you")){
            test.log(Status.PASS, "Test case has passed");
            extentReports.flush();
        }
        else {
            test.log(Status.FAIL, "Test case failed");
            extentReports.flush();
        }

    }

    @DisplayName("Test if a user can checkout with zipit as guest")
    @Test
    public void can_user_checkout_with_zipit_as_reg_customer() throws InterruptedException {
        ExtentTest test = extentReports.createTest("Test Case - Checkout with on zipit as registered customer");
        Login login = loginService.findByOne();
        loginPage.moveToLogin()
                .setUsername(login.getUsername())
                .setPassword(login.getPassword())
                .submit();


        landingPage.selectCategoryGroceries();
        category.selectProduct();
        product.addToCart().confirmAlert();
        cart.proceedToCheckout();
      checkout
                .enterEmail()
                .enterFirstName()
                .enterLastName()
                .enterCompany()
                .enterAddress()
                .enterCity()
                .selectCounty()
                .enterPhoneNumber()
                .selectShippingMethod()
                .submitForm();
        payment.selectRadioBtn().confirmTermsAndConditions().submit();

        String completePayment = paymentCompletePage.getSuccessMessage();
        if(completePayment.contains("Thank you")){
            test.log(Status.PASS, "Test case has passed");
            extentReports.flush();
        }
        else {
            test.log(Status.FAIL, "Test case failed");
            extentReports.flush();
        }
    }
}
