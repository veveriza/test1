package PageObjects;


import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class JustGivingMessageAndAmountPage extends JustGivingPage<JustGivingMessageAndAmountPage> {

    public JustGivingMessageAndAmountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "MessageAndAmount-fieldset")
    WebElement fieldSet;

    @FindBy(id = "MessageAndAmount_Message")
    WebElement leaveAMessage;

    @FindBy(id = "MessageAndAmount_Name")
    WebElement yourName;

    @FindBy(xpath = "//a[contains(@class,'awesome-continue-button ')]")
    WebElement continueButton;

    @Override
    protected ExpectedCondition getPageLoadCondition() {
        return ExpectedConditions.visibilityOf(fieldSet);
    }

    @Override
    public String getPageUrl() {
        return "/4w350m3/donation/direct/charity/2050#MessageAndAmount";
    }

    public JustGivingMessageAndAmountPage open() {
        return new JustGivingMessageAndAmountPage(getDriver()).openPage(JustGivingMessageAndAmountPage.class);
    }

    public void leaveMessage() {
        leaveAMessage.sendKeys(RandomStringUtils.randomAlphanumeric(20));
    }

    public void enterYourName() {
        yourName.sendKeys(RandomStringUtils.randomAlphanumeric(20));
    }

    public JustGivingIdentity clickContinue() {
        waitForElementToBeVisible(continueButton);
        continueButton.click();
        JustGivingIdentity justGivingIdentity = new JustGivingIdentity(getDriver()).initPage(JustGivingIdentity.class);
        justGivingIdentity.waitForPageToLoad(justGivingIdentity.getPageLoadCondition());
        return justGivingIdentity;
    }


}

