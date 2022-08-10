package com.ownai.e2e;

import com.ownai.e2e.model.Login;
import com.ownai.e2e.pages.*;
import com.ownai.e2e.pages.user.LoginPage;
import com.ownai.e2e.service.LoginService;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@SpringBootTest
@RunWith(SpringRunner.class)
class E2eApplicationTests {

	@Autowired
	LoginService loginService;

	@Autowired
	private WebDriver driver;

	@Autowired
	private LoginPage loginPage;

	@Autowired
	private LandingPage landingPage;


	@Autowired
	private Product product;

	private Checkout checkout;

	private Shipping shipping;

	@Autowired
	private Cart cart;

	private PayWithZipit payment;

	private PayWithCassavaPay payWithCassavaPay;

	private PayOnDelivery payOnDelivery;

	private Category category = null;

	private PaymentCompletePage paymentCompletePage = null;

	@Disabled
	@Test
	void contextLoads() {

	}


	@Test
	public void can_user_create_account(){

	}


	@Test
	public void can_user_login(){

	}

	@DisplayName("Test is a user can checkout with payment on delivery as guest")
	@Test
	public void can_user_checkout_with_on_delivery_as_guest() throws InterruptedException {
		PageFactory.initElements(driver,landingPage);
		category = landingPage.setDriver(driver).selectCategoryGroceries();
		PageFactory.initElements(driver, category);
		product = category.selectProduct(driver);
		PageFactory.initElements(driver,product);
		cart = product.setDriver(driver).addToCart().confirmAlert();
		PageFactory.initElements(driver,cart);
		checkout = cart.setDriver(driver).proceedToCheckout();
		PageFactory.initElements(driver,checkout);
		payment = checkout.setDriver(driver)
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
		PageFactory.initElements(driver, payment);
		paymentCompletePage = payment
				.setDriver(driver)
				.selectRadioBtn()
				.confirmTermsAndConditions()
				.submit();
		PageFactory.initElements(driver, paymentCompletePage);
		String completePayment = paymentCompletePage.getSuccessMessage();
		assertNotNull(completePayment);

	}

	@Disabled
	@DisplayName("Test if a user can checkout with zipit as guest")
	@Test
	public void can_user_checkout_with_zipit_as_guest() throws InterruptedException {
		PageFactory.initElements(driver,landingPage);
		category = landingPage.setDriver(driver).selectCategoryGroceries();
		PageFactory.initElements(driver, category);
		product = category.selectProduct(driver);
		PageFactory.initElements(driver,product);
		cart = product.setDriver(driver).addToCart().confirmAlert();
		PageFactory.initElements(driver,cart);
		checkout = cart.setDriver(driver).proceedToCheckout();
		PageFactory.initElements(driver,checkout);
		payment = checkout.setDriver(driver)
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
		PageFactory.initElements(driver, payment);
		paymentCompletePage = payment.setDriver(driver).selectRadioBtn().confirmTermsAndConditions().submit();
		PageFactory.initElements(driver, paymentCompletePage);
		String completePayment = paymentCompletePage.getSuccessMessage();
		assertNotNull(completePayment);
	}

	@DisplayName("Test if a user can checkout with a paypal account as a guest")
	@Test
	public void can_user_checkout_with_paypal_as_guest() throws InterruptedException {
		PageFactory.initElements(driver,landingPage);
		category = landingPage.setDriver(driver).selectCategoryGroceries();
		PageFactory.initElements(driver, category);
		product = category.selectProduct(driver);
		PageFactory.initElements(driver,product);
		cart = product.setDriver(driver).addToCart().confirmAlert();
		PageFactory.initElements(driver,cart);
		checkout = cart.setDriver(driver).proceedToCheckout();
		PageFactory.initElements(driver,checkout);
		payment = checkout.setDriver(driver)
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
		PageFactory.initElements(driver, payment);
		paymentCompletePage = payment.setDriver(driver).selectRadioBtn().confirmTermsAndConditions().submit();
		PageFactory.initElements(driver, paymentCompletePage);
		String completePayment = paymentCompletePage.getSuccessMessage();
		assertNotNull(completePayment);

	};

	@Test
	public void can_user_checkout_with_paymentondelivery_registered() throws InterruptedException {
		Login login = loginService.findByOne();
		PageFactory.initElements(driver, loginPage);
		loginPage.setDriver(driver).moveToLogin()
				.setUsername(login.getUsername())
				.setPassword(login.getPassword())
				.submit();

		PageFactory.initElements(driver,landingPage);
		category = landingPage.setDriver(driver).selectCategoryGroceries();
		PageFactory.initElements(driver, category);
		product = category.selectProduct(driver);
		PageFactory.initElements(driver,product);
		cart = product.setDriver(driver).addToCart().confirmAlert();
		PageFactory.initElements(driver,cart);
		shipping = cart.setDriver(driver).checkoutRegisteredUser();
		PageFactory.initElements(driver,shipping);
		payment = shipping.setDriver(driver)
				.enterCompany()
				.enterAddress()
				.enterCity()
				.selectCounty()
				.enterPhoneNumber()
				.selectShippingMethod()
				.submitForm();
		PageFactory.initElements(driver, payment);
		paymentCompletePage = payment
				.setDriver(driver)
				.selectRadioBtn()
				.confirmTermsAndConditions()
				.submit();
		PageFactory.initElements(driver, paymentCompletePage);
		String completePayment = paymentCompletePage.getSuccessMessage();
		assertNotNull(completePayment);
	}

}
