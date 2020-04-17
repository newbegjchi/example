package example;

import java.util.Map;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import example.util.TestConf;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println(TestConf.getBaseConf().getBaseUrl());
    }
}
