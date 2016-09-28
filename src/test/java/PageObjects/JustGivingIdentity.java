package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.MockDataGenerator;

public class JustGivingIdentity extends JustGivingPage<JustGivingIdentity> {

    public JustGivingIdentity(WebDriver driver) {
        super(driver);
    }

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
        return "";
    }


    public void enterEmailAddress() {
        emailAddress.sendKeys(MockDataGenerator.emailGenerator());
    }

    public JustGivingAuthentication clickContinue() {
        waitForElementToBeVisible(continueButton);
        continueButton.click();
        JustGivingAuthentication justGivingAuthentication = new JustGivingAuthentication(getDriver()).initPage(JustGivingAuthentication.class);
        justGivingAuthentication.waitForPageToLoad(justGivingAuthentication.getPageLoadCondition());
        return justGivingAuthentication;
    }
}
