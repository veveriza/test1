package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class JustGivingBillingAddress extends JustGivingPage<JustGivingBillingAddress>{

    public JustGivingBillingAddress(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "Payment_BillingAddress-fieldset")
    WebElement fieldSet;

    @FindBy(id = "Payment_BillingAddress_HouseNumber")
    WebElement houseNumber;

    @FindBy(id = "Payment_BillingAddress_Postcode")
    WebElement postCode;

    @FindBy (xpath = ".//select[@id='first-line-selector']")
    WebElement addressLine1;

    @FindBy (xpath = ".//a[contains(@class,'address-lookup-button ui-link')]")
    WebElement findAddressButton;


    @FindBy(xpath = ".//fieldset[@id='Payment_BillingAddress-fieldset']//following-sibling::*//a[@data-bind='visible: ContinueButtonEnabled']")
    WebElement continueButton;

    @FindBy(xpath = ".//div[contains(@class,'manual-address')]")
    WebElement manualAddressArea;

    @Override
    protected ExpectedCondition getPageLoadCondition() {
        return ExpectedConditions.visibilityOf(fieldSet);
    }

    @Override
    public String getPageUrl() {
        return "";
    }

    public void setHouseNumber() {
        waitForElementToBeVisible(houseNumber);
        houseNumber.click();
        houseNumber.sendKeys("110");
    }

    public void setPostCode() {
        postCode.sendKeys("SE1 0TA");
    }

    public void findAddress() {
        findAddressButton.click();
        waitForElementToBeVisible(manualAddressArea);
    }

    public void setAddressLine1() throws InterruptedException {
        Select dropDown = new Select(addressLine1);
        addressLine1.click();
        dropDown.selectByVisibleText("Just Giving Trust Blue Fin Building ");
    }

    public JustGivingReviewAndDonate clickContinue() {
        waitForElementToBeVisible(continueButton);
        continueButton.click();
        JustGivingReviewAndDonate justGivingReviewAndDonate = new JustGivingReviewAndDonate(getDriver()).initPage(JustGivingReviewAndDonate.class);
        justGivingReviewAndDonate.waitForPageToLoad(getPageLoadCondition());
        return justGivingReviewAndDonate;
    }
}
