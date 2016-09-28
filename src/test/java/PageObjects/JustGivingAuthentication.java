package PageObjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class JustGivingAuthentication extends JustGivingPage<JustGivingAuthentication> {

    public JustGivingAuthentication(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "Authentication-fieldset")
    WebElement fieldSet;

    @FindBy(xpath = "//div[contains(@class,'password-and-opt-in')]/following-sibling::*//a[contains(@class,'awesome-continue-button ')]")
    WebElement continueButton;

    @FindBy(id = "Authentication_Password")
    WebElement password;

    @Override
    protected ExpectedCondition getPageLoadCondition() {
        return ExpectedConditions.visibilityOf(fieldSet);
    }

    @Override
    public String getPageUrl() {
        return "";
    }

    public void enterPassword() {
        password.sendKeys(RandomStringUtils.randomAlphanumeric(8));
    }

    public JustGivingPaymentMethod clickContinue() {
        waitForElementToBeVisible(continueButton);
        continueButton.click();
        JustGivingPaymentMethod justGivingPaymentMethod = new JustGivingPaymentMethod(getDriver()).initPage(JustGivingPaymentMethod.class);
        justGivingPaymentMethod.waitForPageToLoad(justGivingPaymentMethod.getPageLoadCondition());
        return justGivingPaymentMethod;
    }
}
