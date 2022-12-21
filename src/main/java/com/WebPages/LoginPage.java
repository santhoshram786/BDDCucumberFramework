package com.WebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//*[@name=\"username\"]")
    private WebElement username;

    public WebElement username()
    {
        return username;
    }

    @FindBy(xpath="//*[@name='password']")
    private WebElement password;

    public WebElement password()
    {
        return password;
    }

    @FindBy(xpath="//*[@type='submit']")
    private WebElement submit;

    public WebElement submit()
    {
        return submit;
    }

    @FindBy(xpath="//*[@class=\"orangehrm-dashboard-widget-name\"]//child::p[text()='Time at Work']")
    private WebElement welcome_text;

    public WebElement welcome_text()
    {
        return welcome_text;
    }




}
