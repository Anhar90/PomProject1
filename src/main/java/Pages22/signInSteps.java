package Pages22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class signInSteps {

    public void loginStepsPom(WebDriver driver,String userName, String password)
    {
        LoginElements loginEle=new LoginElements();
        loginEle.usernamePOM(driver).clear();
        loginEle.usernamePOM(driver).sendKeys(userName);


        // driver.findElement(By.name("password")).sendKeys("123");
        loginEle.passwordPOM(driver).clear();
        loginEle.passwordPOM(driver).sendKeys(password);

        driver.findElement(By.name("submit")).click();

    }


}
