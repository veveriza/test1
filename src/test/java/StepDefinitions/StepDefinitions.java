package StepDefinitions;

import PageObjects.JustGivingAuthentication;
import PageObjects.JustGivingBillingAddress;
import PageObjects.JustGivingIdentity;
import PageObjects.JustGivingMessageAndAmountPage;
import PageObjects.JustGivingPaymentMethod;
import PageObjects.JustGivingReviewAndDonate;
import cucumber.annotation.After;
import cucumber.annotation.Before;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class StepDefinitions {
    private static WebDriver driver;

    @Before
    public void beforeScenario() {
        driver = new ChromeDriver();
    }

    @After
    public void afterScenario() {
        driver.close();
    }

    JustGivingMessageAndAmountPage justGivingMessageAndAmountPage;
    JustGivingIdentity justGivingIdentity;
    JustGivingPaymentMethod justGivingPaymentMethod;
    JustGivingBillingAddress justGivingBillingAddress;
    JustGivingReviewAndDonate justGivingReviewAndDonate;

    @Given("^I open the JG demo page$")
    public void I_open_the_JG_demo_page() throws Throwable {
        justGivingMessageAndAmountPage = new JustGivingMessageAndAmountPage(driver).open();
    }

    @When("^I fill in valid information on Message and Amount page$")
    public void I_fill_in_valid_information_on_Message_and_Amount_page() throws Throwable {
        justGivingMessageAndAmountPage.leaveMessage();
        justGivingMessageAndAmountPage.enterYourName();
        justGivingIdentity = justGivingMessageAndAmountPage.clickContinue();
    }

    @And("^I identify myself with a new email address and password$")
    public void I_identify_myself_with_a_new_email_address() throws Throwable {
        justGivingIdentity.enterEmailAddress();
        JustGivingAuthentication justGivingAuthentication = justGivingIdentity.clickContinue();
        justGivingAuthentication.enterPassword();
        justGivingPaymentMethod = justGivingAuthentication.clickContinue();
    }

    @And("^I enter valid card details$")
    public void I_enter_valid_card_details() throws Throwable {
        justGivingPaymentMethod.selectCardType();
        justGivingPaymentMethod.setCardNumber();
        justGivingPaymentMethod.seExpiryMonth();
        justGivingPaymentMethod.setExpiryYear();
        justGivingPaymentMethod.setNameOnCard();
        justGivingBillingAddress = justGivingPaymentMethod.clickContinue();
    }

    @And("^I enter valid billing address$")
    public void I_enter_valid_billing_address() throws Throwable {
        justGivingBillingAddress.setHouseNumber();
        justGivingBillingAddress.setPostCode();
        justGivingBillingAddress.findAddress();
        justGivingBillingAddress.setAddressLine1();
        justGivingReviewAndDonate = justGivingBillingAddress.clickContinue();
    }

    @Then("^I land on the review page and I am ready to make the donation$")
    public void I_land_on_the_review_page_and_I_am_ready_to_make_the_donation() throws Throwable {
        assertThat(justGivingReviewAndDonate.isDonateNowDisplayed(), is(true));
    }
}
