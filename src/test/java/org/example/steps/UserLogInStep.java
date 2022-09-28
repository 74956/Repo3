package org.example.steps;

import io.cucumber.java.en.Given;
import org.example.object.User;
import org.example.service.LoginPageService;
import org.example.service.StartedPageService;
import org.example.service.UserService;

public class UserLogInStep {

    private LoginPageService loginPageService = new LoginPageService();
    private UserService userService = new UserService();
    private StartedPageService startedPageService = new StartedPageService();

    @Given("I log in")
    public void logIn() {
        User user = userService.credentials();
        loginPageService = startedPageService.clickOnSignInMenu();
        loginPageService.logIn(user);
    }
}
