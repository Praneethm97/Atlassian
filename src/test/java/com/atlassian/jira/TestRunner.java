package com.atlassian.jira;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src//test//java//FeatureFiles"},
        glue = {"StepDefinitions"},
        monochrome = true,
        plugin = {"pretty","html:target//HtmlReports//Report.html"}
)
public class TestRunner {
}
