package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage extends BasePage {

    private static final By FILE_INPUT = By.id("file-upload");
    private static final By UPLOAD_BUTTON = By.id("file-submit");

    public FileUploadPage(WebDriver driver) {
        super(driver);
        waitForPresence(FILE_INPUT);
    }

    /** @param absoluteFilePath absolute path of the file to upload */
    public FileUploadPage selectFile(String absoluteFilePath) {
        waitForPresence(FILE_INPUT).sendKeys(absoluteFilePath);
        return this;
    }

    public UploadResultPage submit() {
        click(UPLOAD_BUTTON);
        return new UploadResultPage(driver);
    }
}
