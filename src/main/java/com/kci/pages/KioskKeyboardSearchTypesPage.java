package com.kci.pages;

import com.kci.base.UserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KioskKeyboardSearchTypesPage extends UserActions {


    @FindBy(id = "PNR-button")
    private WebElement pnrButton;

    @FindBy(id = "FLIGHT-button")
    private WebElement flightButton;

    @FindBy(id = "FF-button")
    private WebElement FFButton;

    @FindBy(id = "VCR-button")
    private WebElement vcrButton;

    public KioskKeyboardSearchTypesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        WebDriverWait wait = new WebDriverWait(driver,80);
        wait.until(ExpectedConditions.presenceOfElementLocated((By.id("PNR-button"))));
    }

    public KioskReservationLookupByKeyboardInput clickOnConfirmationNumber() {
        pnrButton.click();
        return new KioskReservationLookupByKeyboardInput(getDriver());
    }

    public KioskReservationLookupByKeyboardInput clickOneTicketNumber() {
        flightButton.click();
        return new KioskReservationLookupByKeyboardInput(getDriver());
    }

    public KioskReservationLookupByKeyboardInput clickOnRewardsNumber() {
        FFButton.click();
        return new KioskReservationLookupByKeyboardInput(getDriver());
    }

    public KioskReservationLookupByKeyboardInput clickOnFlightNumber() {
        vcrButton.click();
        return new KioskReservationLookupByKeyboardInput(getDriver());
    }
}
