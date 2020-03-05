package com.kci.base;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class UserActions {

    private WebDriver driver;

    public UserActions(WebDriver driver) {
        this.driver=driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

   /* protected WebElement findElementById(String id) {
        return getDriver().findElement(By.id(id));
    }

    protected WebElement findElementByName(String name) {
        return getDriver().findElement(By.name(name));
    }

    protected List<WebElement> findElementsById(String id) {
        return getDriver().findElements(By.id(id));
    }

    protected WebElement findElementByLinkText(String linkText) {
        return getDriver().findElement(By.linkText(linkText));
    }

    protected WebElement findElementByClassName(String className) {
        return getDriver().findElement(By.className(className));
    }

    protected WebElement findElementByXpath(String xpathExpression) {
        return getDriver().findElement(By.xpath(xpathExpression));
    }

    protected List<WebElement> findElementsByXpath(String xpathExpression) {
        return getDriver().findElements(By.xpath(xpathExpression));
    }

    protected WebElement findElementByCssSelector(String selector) {
        return getDriver().findElement(By.cssSelector(selector));
    }*/


    public String getPageTitle(){
        return getDriver().getTitle();
    }

    protected void type(WebElement target, String value) {
        target.clear();
        target.sendKeys(value);
    }

    public boolean isTextPresent(String text) {
        WebElement bodySource = getDriver().findElement(By.tagName("body"));
        String bodyText = bodySource.getText();
        return bodyText.contains(text);
    }

    public void selectFromDropDownByVisibleText(WebElement element, String visibleText) {
        Select dropDown = new Select(element);
        dropDown.selectByVisibleText(visibleText);
    }

    protected boolean isElementPresent(By locatorKey) {
        try {
            getDriver().findElement(locatorKey);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected static boolean isCurrentlyVisible(WebDriver driver, By locator) {
        List<WebElement> elements = driver.findElements(locator);
        if (elements.isEmpty()) {
            return false;
        } else {
            for (WebElement element : elements) {
                if (!element.isDisplayed()) {
                    return false;
                }
            }
            return true;
        }
    }

    public String getFirstSelectedOption(WebElement element) {
        return new Select(element).getFirstSelectedOption().getText();
    }

    protected void select(WebElement target, String item){
        boolean found = false;
        Select select = new Select(target);

        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
            String selectOption = option.getText();
            if (selectOption.equals(item)) {
                option.click();
                found = true;
                break;
            }

            if(!found && (selectOption.contains(item))){
                option.click();
                found = true;
                break;
            }
        }

        if(!found) {
            throw new InputMismatchException("item <"+item+"> not found in the list");
        }
    }
}
