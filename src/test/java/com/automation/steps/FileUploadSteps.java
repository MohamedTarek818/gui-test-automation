package com.automation.steps;

import com.automation.config.ConfigReader;
import com.automation.context.TestContext;
import com.automation.utils.ResourceUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class FileUploadSteps {

    private final TestContext context;

    public FileUploadSteps(TestContext context) {
        this.context = context;
    }

    @When("the user opens the File Upload page")
    public void theUserOpensTheFileUploadPage() {
        context.setFileUploadPage(context.homePage().openFileUpload());
    }

    @And("the user selects the file {string}")
    public void theUserSelectsTheFile(String fileName) {
        String path = ResourceUtils.getAbsolutePath(ConfigReader.get("test.data.dir") + fileName);
        context.fileUploadPage().selectFile(path);
    }

    @And("the user submits the file")
    public void theUserSubmitsTheFile() {
        context.setUploadResultPage(context.fileUploadPage().submit());
    }

    @Then("the upload confirmation message should be {string}")
    public void theUploadConfirmationMessageShouldBe(String expectedMessage) {
        Assert.assertEquals(context.uploadResultPage().getConfirmationMessage(), expectedMessage,
                "Upload confirmation message mismatch");
    }

    @And("the uploaded file name should be {string}")
    public void theUploadedFileNameShouldBe(String expectedFileName) {
        Assert.assertEquals(context.uploadResultPage().getUploadedFileName(), expectedFileName,
                "Uploaded file name mismatch");
    }
}
