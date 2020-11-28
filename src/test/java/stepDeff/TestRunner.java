package stepDeff;


import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features= "E:\\seleniumstuff\\zSampleCucumberProj\\src\\test\\resources\\Features\\feature_001.feature",glue="stepDeff")
public class TestRunner {
   }

