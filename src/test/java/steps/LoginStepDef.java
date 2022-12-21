package steps;

import com.WebPages.LoginPage;
import com.factory.PropertyFactory;
import com.factory.WebDriverFactory;
import com.factory.WebDriverFactoryParallel;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import java.util.Properties;


public class LoginStepDef{


    private LoginPage loginPage=new LoginPage(WebDriverFactory.getDriver());
    Properties prop= PropertyFactory.getProperty();

    @Given("User is on Home page")
    public void userIsOnHomePageInBrowser() {

        WebDriverFactory.getDriver().get(prop.getProperty("url"));

    }

    @When("User enters username as {string}")
    public void userEntersUsernameAs(String userName) {

        loginPage.username().sendKeys(userName);

        
    }

    @And("User enters password as {string}")
    public void userEntersPasswordAs(String passWord) {


       loginPage.password().sendKeys(passWord);
       loginPage.submit().click();
        
    }

    @Then("User should be able to login sucessfully")
    public void userShouldBeAbleToLoginSucessfully() {
        String AdminText = loginPage.welcome_text().getText();
        System.out.println("AdminText :" + AdminText);
        Assert.assertTrue(AdminText.contains("Time"));

    }
}
