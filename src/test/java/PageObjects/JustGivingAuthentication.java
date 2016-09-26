package PageObjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class JustGivingAuthentication extends JustGivingPage<JustGivingAuthentication> {


    @FindBy(id = "Authentication-fieldset")
    WebElement fieldSet;

    @FindBy(xpath = "//div[contains(@class,'password-and-opt-in')]/following-sibling::*//a[contains(@class,'awesome-continue-button ')]")
//    @FindBy(xpath = "////span[@id='email-content']//a[contains(@class,'awesome-continue-button ')]")
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

    //make invisible for the test
    @Override
    public void clickButton(WebElement button) {
        button.click();
    }

    public void enterPassword() {
        password.sendKeys(RandomStringUtils.randomAlphanumeric(8));
    }

    public JustGivingPaymentMethod clickContinue() {
        clickButton(continueButton);
        JustGivingPaymentMethod justGivingPaymentMethod = new JustGivingPaymentMethod().initPage(JustGivingPaymentMethod.class);
        justGivingPaymentMethod.waitForPageToLoad(justGivingPaymentMethod.getPageLoadCondition());
        return justGivingPaymentMethod;
    }
}
