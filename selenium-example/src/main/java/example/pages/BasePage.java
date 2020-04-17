package example.pages;

import example.util.TestConf;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    private WebDriver driver;
    private static final TestConf EXTERNAL_CONF = TestConf.getBaseConf();

    private WebElement userNameField;
    private WebElement passwordField;


    @FindBy(xpath = "(//ul[@class='W9ktc']/li/a)[1]")
    private WebElement authenticateButton;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public static TestConf getExternalConf(){
        return EXTERNAL_CONF;
    }

    public static BasePage loadUsing(WebDriver driver){
        driver.get(EXTERNAL_CONF.getBaseUrl());
        return new BasePage(driver);
    }

    public HomePage login(String username, String password) throws InterruptedException {
        authenticateButton.click();
        Thread.sleep(3000);
        return new HomePage(driver);
    }


}
