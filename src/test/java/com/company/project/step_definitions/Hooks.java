package com.company.project.step_definitions;

import com.company.project.utilities.ConfigurationReader;
import com.company.project.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        System.out.println("This is how @After annotation is working, after each scenario");
        Driver.closeDriver();
    }
    @Before
    public void setUp() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }


}
