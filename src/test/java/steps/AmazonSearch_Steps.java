package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class AmazonSearch_Steps {
    WebDriver driver;

    public AmazonSearch_Steps(CommonSteps commonSteps){
        this.driver = commonSteps.getDriver();
    }


    @When("I search for {string}")
    public void i_search_for(String product) {
        driver.findElement(By.xpath("//*[@id = 'twotabsearchtextbox']")).sendKeys(product);
        driver.findElement(By.xpath("//*[@id = 'twotabsearchtextbox']")).sendKeys(Keys.ENTER);
    }

    @Then("I validate at least {int} search items present")
    public void i_validate_at_least_search_items_present(Integer item) {
        String expItem = driver.findElement(By.xpath("//h1/div/div[1]/div/div/span[1]")).getText();
        System.out.println(expItem);
    }

}
