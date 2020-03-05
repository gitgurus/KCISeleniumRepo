package com.kci.pages;

import com.kci.base.UserActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class KioskPassengerSelectionPage extends UserActions {

    @FindBy(xpath = "//h3[@id='select-pax-title']")
    private WebElement pageHeader;

    @FindBy(className = "btn btn-add-ff-number btn-kiosk-submit")
    private WebElement rewardsButton;



    public KioskPassengerSelectionPage(WebDriver driver) {
        super(driver);

    }
}
