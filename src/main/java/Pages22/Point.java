package Pages22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Point {

    int x;
    int y;


    //https://rahulshettyacademy.com/loginpagePractise/

    public void print()
    {
        String message="(username is rahulshettyacademy and Password is learning)";
        //بياخد input  بيقسم على أساسه
        String[]parts=message.replace("(","").replace(")","").split("and");
        String userNameParts[]=parts[0].split(" ");
        for(int i=0;i<userNameParts.length;i++)
            System.out.println(userNameParts[i]);
        String userName=userNameParts[2];

        String passwordParts[]=parts[1].split(" ");
        for(int i=0;i<passwordParts.length;i++)
            System.out.println(passwordParts[i]);
        String password=passwordParts[3];

        System.out.println("userName is : "+userName);
        System.out.println("password is : "+password);
        /*for (int i=0;i<parts.length;i++)
            System.out.println(parts[i]);*/

    }
    WebDriver driver;

    //@Test(groups = "Android")
    public void testMethod1()
    {
        System.out.println("Method1");
    }

    //@Test(groups = "Android")
    public void testMethod2()
    {
        System.out.println("Method2");
    }

    //@Test(groups = "IOS")
    public void testMethod3()
    {
        System.out.println("Method3");
    }

















    @BeforeMethod
    public  void setUp()
    {
        driver=new FirefoxDriver();
        driver.navigate().to("https://rahulshettyacademy.com/loginpagePractise/");
        driver.manage().window().maximize();

    }


    @Test
    public  void doActions() throws InterruptedException {
//"rahulshettyacademy"
        //"learning"
     //   driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        String[]data=spliting();
        driver.findElement(By.id("username")).sendKeys(data[0]);
        driver.findElement(By.name("password")).sendKeys(data[1]);
        //Thread.sleep(5000);
       List<WebElement> checkElements= driver.findElements(By.xpath("//span[@class='checkmark']"));
       checkElements.get(1).click();

        driver.findElement(By.id("okayBtn")).click();
        Thread.sleep(3000);
        //get dropdown
        WebElement listDrop=driver.findElement(By.cssSelector("[data-style='btn-info']"));



     //   WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
      //  wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(listDrop, By.tagName("option")));

        Select selevt1=new Select(listDrop);
       selevt1.selectByVisibleText("Teacher");



        driver.findElement(By.id("terms")).click();
        driver.findElement(By.id("signInBtn")).click();
      //  Thread.sleep(5000);






    }

    @AfterMethod
    public void closeDriver()
    {
        driver.quit();

    }

public  String[]  spliting()
{
    String message= driver.findElement(By.xpath("//*[@class='text-center text-white']")).getText();
    String[]parts=  message.replace(")","").split(" and ");
    String userName=parts[0].split(" ")[2];
    String password=parts[1].split(" ")[2];
    return new String[]{userName,password};
}

}
