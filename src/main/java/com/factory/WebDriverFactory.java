package com.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverFactory {

    public static WebDriverFactory getInstance=new WebDriverFactory();

    private WebDriverFactory()
    {}

    public static WebDriverFactory getInstance()
    {
        return getInstance;
    }

    public static ThreadLocal<WebDriver> threadLocal=new ThreadLocal<WebDriver>();

    public  static WebDriver  getDriverFactoryInstance(String browserName)
    {
        if(getDriver()==null)
        {
            switch (browserName)
            {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    threadLocal.set(new ChromeDriver());
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    threadLocal.set(new EdgeDriver());
                    break;
                default:break;
            }
        }

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        return getDriver();

    }

    public static synchronized WebDriver getDriver()
    {
        return threadLocal.get();
    }




}
