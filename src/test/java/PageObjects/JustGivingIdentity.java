package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.MockDataGenerator;

public class JustGivingIdentity extends JustGivingPage<JustGivingIdentity> {

    @FindBy(id = "Identity-fieldset")
    WebElement fieldSet;

    @FindBy(xpath = "//span[@id='email-content']//a[contains(@class,'awesome-continue-button ')]")
    WebElement continueButton;

    @FindBy(xpath = "//input[@id='Identity_EmailAddress']")
    WebElement emailAddress;

    @Override
    protected ExpectedCondition getPageLoadCondition() {
        return ExpectedConditions.visibilityOf(fieldSet);
    }

    @Override
    public String getPageUrl() {
//        return "4w350m3/donation/direct/charity/2050#Identity";
        return "";
    }

    //make invisible for the test
    @Override
    public void clickButton(WebElement button) {
        button.click();
    }

    public void enterEmailAddress() {
        emailAddress.sendKeys(MockDataGenerator.emailGenerator());
    }

    public JustGivingAuthentication clickContinue() {
        clickButton(continueButton);
        JustGivingAuthentication justGivingAuthentication = new JustGivingAuthentication().initPage(JustGivingAuthentication.class);
        justGivingAuthentication.waitForPageToLoad(justGivingAuthentication.getPageLoadCondition());
        return justGivingAuthentication;
    }
}
