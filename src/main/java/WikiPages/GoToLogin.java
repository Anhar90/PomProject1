package WikiPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoToLogin {

    WebDriver dd;
    public  GoToLogin(WebDriver dt)
    {
     this.dd=dt;
    }



   public WebElement clickLink(WebDriver driver)
   {
       return driver.findElement(By.linkText("Log in"));

   }


   By clickSign=By.linkText("Log in");

   //method to click login link
    public void clickLoginFn()
    {
        dd.findElement(clickSign).click();
    }






}
