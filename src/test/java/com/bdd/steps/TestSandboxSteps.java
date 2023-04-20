package com.bdd.steps;

import com.bdd.pages.TestSandboxPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class TestSandboxSteps {

    // Instancia de una clase, un objeto
    TestSandboxPage testSandboxPage = new TestSandboxPage();

    @Given("I navigate to sandbox page")
    public void iNavigateToSandboxPage(){
        testSandboxPage.navigateToSandbox();

    }

    @And("select a value from the dropdown")
    public void selectAValueFromTheDropdown() {
        testSandboxPage.selectCategory("Manual");
    }
}
