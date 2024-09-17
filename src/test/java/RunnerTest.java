package test.java;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@io.cucumber.junit.CucumberOptions(features = "src/test/resources/features", glue = "", monochrome = true, plugin = {
		"pretty", "html:target/cucumber-reports/report.html",
		"json:target/cucumber-reports/cucumber.json" }, tags = "@JSON-Parse")
public class RunnerTest {
}