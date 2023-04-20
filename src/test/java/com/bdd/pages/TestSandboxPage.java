package com.bdd.pages;

public class TestSandboxPage extends BasePage {

    // Constructor
    public TestSandboxPage() {
        super(driver);
    }

    // Xpaths
    private String categoryDropdown = "//select[@id='testingDropdown']";

    // Methods
    public void navigateToSandbox() {
        navigateTo("https://www.google.com");
    }

    public void selectCategory(String category) {
        selectFromDropdownByValue(categoryDropdown, category);
    }
}
