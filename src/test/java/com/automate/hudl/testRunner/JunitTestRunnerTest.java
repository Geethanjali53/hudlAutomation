package com.automate.hudl.testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = "com/automate/hudl/stepDefinitions", tags = "@Login or @HomePage",
        plugin = {"pretty", "html:target/hudl_cucumbertestreport.html", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "rerun:target/failed_scenarios.txt"}, monochrome = true
)

public class JunitTestRunnerTest {

}
