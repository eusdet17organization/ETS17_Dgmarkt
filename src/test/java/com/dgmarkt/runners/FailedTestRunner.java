package com.dgmarkt.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/failed-html-reports.html"
        },
        features = "@target/rerun.txt",
        glue = "com/dgmarkt/step_definitions"


)
public class FailedTestRunner {
}
