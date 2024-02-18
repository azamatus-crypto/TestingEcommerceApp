package Cucumbers;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/main/java/Cucumbers",glue = "src/main/java/stepdefenitions",monochrome = true,plugin = {"html:target/cucumber.html"})
public class TestNGrunner extends AbstractTestNGCucumberTests {
}
