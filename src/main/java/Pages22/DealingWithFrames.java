package Pages22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DealingWithFrames {



    WebDriver driver;
    @BeforeMethod
    public  void setUp()
    {
        driver=new FirefoxDriver();
        driver.navigate().to("https://demo.guru99.com/test/newtours/");
        driver.manage().window().maximize();
    }

    @Test
    public void doAction() throws InterruptedException {
        Actions action1=new Actions(driver);
        Thread.sleep(3000);
        //List<WebElement> links=driver.findElements(By.xpath("//a[@href='index.php']"));
         //WebElement  linkHomeElement=links.get(0);
        WebElement linkHomeElement=driver.findElement(By.linkText("Home"));
         Thread.sleep(4000);
        Action mouseOverHome=action1.moveToElement(linkHomeElement).build();
        mouseOverHome.perform();
        Thread.sleep(4000);
    }

    @AfterMethod
    public  void close()
    {
        driver.quit();
    }
}
