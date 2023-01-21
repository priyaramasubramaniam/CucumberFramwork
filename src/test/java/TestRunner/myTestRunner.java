package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
      features = {"/home/waioz/eclipse-workspace/CucumberFramwork/src/test/resources/Feature"},
      glue = {"AppHooks","stepDefinitions"},
      plugin = {
            "pretty",
      }
)
public class myTestRunner {
}
