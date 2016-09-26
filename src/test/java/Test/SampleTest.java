package Test;

import PageObjects.JustGivingAuthentication;
import PageObjects.JustGivingIdentity;
import PageObjects.JustGivingMessageAndAmountPage;
import PageObjects.JustGivingPaymentMethod;
import org.junit.AfterClass;
import org.junit.Test;

public class SampleTest {

    @AfterClass
    public static void tearDown() {
//        getDriver().close();
    }

    @Test
    public void should_not_login_with_wrong_credentials() {

        //given
        JustGivingMessageAndAmountPage justGivingMessageAndAmountPage = new JustGivingMessageAndAmountPage().open();

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

        justGivingPaymentMethod.clickContinue();
//        JustGivingBillingAddress justGivingBillingAddress = justGivingPaymentMethod.clickContinue();


    }
}
