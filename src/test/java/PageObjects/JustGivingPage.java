package PageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;

public abstract class JustGivingPage<T> {
    private static final String BASE_URL = "https://www.justgiving.com";
    private static final int LOAD_TIMEOUT = 30;
    private static final int REFRESH_RATE = 2;
    static WebDriver driver;

    public JustGivingPage(WebDriver driver) {
        JustGivingPage.driver = driver;
    }

    protected static WebDriver getDriver() {
        return driver;
    }

    public T openPage(Class<T> clazz) {
        T page = initPage(clazz);
        getDriver().get(BASE_URL + getPageUrl());
        ExpectedCondition pageLoadCondition = ((JustGivingPage) page).getPageLoadCondition();
        waitForPageToLoad(pageLoadCondition);
        return page;
    }

    public T initPage(Class<T> clazz) {
        return PageFactory.initElements(getDriver(), clazz);
    }

    public void waitForPageToLoad(ExpectedCondition<?> pageLoadCondition) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
                .withTimeout(LOAD_TIMEOUT, TimeUnit.SECONDS)
                .pollingEvery(REFRESH_RATE, TimeUnit.SECONDS);

        wait.until(pageLoadCondition);
    }

    public void waitForElementToBeVisible(WebElement element){
        Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
                .withTimeout(LOAD_TIMEOUT, TimeUnit.SECONDS)
                .pollingEvery(REFRESH_RATE, TimeUnit.SECONDS);

        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected abstract ExpectedCondition getPageLoadCondition();

    public abstract String getPageUrl();

}
