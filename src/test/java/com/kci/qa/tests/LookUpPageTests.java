package com.kci.qa.tests;

import com.kci.base.BaseTest;
import com.kci.pages.KioskKeyboardSearchTypesPage;
import com.kci.pages.KioskReservationLookupByKeyboardInput;
import com.kci.pages.KioskSearchTypeSelection;
import com.kci.pages.KioskStartPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LookUpPageTests extends BaseTest {

    String pnr = "ECIITA";
    String lname = "";

    String pageTitle = "KIOSK_START_PAGE";
    String secondPage = "KIOSK";




    @Test
    public void look_up_pnr_using_record_locator() throws Exception {

        KioskStartPage kioskStartPage = openApplication();
        kioskStartPage.selectEnglishButton();
        KioskSearchTypeSelection kioskSearchTypeSelection = kioskStartPage.clickOnTouchTheScreenToContinue();
        KioskKeyboardSearchTypesPage kioskKeyboardSearchTypesPage = kioskSearchTypeSelection.clickOnSelectButton();
        KioskReservationLookupByKeyboardInput kioskReservationLookupByKeyboardInput = kioskKeyboardSearchTypesPage.clickOnConfirmationNumber();
        kioskReservationLookupByKeyboardInput.searchUsingRefNumber(pnr,lname);
    }

    @Test
    public void test1() throws Exception {
        KioskStartPage kioskStartPage = openApplication();
        String title = kioskStartPage.getPageTitle();
        Assert.assertEquals(pageTitle, title,"Page Title is not matched");
    }

    @Test
    public void test2() throws Exception {
        KioskStartPage kioskStartPage = openApplication();
        kioskStartPage.selectAnotherButton();
        kioskStartPage.clickOnTouchTheScreenToContinue();
    }

    @Test
    public void test3() throws Exception
    {
        KioskStartPage kioskStartPage = openApplication();
        kioskStartPage.selectEnglishButton();
        KioskSearchTypeSelection kioskSearchTypeSelection = kioskStartPage.clickOnTouchTheScreenToContinue();
        String title =kioskSearchTypeSelection.getPageTitle();
        Assert.assertNotEquals(secondPage,title,"Page Title is not matched");
    }
}