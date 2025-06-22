package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
    WebDriver dr1;

    public Login(WebDriver dr2)
    {
        this.dr1=dr2;

    }


    By userName= By.name("userName");

    public void enterUserName()
    {
        dr1.findElement(userName).sendKeys("aaa");
    }


    By password= By.name("userName");

    public void enterPassword()
    {
        dr1.findElement(password).sendKeys("123");
    }

    By loginBtn=By.name("submit");

    public void clickLogin()
    {
        dr1.findElement(loginBtn).click();
    }




}
