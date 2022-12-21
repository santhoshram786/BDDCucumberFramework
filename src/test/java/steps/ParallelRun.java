package steps;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        features = {"src/test/resources/steps/"},
        glue = {"steps","santhoshHooks"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        "rerun:target/failedtestscenario.txt"},
        tags =("@Testing")
        ,monochrome = true
        ,publish = true
)

public class ParallelRun extends AbstractTestNGCucumberTests {

//    @Override
//    @DataProvider(parallel = true)
//    public Object[][] scenarios()
//    {
//        return super.scenarios();
//    }

}
