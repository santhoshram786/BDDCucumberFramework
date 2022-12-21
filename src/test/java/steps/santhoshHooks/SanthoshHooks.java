package steps.santhoshHooks;


import io.cucumber.java.*;

public class SanthoshHooks {
    @Before("@Dummy")
    public void getScenario(Scenario sc)
    {
        System.out.println("Scenario name is:"+sc.getName());
    }

    @Before("@Dummy")
    public void getScenarioOrder1()
    {
        System.out.println("Scenario order 1");
    }
    @Before("@Dummy")
    public void getScenarioOrder2()
    {
        System.out.println("Scenario order 2");
    }

    @BeforeStep("@Dummy")
    public void runBeforeEveryStep()
    {
        System.out.println("Follow me");
    }


    @AfterStep("@Dummy")
    public void runAfterEveryStep()
    {
        System.out.println("Bye bye");
    }

    @After("@Dummy")
    public void afterScenario1()
    {
        System.out.println("Scenario is done in order 1");
    }
    @After("@Dummy")
    public void afterScenario2()
    {
        System.out.println("Scenario is done in order 2");
    }

}
