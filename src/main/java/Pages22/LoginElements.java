package Pages22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.security.PublicKey;

public class LoginElements {

    public WebElement usernamePOM(WebDriver driver)
    {

        //locate elememt username
        By username=By.name("userName");
        WebElement usernameEle=driver.findElement(username);
        return  usernameEle;

    }


    public WebElement passwordPOM(WebDriver dr)
    {
        By password=By.name("password");
        return dr.findElement(password);
    }

    public WebElement clickbtnPom(WebDriver dd)
    {

        return dd.findElement(By.name("submit"));
    }


    public  WebElement successText(WebDriver dt)
    {
       return dt.findElement(By.xpath("//h3"));
    }


    public By failedLoginText()
    {
        return (By.xpath("//span"));
    }

   public By  sucessMessagePOM()
    {
        return (By.xpath("//h3"));
    }





}
