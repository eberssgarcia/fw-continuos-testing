package com.bdd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    protected static WebDriver driver; // static para que haya solo un valor definido.
    private static WebDriverWait wait; // Tiempo de espera - instancia
    private static Actions action; // instancia - clase de selenium

    // Creamos la instancia de WebDriver STATIC para no pasar la instancia a otras clases.
    // Esto permite tener codigo limpio y ordenado
    static {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);

        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // https://www.selenium.dev/documentation/webdriver/waits/
    }

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Methods
    public static void navigateTo(String url) {
        driver.get(url);
    }

    public static void closeDriver() {
        driver.quit();
    }

    // Escribir la espera una sola vez, será hererado a todos los metodos
    private WebElement Find(String locator) {
        // ExpectedConditions espera explícita: que espere 10 segundos por el elemento web, si encuentra antes pues mejor
        // ya que continuará cuando lo encuentre.
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void write(String locator, String textToWrite) {
        Find(locator).clear();
        Find(locator).sendKeys(textToWrite);
    }

    // devuelve un valor entero, se crea una lista
    public int dropdownSize(String locator) {
        // Selecciono el locator de todas las marcas
        Select dropdown = new Select(Find(locator));
        // Crea una lista que contiene elemento web (WebElement)
        // y estamos opteniendo todas las opciones, esto con un select y .getOptions() nos trae todas las opciones del select.
        List<WebElement> dropdownOptions = dropdown.getOptions();
        // Retornamos la cantidad o valor de la lista.
        return dropdownOptions.size();
    }

    public void clickElement(String locator) {
        Find(locator).click();
    }

    public void goToLinkText(String linktText) {
        driver.findElement(By.linkText(linktText)).click();
    }

    public void selectNthElement(String locator, int index) {
        List<WebElement> results = driver.findElements(By.xpath(locator));
        results.get(index).click();
    }


    public void selectFromDropdownByValue(String locator, String valueToSelect) {
        Select dropdown = new Select(Find(locator));
        dropdown.selectByValue(valueToSelect);
    }

    public void selectFromDropdownByIndex(String locator, int valueToSelect) {
        Select dropdown = new Select(Find(locator));
        dropdown.selectByIndex(valueToSelect);
    }

    public void selectFromDropdownByText(String locator, String valueToSelect) {
        Select dropdown = new Select(Find(locator));
        dropdown.selectByVisibleText(valueToSelect);
    }

    public void hoverOverElement(String locator) {
        action.moveToElement(Find(locator));
    }

    public void doubleClick(String locator) {
        action.doubleClick(Find(locator));
    }

    public void rightClick(String locator) {
        action.contextClick(Find(locator));
    }

    // Traer valores de una tabla de la columna y file 3.
    public String getVakueFromTable(String locator, int row, int colum) {
        String cellINeed = locator + "/table/tbody/tr[" + row + "]/td[" + colum + "]";
        // return por que es String y se requiere que devuelve un valor, el valor es con el .getText();
        return Find(cellINeed).getText();
    }

    // Pasar parametro para obtner valor - dinamico
    public void setValueOnTable(String locator, int row, int column, String stringToSend) {
        String cellToFill = locator + "/table/tbody/tr[" + row + "]/td[" + column + "]";
        // No hacemos return por que no devuelve nada.
        Find(cellToFill).sendKeys(stringToSend);
    }

    public void switchToiFrame(int iFrameIndex) {
        driver.switchTo().frame(iFrameIndex);
    }

    public void switchToParentFrame() {
        driver.switchTo().parentFrame();
    }

    public void dismissAlert() {
        try {
            driver.switchTo().alert().dismiss();
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
    }

    // Assertions - Nos va a devolver el texto de una asserion
    public String textFromElement(String locator) {
        return Find(locator).getText();
    }

    // Boleanos
    public boolean elementEnabled(String locator) {
        return Find(locator).isEnabled();
    }

    public boolean elemtIsDisplay(String localtor) {
        return Find(localtor).isDisplayed();
    }

    public boolean elementIsSelected(String locator) {
        return Find(locator).isSelected();
    }

    // List
    public List<WebElement> bringMeAllElements(String locator) {
        // findElements nos devuelve una lista.
        // return para que nos devuelva los elementos de la lista
        return driver.findElements(By.className(locator));
    }
}
