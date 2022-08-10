package com.ownai.e2e.util;

import com.ownai.e2e.model.Login;
import com.ownai.e2e.model.RegisteredUser;
import com.ownai.e2e.pages.LandingPage;
import com.ownai.e2e.pages.user.CreateAccount;
import com.ownai.e2e.pages.user.LoginPage;
import com.ownai.e2e.service.LoginService;
import com.ownai.e2e.service.RegisteredUserService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

@SpringBootTest
public class Util {

    @Autowired
    private static WebDriver driver;

    @Autowired
    private LandingPage landingPage;

    @Autowired
    private static RegisteredUserService registeredUserService;
    @Autowired
    private static CreateAccount createAccount;
    @Autowired
    private static LoginPage loginPage;
    @Autowired
    private static LoginService loginService;

    public void createUser() throws InterruptedException {
        RegisteredUser user = registeredUserService.findOne();
        System.out.println(user.getPassword());
        PageFactory.initElements(driver, createAccount);
        LoginPage login = createAccount.setDriver(driver)
                .moveToCreateAccount()
                .setName(user.getFirstName())
                .setEmail(user.getEmail())
                .setLastName(user.getLastName())
                .setPassword(user.getPassword())
                .confirmPassword(user.getPassword())
                .submit();
    }

    public void login() throws InterruptedException {
        Login login = loginService.findByOne();
        PageFactory.initElements(driver, loginPage);
        loginPage.setDriver(driver)
                .moveToLogin()
                .setPassword(login.getPassword())
                .setUsername(login.getUsername())
                .submit();
    }

}
