package com.automation.steps;

import com.automation.context.TestContext;
import io.cucumber.java.en.Given;

public class CommonSteps {

    private final TestContext context;

    public CommonSteps(TestContext context) {
        this.context = context;
    }

    @Given("the user is on the home page")
    public void theUserIsOnTheHomePage() {
        context.homePage().open();
    }
}
