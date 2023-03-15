package testRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"features"},        // where your features files are located.
        glue = {"steps"},               // same here for Step definitions where that steps are located.
        plugin = {"pretty","html:Output/Report2.html"},
//        plugin = {"pretty","json:Output/Report1.json"}
//          plugin = {"pretty","junit:Output/Report1"}
        dryRun = false,   // it basically checks those who have not step definitions are still not defined.
//          strict = false   // it basically strictly says definition is mandatory otherwise it failed.
            monochrome = true,  // in pretty format
            tags = "@P2"
//        name = "Logo"
)
public class TestRunner {

}
