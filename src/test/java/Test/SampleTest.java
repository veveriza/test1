package Test;

import PageObjects.JustGivingAuthentication;
import PageObjects.JustGivingBillingAddress;
import PageObjects.JustGivingIdentity;
import PageObjects.JustGivingMessageAndAmountPage;
import PageObjects.JustGivingPaymentMethod;
import PageObjects.JustGivingReviewAndDonate;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleTest {

    private static WebDriver driver;

    @BeforeClass
    public static void setUp() throws Exception {
        driver = new ChromeDriver();
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void should_not_login_with_wrong_credentials() throws InterruptedException {

        //given
        JustGivingMessageAndAmountPage justGivingMessageAndAmountPage = new JustGivingMessageAndAmountPage(driver).open();

        //when
        justGivingMessageAndAmountPage.leaveMessage();
        justGivingMessageAndAmountPage.enterYourName();
        JustGivingIdentity justGivingIdentity = justGivingMessageAndAmountPage.clickContinue();

        justGivingIdentity.enterEmailAddress();
        JustGivingAuthentication justGivingAuthentication = justGivingIdentity.clickContinue();
        justGivingAuthentication.enterPassword();

        JustGivingPaymentMethod justGivingPaymentMethod = justGivingAuthentication.clickContinue();
        justGivingPaymentMethod.selectCardType();
        justGivingPaymentMethod.setCardNumber();
        justGivingPaymentMethod.seExpiryMonth();
        justGivingPaymentMethod.setExpiryYear();
        justGivingPaymentMethod.setNameOnCard();

        JustGivingBillingAddress justGivingBillingAddress = justGivingPaymentMethod.clickContinue();
        justGivingBillingAddress.setHouseNumber();
        justGivingBillingAddress.setPostCode();
        justGivingBillingAddress.findAddress();
        justGivingBillingAddress.setAddressLine1();
        JustGivingReviewAndDonate justGivingReviewAndDonate = justGivingBillingAddress.clickContinue();
        justGivingReviewAndDonate.isDonateNowDisplayed();

    }
}
