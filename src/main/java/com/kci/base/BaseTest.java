package com.kci.base;
import com.kci.pages.KioskStartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;



public class BaseTest {

    private WebDriver driver;
    Properties p;

    public Properties loadPropertyFile() throws IOException {
        p = new Properties();
        File f = new File("src/main/resources/env.properties");
        FileInputStream fileInputStream = new FileInputStream(f.getAbsolutePath());
        p.load(fileInputStream);
        return p;
    }

    public WebDriver getBrowser() throws IOException {
        loadPropertyFile();
        if (p.getProperty("browser").contentEquals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else {
            if (p.getProperty("browser").contentEquals("iexplore")) {
                System.setProperty("webdriver.ie.driver", "src/test/java/drivers/IEDriverServer.exe");
                driver = new InternetExplorerDriver();
            } else {
                System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe");
                driver = new ChromeDriver();
            }
        }
        return driver;
    }

    public KioskStartPage openApplication() throws Exception {
        p = loadPropertyFile();
        String storefront = p.getProperty("storefront");
        String deviceID = p.getProperty("devideID");
        if (p.getProperty("env").contentEquals("INT")) {
            String url = "https://kci1-int.sabresonicweb.com/SSW2010/" + storefront + "K0/kioskBoot.html?deviceId=" + deviceID + "";
            getBrowser().get(url);
            driver.manage().window().maximize();
            return new KioskStartPage(driver);
        } else if (p.getProperty("env").contentEquals("STAGE-CERT")) {
            String url = "https://kci1-stage-cert.sabresonicweb.com/SSW2010/" + storefront + "K0/kioskBoot.jsp?deviceId=" + deviceID + "";
            getBrowser().get(url);
            driver.manage().window().maximize();
            return new KioskStartPage(driver);
        } else if (p.getProperty("env").contentEquals("MINGO-CERT")) {
            String url = "https://kci1-mingo-cert.sabresonicweb.com/SSW2010/" + storefront + "K0/kioskBoot.html?deviceId=" + deviceID + "";
            getBrowser().get(url);
            driver.manage().window().maximize();
            return new KioskStartPage(driver);
        } else {
            String url = "https://kci1-int.sabresonicweb.com/SSW2010/" + storefront + "K0/kioskBoot.html?deviceId=" + deviceID + "";
            getBrowser().get(url);
            driver.manage().window().maximize();
            return new KioskStartPage(driver);
        }
    }

    public WebDriver getWebDriver() {
        return driver;
    }


    @AfterMethod
    public void tearDown() {
        getWebDriver().quit();
    }
}

