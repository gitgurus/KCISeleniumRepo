package com.kci.qa.tests;

import com.kci.base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class sampleTests extends BaseTest {

    WebDriver driver = getBrowser();

    public sampleTests() throws IOException {
    }

    @Test
    public void launch_google_page(){

        driver.get("https://google.com");
        driver.quit();
    }

    @Test
    public void launch_facebook_page(){

        driver.get("https://facebook.com");
        driver.quit();
    }
}
