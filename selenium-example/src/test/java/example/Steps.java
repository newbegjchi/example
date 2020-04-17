package example;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import example.pages.BasePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Steps {

    private WebDriver driver;
    private Object currentPage;

    @Before
    public void setDriver() {
        driver = new FirefoxDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("^a base page$")
    public void preconditon() throws Throwable {
        currentPage = BasePage.loadUsing(driver);
        verifyCurrent(BasePage.class);
    }

    @When("^action$")
    public void action() throws Throwable {
        System.out.println("to be implemented");
    }

    @Then("^outcome$")
    public void outcome() throws Throwable {
        System.out.println("to be implemented");
    }


    private void verifyCurrent(Class clazz) {

        if (!currentPage.getClass().equals(clazz)) {
            Assert.fail(
                    String.format("Expected current page to have type %s - actual type is %s",
                            clazz.getSimpleName(),
                            currentPage.getClass().getSimpleName()));
        }
    }
}
