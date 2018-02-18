package com.example.ui.tasks;

import io.magentys.cinnamon.webdriver.Browser;
import io.magentys.cinnamon.webdriver.Timeouts;
import io.magentys.cinnamon.webdriver.elements.PageElement;
import org.openqa.selenium.NoSuchElementException;

import javax.inject.Inject;

import static com.example.Defaults.DEFAULT_PAGE_TIMEOUT_IN_SECONDS;
import static com.example.Defaults.DEFAULT_WAIT_FOR_ELEMENT_TO_LOAD_IN_SECONDS;
import static io.magentys.cinnamon.webdriver.conditions.Conditions.ajaxFinished;
import static io.magentys.cinnamon.webdriver.conditions.ElementConditions.displayed;
import static io.magentys.cinnamon.webdriver.conditions.ElementConditions.enabled;
import static io.magentys.cinnamon.webdriver.conditions.ElementConditions.textContains;

public class DefaultTasks {

    @Inject
    private Browser browser;

    public void waitUntil(long timeoutInSeconds) throws InterruptedException {
        synchronized (browser) {
            browser.wait(timeoutInSeconds * 1000);
        }
    }

    public void waitForDefaultDuration() throws InterruptedException {
        waitUntil(Timeouts.defaultTimeout().getMillis());
    }

    private void waitUntilAjaxFinished(long timeoutInSeconds) {
        Browser.waitUntil(ajaxFinished, Timeouts.timeoutInSeconds(timeoutInSeconds));
    }

    public void waitUntilPageLoaded(long timeoutInSeconds) {
        waitUntilAjaxFinished(timeoutInSeconds);
    }

    public void waitUntilPageLoaded() {
        waitUntilPageLoaded(DEFAULT_PAGE_TIMEOUT_IN_SECONDS);
    }

    public boolean waitAndCheckElementIsDisplayed(PageElement pageElement, long secondsToWait) {
        try {
            return pageElement.waitUntil(displayed.and(enabled), Timeouts.timeoutInSeconds(secondsToWait))
                    .isDisplayed();
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public boolean waitAndCheckElementIsDisplayed(PageElement pageElement) {
        return waitAndCheckElementIsDisplayed(pageElement, DEFAULT_WAIT_FOR_ELEMENT_TO_LOAD_IN_SECONDS);
    }

    public boolean waitAndCheckElementIsNotDisplayed(PageElement pageElement, long secondsToWait) {
        return !waitAndCheckElementIsDisplayed(pageElement, secondsToWait);
    }

    public boolean waitAndCheckElementIsNotDisplayed(PageElement pageElement) {
        return !waitAndCheckElementIsDisplayed(pageElement, DEFAULT_WAIT_FOR_ELEMENT_TO_LOAD_IN_SECONDS);
    }

    public boolean waitAndCheckElementIsDisplayed(PageElement pageElement, String textContains, long secondsToWait) {
        try {
            return pageElement.waitUntil(displayed.and(enabled).and(textContains(textContains)),
                    Timeouts.timeoutInSeconds(secondsToWait)).isDisplayed();
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public boolean waitAndCheckElementIsDisplayed(PageElement pageElement, String textContains) {
        return waitAndCheckElementIsDisplayed(pageElement, textContains, DEFAULT_WAIT_FOR_ELEMENT_TO_LOAD_IN_SECONDS);
    }

    public boolean waitAndCheckElementIsNotDisplayed(PageElement pageElement, String textContains, long secondsToWait) {
        return !waitAndCheckElementIsDisplayed(pageElement, textContains, secondsToWait);
    }

    public boolean waitAndCheckElementIsNotDisplayed(PageElement pageElement, String textContains) {
        return !waitAndCheckElementIsDisplayed(pageElement, textContains, DEFAULT_WAIT_FOR_ELEMENT_TO_LOAD_IN_SECONDS);
    }

}
