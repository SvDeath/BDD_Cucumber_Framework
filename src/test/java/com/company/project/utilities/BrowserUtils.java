package com.company.project.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {

    public static void switchWindowAndVerify( String expectedInUrl, String expectedInTitle){

        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();

        for (String each : allWindowHandles){

            Driver.getDriver().switchTo().window(each);
            if (Driver.getDriver().getCurrentUrl().contains(expectedInUrl)){
                break;
            }
        }
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedInTitle));

    }

    public static void verifyTitle( String expectedTitle){

        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    public static void verifyTitleContains( String expectedTitle){

        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    public static void sleep(int seconds){

        seconds *= 1000;
        try {
            Thread.sleep(seconds);
        }catch (InterruptedException e){
        }
    }

    public static List<String> dropDownOptions_as_String(WebElement dropdownElement){
        Select month = new Select(dropdownElement);

        List<WebElement> month_as_WebElement = month.getOptions();

        List<String> month_as_String = new ArrayList<>();

        for (WebElement each : month_as_WebElement){

            month_as_String.add(each.getText());
        }
        return month_as_String;
    }

    public static void clickRadioButton(List<WebElement> radioButtons, String attributeValue){

        for (WebElement each : radioButtons){
            if(each.getAttribute("value").equals(attributeValue)){
                each.click();
            }
        }
    }

    public static void verifyURLContains(String expectedInURL){
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedInURL));
    }

    public static void hover(WebElement element){
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }

    public static WebElement waitForVisibility(WebElement element, int time){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

}
