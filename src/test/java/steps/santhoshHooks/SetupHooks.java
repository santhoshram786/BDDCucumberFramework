package steps.santhoshHooks;

import com.factory.PropertyFactory;
import com.factory.WebDriverFactory;
import com.factory.WebDriverFactoryParallel;
import com.utilities.ConfigPropReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class SetupHooks{

    private ConfigPropReader configPropReader;
    private WebDriverFactoryParallel webDriverFactoryParallel;
    Properties prop;
    WebDriver driver;

    @Before("@SetUpConfig")
    public void setConfig()
    {
//        configPropReader=new ConfigPropReader();
//        prop=configPropReader.load_prop("config.properties");

       prop=PropertyFactory.getInstance().getPropertyFactoryInstance();
        System.out.println("Env name:"+prop.getProperty("env"));
    }

    @Before("@SetUpDriver")
    public void setupWebDriver()
    {
        System.out.println("Browser name:"+prop.getProperty("browser"));
        driver=WebDriverFactory.getInstance().getDriverFactoryInstance(prop.getProperty("browser"));
//        webDriverFactoryParallel=new WebDriverFactoryParallel();
//        driver= webDriverFactoryParallel.getDriverFactoryParallelInstance(prop.getProperty("browser"));
    }


    @After("@Testing")
    public void closeBrowser(Scenario scenario)
    {
        if(scenario.isFailed())
        {
            String screenshotName=scenario.getName().replaceAll(" ","_");
            byte[] screenshotPath=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshotPath,"image/png",screenshotName);
        }
        driver.quit();
    }

}
