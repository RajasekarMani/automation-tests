package com.example.acceptancetests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(glue = { "io.magentys.cinnamon", "com.example" }, features = "src/test/resources/features", format = {
		"pretty", "json:target/cucumber-reports/cucumber.json" }, tags = { "@complete,@accepted" })
public class AllTests {
}
