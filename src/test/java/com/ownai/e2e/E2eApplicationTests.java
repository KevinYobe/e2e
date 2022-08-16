package com.ownai.e2e;

import com.ownai.e2e.model.Login;
import com.ownai.e2e.model.RegisteredUser;
import com.ownai.e2e.pages.*;
import com.ownai.e2e.pages.cart.Cart;
import com.ownai.e2e.pages.checkout.Checkout;
import com.ownai.e2e.pages.pay.PayOnDelivery;
import com.ownai.e2e.pages.pay.PayWithCassavaPay;
import com.ownai.e2e.pages.pay.PayWithZipit;
import com.ownai.e2e.pages.puchase.Category;
import com.ownai.e2e.pages.puchase.Product;
import com.ownai.e2e.pages.shipping.Shipping;
import com.ownai.e2e.pages.user.CreateAccount;
import com.ownai.e2e.pages.user.LoginPage;
import com.ownai.e2e.service.LoginService;
import com.ownai.e2e.service.RegisteredUserService;
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
	RegisteredUserService registeredUserService;

	@Autowired
	private Product product;

	private Checkout checkout;

	private CreateAccount createAccount;

	private Shipping shipping;

	@Autowired
	private Cart cart;

	private PayWithZipit payment;

	private PayWithCassavaPay payWithCassavaPay;

	private PayOnDelivery payOnDelivery;

	@Autowired
	private Category category;

	@Autowired
	private PaymentCompletePage paymentCompletePage;

	@Test
	void contextLoads() {

	}

	@DisplayName("Test is a user can checkout with payment on delivery as guest")
	@Test
	public void can_user_checkout_with_on_delivery_as_guest() throws InterruptedException {
		category = (Category) landingPage.selectCategoryGroceries();
		product = (Product) category.selectProduct();
		cart = (Cart) product.addToCart().confirmAlert();
		checkout = (Checkout) cart.proceedToCheckout();
		payOnDelivery = (PayOnDelivery) checkout
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

		paymentCompletePage = (PaymentCompletePage) payOnDelivery
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

		category = landingPage.selectCategoryGroceries();
		product = category.selectProduct();
		cart = product.addToCart().confirmAlert();
		shipping = cart.checkoutRegisteredUser();
		payOnDelivery = shipping
				.enterCompany()
				.enterAddress()
				.enterCity()
				.selectCounty()
				.enterPhoneNumber()
				.selectShippingMethod()
				.submitForm();

		paymentCompletePage = payOnDelivery
				.selectRadioBtn()
				.confirmTermsAndConditions()
				.submit();

		String completePayment = paymentCompletePage.getSuccessMessage();
		assertNotNull(completePayment);
	}

	@Test
	public void can_user_create_account() throws InterruptedException {
		createAccount = new CreateAccount();
		RegisteredUser user = registeredUserService.findOne();
		System.out.println(user.getPassword());
		PageFactory.initElements(driver, createAccount);
		LoginPage login = (LoginPage) createAccount.setDriver(driver)
				.moveToCreateAccount()
				.setName(user.getFirstName())
				.setEmail(user.getEmail())
				.setLastName(user.getLastName())
				.setPassword(user.getPassword())
				.confirmPassword(user.getPassword())
				.submit();
	}


	@Test
	public void can_user_login(){

	}


	@Disabled
	@DisplayName("Test if a user can checkout with zipit as guest")
	@Test
	public void can_user_checkout_with_zipit_as_guest() throws InterruptedException {

		category = (Category) landingPage.selectCategoryGroceries();
		product = (Product) category.selectProduct();
		cart = (Cart) product.addToCart().confirmAlert();

		checkout = (Checkout) cart.proceedToCheckout();
		PageFactory.initElements(driver,checkout);
		payment = (PayWithZipit) checkout
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
		paymentCompletePage = (PaymentCompletePage) payment.selectRadioBtn().confirmTermsAndConditions().submit();
		PageFactory.initElements(driver, paymentCompletePage);
		String completePayment = paymentCompletePage.getSuccessMessage();
		assertNotNull(completePayment);
	}

	@DisplayName("Test if a user can checkout with a paypal account as a guest")
	@Test
	public void can_user_checkout_with_paypal_as_guest() throws InterruptedException {
		PageFactory.initElements(driver,landingPage);
		category = (Category) landingPage.selectCategoryGroceries();
		PageFactory.initElements(driver, category);
		product = (Product) category.selectProduct();
		PageFactory.initElements(driver,product);
		cart = (Cart) product.addToCart().confirmAlert();
		PageFactory.initElements(driver,cart);
		checkout = (Checkout) cart.proceedToCheckout();
		PageFactory.initElements(driver,checkout);
		payment = (PayWithZipit) checkout
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
		paymentCompletePage = (PaymentCompletePage) payment.selectRadioBtn().confirmTermsAndConditions().submit();
		PageFactory.initElements(driver, paymentCompletePage);
		String completePayment = paymentCompletePage.getSuccessMessage();
		assertNotNull(completePayment);

	};



}
