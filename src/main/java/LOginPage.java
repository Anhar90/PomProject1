import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LOginPage {


    public WebElement userNamePOM(WebDriver driver )
    {
        //name if Element
        By userName=By.name("userName");
        //Locate WebElement
        WebElement userNameTxtBox= driver.findElement(userName);
        return userNameTxtBox ;
    }

    public WebElement passwordPOM(WebDriver driver)
    {
        By password=By.name("password");
        WebElement passwordTxtBox=driver.findElement(password);
        return passwordTxtBox;
    }

    public  WebElement submitBtn(WebDriver driver)
    {

        return  driver.findElement(By.name("submit"));

    }

    public  By errorMessage()
    {

        return  By.xpath("//td[@width='112']//span");

    }


    public  By successLogin()
    {
        return  By.cssSelector("h3");
    }



    //create method for login
    public void loginSteps(WebDriver driver,String userName,String password)
    {

        userNamePOM(driver).clear();
        userNamePOM(driver).sendKeys(userName);

        passwordPOM(driver).clear();
        passwordPOM(driver).sendKeys(password);
        submitBtn(driver).click();
    }


}
