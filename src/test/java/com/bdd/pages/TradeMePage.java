package com.bdd.pages;

public class TradeMePage extends BasePage {

    // Constructor
    public TradeMePage() {
        super(driver);
    }

    // Xpaths
    private String makeDropdown = "(//select[@name='selectedMake'])";
    private String searchButton = "//button[@type='submit']";
    private String resultsLabel = "//h3[@class='tm-search-header-result-count__heading ng-star-inserted']";

    // Methods
    public void navigateToTradeMeMotor() {
        navigateTo("https://www.trademe.co.nz/a/motors");
    }

    public int makeDropdownSize() {
        return dropdownSize(makeDropdown);
    }

    public void selectMakeFromDropdown(String make) {
        selectFromDropdownByText(makeDropdown, make);
    }

    public void clickSearch() {
        clickElement(searchButton);
    }

    public String resultsAmount() {
        return textFromElement(resultsLabel);
    }
}
