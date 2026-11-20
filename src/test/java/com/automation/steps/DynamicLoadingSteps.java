package com.automation.steps;

import com.automation.context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class DynamicLoadingSteps {

    private final TestContext context;

    public DynamicLoadingSteps(TestContext context) {
        this.context = context;
    }

    @When("the user opens the Dynamic Loading page")
    public void theUserOpensTheDynamicLoadingPage() {
        context.setDynamicLoadingPage(context.homePage().openDynamicLoading());
    }

    @And("the user opens Example {int}")
    public void theUserOpensExample(int exampleNumber) {
        context.setDynamicLoadingExamplePage(context.dynamicLoadingPage().openExample(exampleNumber));
    }

    @And("the user clicks the Start button")
    public void theUserClicksTheStartButton() {
        context.dynamicLoadingExamplePage().clickStart();
    }

    @And("the user waits for the loading to finish")
    public void theUserWaitsForTheLoadingToFinish() {
        context.dynamicLoadingExamplePage().waitForLoadingToFinish();
    }

    @Then("the displayed text should be {string}")
    public void theDisplayedTextShouldBe(String expectedText) {
        Assert.assertEquals(context.dynamicLoadingExamplePage().getFinishText(), expectedText,
                "Displayed text after loading mismatch");
    }
}
