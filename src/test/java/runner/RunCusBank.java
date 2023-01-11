package runner;

import io.cucumber.junit.CucumberOptions;

import java.io.File;

import org.junit.After;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/resources/features/",
        plugin = {"pretty", "html:target/cucumber-html-report"}
)
class RunCusBank {
}