package example.pages;

import example.util.TestConf;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    private WebDriver driver;
    private static final TestConf EXTERNAL_CONF = TestConf.getBaseConf();

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static BasePage loadUsing(WebDriver driver){
        driver.get(EXTERNAL_CONF.getBaseUrl());
        return new BasePage(driver);
    }
}
