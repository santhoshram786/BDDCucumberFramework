package com.factory;

import com.utilities.ConfigPropReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class PropertyFactory {
    private ConfigPropReader configPropReader;

    public static PropertyFactory getInstance=new PropertyFactory();

    private PropertyFactory()
    {}

    public static PropertyFactory getInstance()
    {
        return getInstance;
    }

    public static ThreadLocal<Properties> threadLocal=new ThreadLocal<Properties>();

    public Properties getPropertyFactoryInstance()
    {
        if(getProperty()==null)
        {
            configPropReader=new ConfigPropReader();
            threadLocal.set( configPropReader.load_prop("config.properties"));
        }

        return getProperty();

    }

    public static synchronized Properties getProperty()
    {
        return threadLocal.get();
    }




}
