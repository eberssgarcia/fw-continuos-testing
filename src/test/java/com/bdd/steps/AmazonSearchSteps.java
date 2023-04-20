package com.bdd.steps;

import com.bdd.pages.AmazonSearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class AmazonSearchSteps {

    AmazonSearchPage amazonSearchPage = new AmazonSearchPage();

    @Given("the user navigates to www.amazon.com")
    public void navigateToAmazon() {
        amazonSearchPage.navigateToAmazon();
    }

    @And("searchs for {string}")
    public void searchsFor(String criteria) {
        amazonSearchPage.enterSearchCriteria(criteria);
        amazonSearchPage.clickSearch();
    }

    @And("navigates to page number {string}")
    public void navigatesToTheSenondPage(String pageNumber) {
        amazonSearchPage.goToPage(pageNumber);
    }

    @And("selects the thrid item")
    public void selectsTheThridItem() {
        amazonSearchPage.pick3rdItem();
    }

    @Then("the user is able to add it to the card")
    public void theUserIsAbleToAddItToTheCard() {
        amazonSearchPage.addToCart();
        Assert.assertEquals("Agregado al carrito", amazonSearchPage.addedToCartMessage());
    }
}
