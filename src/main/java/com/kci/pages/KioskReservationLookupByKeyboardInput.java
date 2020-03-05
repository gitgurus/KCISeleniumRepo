package com.kci.pages;

import com.kci.base.UserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KioskReservationLookupByKeyboardInput extends UserActions {

    @FindBy(id = "pnr")
    private WebElement pnrNumber;

    @FindBy(id = "last-name")
    private WebElement  lastName;

    @FindBy(id = "btn-back")
    private WebElement backButton;

    @FindBy(id = "btn-next")
    private WebElement continueButton;

    @FindBy(id = "key-spacebar")
    private WebElement spaceButton;

    public KioskReservationLookupByKeyboardInput(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        WebDriverWait wait = new WebDriverWait(driver,80);
        wait.until(ExpectedConditions.presenceOfElementLocated((By.id("pnr"))));
    }

    public void searchUsingRefNumber(String pnr,String lname) throws InterruptedException {
        Thread.sleep(2000);
        type(pnrNumber,pnr);
        clickOnSpaceButton();
        clickOnContinueButton();
    }

    public void enterPNR(String ref){
        pnrNumber.sendKeys(ref);
    }

    public void enterLastName(String lname){
        type(lastName , lname);
    }

    public void clickOnSpaceButton(){
        spaceButton.click();
    }

    public void clickOnContinueButton(){
        continueButton.click();
    }

    public void clickOnBackButton(){
        backButton.click();
    }
}
