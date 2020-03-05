
package com.kci.pages;
import com.kci.base.UserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KioskStartPage extends UserActions {

    @FindBy(id="en_US")
    private WebElement englishButton;

    @FindBy(id = "ar_AE")
    private WebElement arabic;

    @FindBy(id="touch-screen-message")
    private WebElement getTouchTheScreenToBegin;


    public KioskStartPage(WebDriver driver) throws InterruptedException {
        super(driver);
        PageFactory.initElements(driver,this);
        WebDriverWait wait = new WebDriverWait(driver,80);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("en_US")));
    }

    public void selectEnglishButton() {
        englishButton.click();
    }

    public KioskSearchTypeSelection clickOnTouchTheScreenToContinue() {
        getTouchTheScreenToBegin.click();
        return new KioskSearchTypeSelection(getDriver());
    }



    public void selectAnotherButton() {
        arabic.click();
    }

}

