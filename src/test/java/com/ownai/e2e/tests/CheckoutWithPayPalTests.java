package com.ownai.e2e.tests;

import com.ownai.e2e.model.Login;
import com.ownai.e2e.pages.LandingPage;
import com.ownai.e2e.pages.PaymentCompletePage;
import com.ownai.e2e.pages.cart.Cart;
import com.ownai.e2e.pages.checkout.Checkout;
import com.ownai.e2e.pages.pay.PayWithPayPal;
import com.ownai.e2e.pages.pay.PayWithZipit;
import com.ownai.e2e.pages.puchase.Category;
import com.ownai.e2e.pages.puchase.Product;
import com.ownai.e2e.pages.user.LoginPage;
import com.ownai.e2e.service.LoginService;
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
public class CheckoutWithPayPalTests {

    @Autowired
    private LandingPage landingPage;

    @Autowired
    private Product product;

    @Autowired
    private Category category;

    @Autowired
    private Cart cart;

    @Autowired
    private Checkout checkout;

    @Autowired
    private PaymentCompletePage paymentCompletePage;

    @Autowired
    private PayWithPayPal payment;

    @Autowired
    private LoginService loginService;

    @Autowired
    LoginPage loginPage;
    @DisplayName("Test if a user can checkout with a paypal account as a guest")
    @Test
    public void checkout_with_paypal_guest() throws InterruptedException {
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

    };

    @DisplayName("Test if a user can checkout with a paypal account as a guest")
    @Test
    public void checkout_with_paypal_registerd() throws InterruptedException {

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


    };
}
