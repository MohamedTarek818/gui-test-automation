package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage extends BasePage {

    private static final String EXAMPLE_LINK_PREFIX = "Example ";

    public DynamicLoadingPage(WebDriver driver) {
        super(driver);
    }

    public DynamicLoadingExamplePage openExample(int exampleNumber) {
        click(By.partialLinkText(EXAMPLE_LINK_PREFIX + exampleNumber));
        return new DynamicLoadingExamplePage(driver);
    }
}
