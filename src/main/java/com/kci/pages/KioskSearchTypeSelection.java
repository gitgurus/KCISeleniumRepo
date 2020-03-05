package com.kci.pages;

import com.kci.base.UserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KioskSearchTypeSelection extends UserActions {

    @FindBy(id = "type-select-button")
    private WebElement selectButton;


    public KioskSearchTypeSelection(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        WebDriverWait wait = new WebDriverWait(driver,80);
        wait.until(ExpectedConditions.presenceOfElementLocated((By.id("type-select-button"))));
    }
    public KioskKeyboardSearchTypesPage clickOnSelectButton() {
        selectButton.click();
        return new KioskKeyboardSearchTypesPage(getDriver());
    }
}
