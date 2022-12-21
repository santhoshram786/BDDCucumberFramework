package com.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverFactoryParallel {


    public static ThreadLocal<WebDriver> threadLocal=new ThreadLocal<WebDriver>();


    public  WebDriver  getDriverFactoryParallelInstance(String browserName)
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
