package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class AmazonHome_Steps {
    WebDriver driver;

    public AmazonHome_Steps(CommonSteps commonSteps){
        this.driver = commonSteps.getDriver();
    }

    @Given("I am on Amazon Home Page")
    public void i_am_on_amazon_home_page() {
        driver.get("https://www.amazon.com");
        driver.manage().window().maximize();
    }

    @When("I click on Cart Link")
    public void i_click_on_cart_link() {
        driver.findElement(By.xpath("//*[contains(text(),'Cart')][@class = 'nav-line-2']")).click();
    }

    @Then("I navigate to Shopping Cart Page")
    public void i_navigate_to_shopping_cart_page() {
      String expURL = "https://www.amazon.com/gp/cart/view.html?ref_=nav_cart";
      String actUrl = driver.getCurrentUrl();

      if(!expURL.contains(actUrl)){
          Assert.fail("fail to navigate on Cart Page");
      }

    }
    @When("I advanced Search an item")
    public void i_advanced_search_an_item(DataTable dataTable) {
        System.out.println(dataTable.cell(1,0));
        System.out.println(dataTable.cell(1,1));
        System.out.println(dataTable.cell(1,2));
        System.out.println(dataTable.cell(1,3));
    }
    @When("I click on {string}")
    public void i_click_on(String link) {
        driver.findElement(By.linkText(link)).click();
    }
    @Then("I navigated to {string} and {string} is shown")
    public void i_navigated_to_and_is_shown(String url, String title) {
        String expUrl = driver.getCurrentUrl();
        String expTitle = driver.getTitle();

        if(!expUrl.contains(url)){
            Assert.fail("In url Something Changed: " + url);
        }
        if(!expTitle.contains(title)){
           Assert.fail("In title Something Changed: " + title);
        }
    }
}
