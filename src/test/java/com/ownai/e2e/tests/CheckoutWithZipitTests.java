package com.ownai.e2e.tests;

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
        assertNotNull(completePayment);
    }

    @DisplayName("Test if a user can checkout with zipit as guest")
    @Test
    public void can_user_checkout_with_zipit_as_reg_customer() throws InterruptedException {
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
        assertNotNull(completePayment);
    }
}
