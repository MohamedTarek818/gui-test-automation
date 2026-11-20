package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UploadResultPage extends BasePage {

    private static final By HEADER = By.tagName("h3");
    private static final By UPLOADED_FILES = By.id("uploaded-files");

    public UploadResultPage(WebDriver driver) {
        super(driver);
    }

    public String getConfirmationMessage() {
        return getText(HEADER);
    }

    public String getUploadedFileName() {
        return getText(UPLOADED_FILES);
    }
}
