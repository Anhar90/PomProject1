package TestCases;

import Pages.Home;
import Pages.Login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomeTestCase {

    public static WebDriver driver;
    Login signOn;
    Home ho1;


    @BeforeTest
    public void openDriver()
    {
        System.setProperty("webdriver.gecko.driver","D:\\AnharFiles\\Sales invoice\\IdeaProjects\\oneProject\\firefoxdriver\\geckodriver.exe");
        // System.getProperty("webdriver.chrome.driver","D:\\AnharFiles\\chrome\\chromedriver.exe");
        driver=new FirefoxDriver();
        WebDriverWait myWait;
        //  WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://demo.guru99.com/test/newtours/");
        driver.manage().window().maximize();
         signOn=new Login(driver);
         ho1=new Home(driver);



    }
    @Test
    public  void clickSigonBtn()
    {

        ho1.clickSignon();
    }
@Test
    public  void validData()
    {

        signOn.enterUserName();
        signOn.enterUserName();
        signOn.clickLogin();

        String expected="Login";
        String actual="Login";
        Assert.assertEquals(actual,expected,"Login Assertion");



    }
    @AfterTest
    public void close()
    {
        driver.quit();

    }


}

