package Pages22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class capClass {

    WebDriver driver;
    @BeforeMethod
    public  void setUp()
    {
        //DesiredCapabilities cab=new DesiredCapabilities();
        //cab.setCapability(CapabilityType.BROWSER_NAME,"chrome");
        //cab.setCapability(CapabilityType.BROWSER_VERSION,"129");


        driver=new FirefoxDriver();



        //System.setProperty("webdriver.chrome.driver","D:\\AnharFiles\\chrome\\chromedriver.exe");
        driver.navigate().to("https://rahulshettyacademy.com/loginpagePractise/");
        driver.manage().window().maximize();

    }


    @Test
    public void doAct() throws InterruptedException {

     WebElement pass= driver.findElement(By.id("password"));
             pass.sendKeys("learning");
       WebElement user= driver.findElement(with(By.tagName("input")).above(pass));
       user.sendKeys("reahual");
       Thread.sleep(10000);
    }

    @AfterMethod
    public void close()
    {
        driver.quit();

    }

}
