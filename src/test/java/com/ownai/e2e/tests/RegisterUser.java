package com.ownai.e2e.tests;

import com.ownai.e2e.model.Login;
import com.ownai.e2e.model.RegisteredUser;
import com.ownai.e2e.pages.user.CreateAccount;
import com.ownai.e2e.pages.user.LoginPage;
import com.ownai.e2e.service.LoginService;
import com.ownai.e2e.service.RegisteredUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class RegisterUser {

    @Autowired
    private CreateAccount createAccount;

    @Autowired
    LoginPage loginPage;
    @Autowired
    RegisteredUserService registeredUserService;

    @Autowired
    LoginService loginService;

    @Test
    public void registerUser() throws InterruptedException {
        RegisteredUser user = registeredUserService.findOne();
        createAccount
                .moveToCreateAccount()
                .setName(user.getFirstName())
                .setEmail(user.getEmail())
                .setLastName(user.getLastName())
                .setPassword(user.getPassword())
                .confirmPassword(user.getPassword())
                .submit();
    }

    @Test
    public void login() throws InterruptedException {
        Login login = loginService.findByOne();
        loginPage.moveToLogin()
                .setUsername(login.getUsername())
                .setPassword(login.getPassword())
                .submit();
    }

}
