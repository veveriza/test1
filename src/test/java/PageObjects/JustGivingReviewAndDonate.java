package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class JustGivingReviewAndDonate extends JustGivingPage<JustGivingReviewAndDonate>{

    @FindBy(id = "MessageAndAmount-fieldset")
    WebElement fieldSet;

    @FindBy(id = "donate-now-button")
    WebElement donateButton;

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

    public boolean isDonateNowDisplayed(){
        return donateButton.isDisplayed();
    }
}
