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


	@Test
	public void can_user_login(){

	}








}
