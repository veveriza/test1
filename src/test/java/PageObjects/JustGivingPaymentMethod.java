package PageObjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utils.MockDataGenerator;

public class JustGivingPaymentMethod extends JustGivingPage<JustGivingPaymentMethod>{

    public JustGivingPaymentMethod(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "Payment-fieldset")
    WebElement fieldSet;

    @FindBy(xpath = ".//div[@id='credit-card-fields']/following-sibling::*//a[contains(@class,'awesome-continue-button ')]")
    WebElement continueButton;

    @FindBy(id = "Payment_CardType")
    WebElement selectCard;

    @FindBy(id = "Payment_CardNumber")
    WebElement cardNumber;

    @FindBy(id = "Payment_ExpiryDatePart_Month")
    WebElement expiryMonth;

    @FindBy(id = "Payment_ExpiryDatePart_Year")
    WebElement expiryYear;

    @FindBy(id = "Payment_NameOnCard")
    WebElement nameOnCard;

    @Override
    protected ExpectedCondition getPageLoadCondition() {
        return ExpectedConditions.visibilityOf(fieldSet);
    }

    @Override
    public String getPageUrl() {
        return "";
    }

    public void selectCardType(){
        Select dropDown = new Select(selectCard);
        dropDown.selectByVisibleText("Visa Debit");
    }

    public void seExpiryMonth() {
        // any month is OK as long as it is next year
        Select dropDown = new Select(expiryMonth);
        dropDown.selectByIndex(1);
    }

    public void setExpiryYear() {
        // next year is always OK
        Select dropDown = new Select(expiryYear);
        dropDown.selectByIndex(2);
    }

    public void setCardNumber() {
        //make it to select randomly form the array
        //http://codytaylor.org/2009/11/this-is-how-credit-card-numbers-are-generated.html
        //http://euro.ecom.cmu.edu/resources/elibrary/everycc.htm
        cardNumber.sendKeys(MockDataGenerator.generate(16));
    }

    public void setNameOnCard() {
        nameOnCard.sendKeys(RandomStringUtils.randomAlphanumeric(8));
    }

    public JustGivingBillingAddress clickContinue() {
        waitForElementToBeVisible(continueButton);
        continueButton.click();
        JustGivingBillingAddress justGivingBillingAddress = new JustGivingBillingAddress(getDriver()).initPage(JustGivingBillingAddress.class);
        justGivingBillingAddress.waitForPageToLoad(getPageLoadCondition());
        return justGivingBillingAddress;
    }
}
