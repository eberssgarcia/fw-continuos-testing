package com.bdd.runner;

import com.bdd.pages.BasePage;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

// cucumber-junit - dependency
@RunWith(Cucumber.class)
@CucumberOptions(glue = {"com.bdd.steps"}, // Donde esta la definition para los Step de los features
        features = "src/test/resources/features",
        stepNotifications = true,
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "json:target/cucumber-reports.json"},
        tags = "@amazon-01")

public class RunnerTest {
    @AfterClass
    public static void cleanDriver() {
        BasePage.closeDriver();
    }
}
