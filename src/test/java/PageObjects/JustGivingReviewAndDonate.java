package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class JustGivingReviewAndDonate extends JustGivingPage<JustGivingReviewAndDonate>{


    public JustGivingReviewAndDonate(WebDriver driver) {
        super(driver);
    }

    public static JustGivingReviewAndDonate create() {
        JustGivingReviewAndDonate page = new JustGivingReviewAndDonate(getDriver());
        page.initPage(JustGivingReviewAndDonate.class);
        return page;
    }

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

    public boolean isDonateNowDisplayed(){
        return donateButton.isDisplayed();
    }
}
