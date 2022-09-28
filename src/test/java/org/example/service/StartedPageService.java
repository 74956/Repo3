package org.example.service;

import org.example.pages.StartedPage;

import java.util.List;
import java.util.logging.Logger;

public class StartedPageService extends BasePageService {

    public static final Logger log = Logger.getLogger(StartedPageService.class.getName());
    private StartedPage startedPage = new StartedPage();

    public LoginPageService clickOnSignInMenu() {
        log.info("Click on 'Sign in' menu button");
        startedPage.clickOnSignInMenu();
        return new LoginPageService();
    }

    public String getAccountGreetingText() {
        log.info("Get text with user name");
        return startedPage.getAccountGreetingText();
    }

    public ResultPageService fillSearchField(String text) {
        log.info("Fill search filed with text " + text);
        startedPage.fillSearchField(text);
        return new ResultPageService();
    }

    public StartedPageService goToMainPage() {
        startedPage.goToMainPage();
        return this;
    }

    public ShoppingCartPageService clickOnCartButton() {
        log.info("Click on Cart button");
        startedPage.clickOnCartButton();
        return new ShoppingCartPageService();
    }

    public List<String> getListOfFooterOptionsByName(String columnName) {
        List<String> options = startedPage.getListOfFooterOptionsByName(columnName);
        log.info("Get option names - " + options);
        return options;
    }

    public void clickOnAboutAmazonButton() {
        log.info("Click on 'About Amazon' button");
        startedPage.clickOnAboutAmazonButton();
    }
}
