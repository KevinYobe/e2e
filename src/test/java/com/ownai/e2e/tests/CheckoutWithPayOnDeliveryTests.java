package com.ownai.e2e.tests;

import com.ownai.e2e.model.Login;
import com.ownai.e2e.pages.LandingPage;
import com.ownai.e2e.pages.PaymentCompletePage;
import com.ownai.e2e.pages.cart.Cart;
import com.ownai.e2e.pages.checkout.Checkout;
import com.ownai.e2e.pages.pay.PayOnDelivery;
import com.ownai.e2e.pages.puchase.Category;
import com.ownai.e2e.pages.puchase.Product;
import com.ownai.e2e.pages.shipping.Shipping;
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
public class CheckoutWithPayOnDeliveryTests {
    @Autowired
    private PaymentCompletePage paymentCompletePage;

    @Autowired
    private Cart cart;

    @Autowired
    private Category category;

    @Autowired
    private LoginService loginService;

    @Autowired
    private Product product;

    @Autowired
    private Checkout checkout;

    @Autowired
    private LandingPage landingPage;

    @Autowired
    private PayOnDelivery payOnDelivery;

    @Autowired
    private LoginPage loginPage;

    @Autowired
    Shipping shipping;

    @Test
    void contextLoads() {

    }

    @DisplayName("Test is a user can checkout with payment on delivery as guest")
    @Test
    public void can_user_checkout_with_on_delivery_as_guest() throws InterruptedException {
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

        payOnDelivery
                .selectRadioBtn()
                .confirmTermsAndConditions()
                .submit();
        String completePayment = paymentCompletePage.getSuccessMessage();
        System.out.println(completePayment);
        assertNotNull(completePayment);

    }

    @Test
    public void can_user_checkout_with_paymentondelivery_registered() throws InterruptedException {

        Login login = loginService.findByOne();
        loginPage.moveToLogin()
                .setUsername(login.getUsername())
                .setPassword(login.getPassword())
                .submit();

        landingPage.selectCategoryGroceries();
        category.selectProduct();
        product.addToCart().confirmAlert();
        cart.checkoutRegisteredUser();
        shipping
                .enterCompany()
                .enterAddress()
                .enterCity()
                .selectCounty()
                .enterPhoneNumber()
                .selectShippingMethod()
                .submitForm();

        payOnDelivery
                .selectRadioBtn()
                .confirmTermsAndConditions()
                .submit();

        String completePayment = paymentCompletePage.getSuccessMessage();
        assertNotNull(completePayment);
    }
}
