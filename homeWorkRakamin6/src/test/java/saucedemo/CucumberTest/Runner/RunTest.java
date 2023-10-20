package saucedemo.CucumberTest.Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/saucedemo/CucumberTest/Features", // Specify the path to your feature files
        glue = "saucedemo.CucumberTest.StepDefinitions", // Specify the package where your step definitions are
        plugin = {
                "pretty",
                "html:target/cucumber-reports/outputReport.html", // HTML report
                "json:target/cucumber-reports/outputReport.json", // JSON report
                "junit:target/cucumber-reports/cucumber.xml", // JUnit XML report
                "usage:target/cucumber-reports/usage.json" // Usage report in JSON format
        }
)

public class RunTest {
}
