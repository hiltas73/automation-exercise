package com.demo.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {
                "html:target/cucumber-report.html",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        },
        features = "src/test/resources/features",
        glue = "com/demo/steps",
        dryRun = false,
        tags = "@ui",
        publish = true //generating a report with public link
)
public class Runner {
}
