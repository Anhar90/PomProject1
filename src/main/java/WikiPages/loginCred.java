package WikiPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginCred {



    public WebElement userEle(WebDriver dr)
    {
        WebElement username=dr.findElement(By.id("wpName1"));
        return  username;
    }

    public WebElement passEle(WebDriver dd)
    {
        return dd.findElement(By.id("wpPassword1"));

    }

    public WebElement clickEle(WebDriver dt)
    {
        return  dt.findElement(By.id("wpLoginAttempt"));
    }

    //method to signIn
    public void signSteps(WebDriver d,String userValue,String passValue)
    {
        userEle(d).clear();
        userEle(d).sendKeys(userValue);
        passEle(d).clear();
        passEle(d).sendKeys(passValue);
        clickEle(d).click();


    }



    By successMessage=By.xpath("//*[@class='new']");
   // By successMessage=By.linkText("Anhar123");
    //method to return text
    public String expectedValue(WebDriver dd)
    {
        return dd.findElements(successMessage).get(0).getText();
    }

}
