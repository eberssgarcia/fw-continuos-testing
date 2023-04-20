package com.bdd.steps;

import com.bdd.pages.GridPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class GridTestSteps {

    GridPage gridPage = new GridPage();

    @Given("I navigate to static table")
    public void iNavigateToStaticTable() {
        gridPage.navigateToGrid();
    }

    @Then("I can return the I wanted")
    public void iCanReturnTheIWanted() {
        String value = gridPage.getValueFromGrid(3, 2);
        Assert.assertEquals("r: 2, c: 1", value);
    }

    @Then("I can validate the table is displayed")
    public void iCanValidateTheTableIsDisplayed() {
        Assert.assertTrue("El elemento esta siendo mostrado.", gridPage.cellStatus());
    }
}
