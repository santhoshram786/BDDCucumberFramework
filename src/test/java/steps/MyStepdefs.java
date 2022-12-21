package steps;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepdefs {


    @Given("^user given a test$")
    public void userGivenATest() {
        System.out.println("Given");
    }

    @When("^user writes the ([^\"]*)$")
    public void userWritesThe(String str) throws Throwable {
        System.out.println("When printing the  "+str);
    }

    @Then("^test should pass$")
    public void testShouldPass() {
        System.out.println("Then");
    }

    @Given("^test scenrio outline$")
    public void testScenrioOutline() {
        System.out.println("Given otline");
    }

    @Then("^test is ([^\"]*) and ([^\"]*)$")
    public void test(String str1 ,String str2) throws Throwable {
        System.out.println("User1 is "+str1 +":"+str2);
    }

    @Given("^Run before every scenario$")
    public void runBeforeEveryScenario() {
        System.out.println("Before");
    }
}


