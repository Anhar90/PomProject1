package WikiTestCases;

import WikiPages.GoToLogin;
import WikiPages.loginCred;
import WikiPages.logOutLink;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class GoToSignIn {

  static  WebDriver driver;
    GoToLogin goLogin;
    loginCred logCred;
    logOutLink logOut1;
    @BeforeTest
    public  void setUp()
    {
        driver=new FirefoxDriver();
        driver.navigate().to("https://en.wikipedia.org/wiki/Wikipedia:About");
        driver.manage().window().maximize();
         goLogin=new GoToLogin(driver);
        logCred=new loginCred();
        logOut1=new logOutLink();
    }


    @Test
    public void clickLoginLink() throws InterruptedException {

        goLogin.clickLoginFn();
       // Thread.sleep(3000);

    }

    @Test(dependsOnMethods = "clickLoginLink")
    public void signValid()
    {
       // driver.navigate().to("")
        logCred.userEle(driver).clear();
        logCred.userEle(driver).sendKeys("Anhar123");
        logCred.passEle(driver).clear();
        logCred.passEle(driver).sendKeys("Dhvflud558");
        logCred.clickEle(driver).click();
    }

  /*  @Test(dependsOnMethods = "signValid")

    public void checkAssert()
    {

        System.out.println(" value is  : "+logCred.expectedValue(driver));
        String expected="Anhar123";
        Assert.assertEquals(expected,logCred.expectedValue(driver)," mesage of the sassertion");


    }
*/


    /*@Test(dependsOnMethods = "clickLoginLink")
    public void signInvalid()
    {
        logCred.signSteps(driver,"nona","1234");
    }
*/
    @Test(dependsOnMethods ="signValid")
    public  void logOut() throws InterruptedException {
        logOut1.clickMenuItems(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",logOut1.logOutEle(driver));
        logOut1.logOutEle(driver).click();
        Thread.sleep(3000);

    }

    public void search()
    {

    }


    @AfterTest
    public  void close()
    {
        driver.quit();

    }
}
