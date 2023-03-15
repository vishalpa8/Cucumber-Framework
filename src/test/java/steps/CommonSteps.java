package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CommonSteps {

    private WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.edge.driver", "webdriver/msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(Scenario scenario) {
        if(scenario.isFailed()){
            final byte[] scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(scr,"image/png", scenario.getName());
        }
        driver.quit();
    }

    @After("@Test") // it depends on their hierarchical order for all the global hooks.
    public void afterHookTag(){
        System.out.println("this is a separate function for after the hook");
    }

    @Before("@setCookies")  // Scenarios Specific Hook
    public void setCookies() {
        System.out.println("this is a separate function for setting up the cookies.");
    }

    // @After(order = 1 ) @Before(order = 1) //@After(value = '@setCookies',order = 0)
    public WebDriver getDriver() { return driver; }
}
