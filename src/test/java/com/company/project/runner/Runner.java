package com.company.project.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


/*
@RunWith(Cucumber.class): This annotation tells JUnit to run the Cucumber class when executing this test class. JUnit uses this annotation to identify that the class contains Cucumber tests, and it delegates the execution of the tests to Cucumber.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-reports.html",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                "json:target/cucumber.json"
},
        features = "src/test/resources/features",
        glue = "com/company/project/step_definitions",
        publish = true,
        dryRun = false,
        tags = ""
)

public class Runner { }
