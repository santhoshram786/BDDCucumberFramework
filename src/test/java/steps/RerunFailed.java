package steps;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"target/failedtestscenario.txt"},
        glue = {"steps","santhoshHooks"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/failedtestscenario.txt"}
        ,monochrome = true
        ,publish = true
)
public class RerunFailed extends AbstractTestNGCucumberTests {
}
