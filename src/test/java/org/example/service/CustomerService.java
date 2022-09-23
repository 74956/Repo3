package org.example.service;

import org.example.pages.CustomerServicePage;

import java.util.List;

public class CustomerService extends BasePageService {

    private CustomerServicePage customerServicePage = new CustomerServicePage();

    public String getCustomServiceButtonText() {
        String buttonText = customerServicePage.getCustomServiceButtonText();
        log.info("Get 'Custom Service' button text - " + buttonText);
        return buttonText;
    }

    public String getHomeButtonText() {
        String buttonText = customerServicePage.getHomeButtonText();
        log.info("Get 'Home' button text - " + buttonText);
        return buttonText;
    }

    public String getGreetingMsgText() {
        String msgText = customerServicePage.getGreetingMsgText();
        log.info("Get greeting msg text - " + msgText);
        return msgText;
    }

    public String getInfoMsgText() {
        String msgText = customerServicePage.getInfoMsgText();
        log.info("Get info msg text - " + msgText);
        return msgText;
    }

    public boolean isCardImgsDisplayed() {
        boolean result = customerServicePage.isCardImgsDisplayed();
        log.info("Is card msg displayed - " + result);
        return result;
    }

    public List<String> getListOfCardText() {
        List<String> list = customerServicePage.getListOfCardText();
        log.info("Get list of card text - " + list);
        return list;
    }

    public boolean isSearchFieldDisplayed() {
        boolean result = customerServicePage.isSearchFieldDisplayed();
        log.info("Is search field displayed - " + result);
        return result;
    }

    public String getTextUnderSearchField() {
        String text = customerServicePage.textUnderSearchField();
        log.info("Get text under the search field - " + text);
        return text;
    }

    public boolean isLoupeImgInSearchDisplayed() {
        boolean result = customerServicePage.isLoupeImgDisplayed();
        log.info("Is loupe img displayed in search field - " + result);
        return result;
    }

    public List<String> getListOfHelpTopics() {
        List<String> list = customerServicePage.getListOfTopics();
        log.info("Get list of all help topics - " + list);
        return list;
    }

    public boolean isHelpTopicHasAdditionalCardWithInformation() {
        boolean result = false;
        int n = 0;
        int k = 0;
        for (int i = 0; i < getListOfHelpTopics().size(); i++) {
            customerServicePage.listOfHelpTopics().get(i).click();
            log.info("Click on element " + "'" + customerServicePage.listOfHelpTopics().get(i).getText() + "'");
            result = !customerServicePage.listOfCardHelpInformation().isEmpty();
            log.info("Set of cards has info cards - " + result + " " + ++k);
        }
        log.info("Is help topics have additional cards with information - " + result);
        return result;
    }
}
