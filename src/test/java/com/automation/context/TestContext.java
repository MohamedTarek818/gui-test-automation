package com.automation.context;

import com.automation.driver.DriverManager;
import com.automation.pages.DynamicLoadingExamplePage;
import com.automation.pages.DynamicLoadingPage;
import com.automation.pages.FileUploadPage;
import com.automation.pages.HomePage;
import com.automation.pages.UploadResultPage;

public class TestContext {

    private HomePage homePage;
    private FileUploadPage fileUploadPage;
    private UploadResultPage uploadResultPage;
    private DynamicLoadingPage dynamicLoadingPage;
    private DynamicLoadingExamplePage dynamicLoadingExamplePage;

    public HomePage homePage() {
        if (homePage == null) {
            homePage = new HomePage(DriverManager.getDriver());
        }
        return homePage;
    }

    public FileUploadPage fileUploadPage() {
        return fileUploadPage;
    }

    public void setFileUploadPage(FileUploadPage fileUploadPage) {
        this.fileUploadPage = fileUploadPage;
    }

    public UploadResultPage uploadResultPage() {
        return uploadResultPage;
    }

    public void setUploadResultPage(UploadResultPage uploadResultPage) {
        this.uploadResultPage = uploadResultPage;
    }

    public DynamicLoadingPage dynamicLoadingPage() {
        return dynamicLoadingPage;
    }

    public void setDynamicLoadingPage(DynamicLoadingPage dynamicLoadingPage) {
        this.dynamicLoadingPage = dynamicLoadingPage;
    }

    public DynamicLoadingExamplePage dynamicLoadingExamplePage() {
        return dynamicLoadingExamplePage;
    }

    public void setDynamicLoadingExamplePage(DynamicLoadingExamplePage dynamicLoadingExamplePage) {
        this.dynamicLoadingExamplePage = dynamicLoadingExamplePage;
    }
}
