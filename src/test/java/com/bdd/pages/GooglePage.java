package com.bdd.pages;

import org.openqa.selenium.WebElement;

public class GooglePage extends BasePage {

    // Herencia
    public GooglePage() {
        super(driver);
    }

    // Xpaths
    private String searchTextField = "//input[@title='Buscar']";
    private String searchButton = "//input[@value='Buscar con Google']";
    private String firstResult = "//h3[contains(text(),'Argentina - Wikipedia, la enciclopedia libre')]";


    // Estos metodos son publicos por que despues accederemos a los StepDefinition
    public void navigateToGoogle() {
        navigateTo("https://google.com/");
    }

    public void enterSearchCriteria(String criteria) {
        write(searchTextField, criteria);
    }

    public void clickGoogleSearch() {
        clickElement(searchButton);
    }

    public String firstResult() {
        return textFromElement(firstResult);
    }

}
