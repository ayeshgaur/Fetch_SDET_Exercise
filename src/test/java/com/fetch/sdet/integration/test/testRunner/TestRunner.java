package com.fetch.sdet.integration.test.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
         monochrome=false,  //console output color
        features = {"src/test/resources" }, //location of feature files
        glue= {"com.fetch.sdet.integration.test.stepDef"}

)
public class TestRunner  extends AbstractTestNGCucumberTests {


}
