package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingExamplePage extends BasePage {

    private static final By START_BUTTON = By.cssSelector("#start button");
    private static final By LOADING_INDICATOR = By.id("loading");
    private static final By FINISH_TEXT = By.cssSelector("#finish h4");

    public DynamicLoadingExamplePage(WebDriver driver) {
        super(driver);
        waitForVisible(START_BUTTON);
    }

    public DynamicLoadingExamplePage clickStart() {
        click(START_BUTTON);
        return this;
    }

    public DynamicLoadingExamplePage waitForLoadingToFinish() {
        waitForInvisible(LOADING_INDICATOR);
        waitForVisible(FINISH_TEXT);
        return this;
    }

    public String getFinishText() {
        return getText(FINISH_TEXT);
    }
}
