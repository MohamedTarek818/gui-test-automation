package com.automation.pages;

import com.automation.config.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private static final By HEADING = By.cssSelector("h1.heading");
    private static final String FILE_UPLOAD_LINK = "File Upload";
    private static final String DYNAMIC_LOADING_LINK = "Dynamic Loading";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage open() {
        driver.get(ConfigReader.get("base.url"));
        waitForVisible(HEADING);
        return this;
    }

    public FileUploadPage openFileUpload() {
        clickLink(FILE_UPLOAD_LINK);
        return new FileUploadPage(driver);
    }

    public DynamicLoadingPage openDynamicLoading() {
        clickLink(DYNAMIC_LOADING_LINK);
        return new DynamicLoadingPage(driver);
    }

    private void clickLink(String linkText) {
        click(By.linkText(linkText));
    }
}
