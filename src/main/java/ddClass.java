import com.sun.jdi.PathSearchingVirtualMachine;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class ddClass {
//@Test
  //  public void Display()
  //  {
     //   String title="Thank you for Loggin";
      //  String actual="Loggin";
     //   SoftAssert soft1=new SoftAssert();
        //soft1.assertEquals(actual,title);
      //  soft1.assertAll();

     //   System.out.println("Logged In Sucessfully");
  //  }

   // @AfterMethod
   // public void print()
    //{
     //   System.out.println("after method");
    //}

 //   @Test
   // public void Show(){
  //  System.out.println("before Test");
  //  }


    /*@Test
    public void  testVegetables()
    {
        System.setProperty("webdriver.gecko.driver","D:\\AnharFiles\\Sales invoice\\IdeaProjects\\oneProject\\firefoxdriver\\geckodriver.exe");



   }*/



   /* public static void main( String args[]) throws InterruptedException{




         //Thread.sleep(3000);
        //Enter Valid UserNAme and Password (positive)



         //Enter Invalid Usename & Password (Negative)

        String expectedResult="Login Successfull";
        System.out.println("name of h3 :"+actualResult);

        SoftAssert s11=new SoftAssert();
        //s11.assertEquals(actualResult,expectedResult);
        s11.assertEquals(actualResult,expectedResult,"Message");
        s11.assertAll("not");
       String bText= driver.findElement(By.cssSelector("b")).getText();
       System.out.println("b is :"+bText);
    }*/

WebDriver driver=null;
    @BeforeTest
    public void openBrowser() throws InterruptedException{

        System.setProperty("webdriver.gecko.driver","D:\\AnharFiles\\Sales invoice\\IdeaProjects\\oneProject\\firefoxdriver\\geckodriver.exe");
        // System.getProperty("webdriver.chrome.driver","D:\\AnharFiles\\chrome\\chromedriver.exe");
        driver=new FirefoxDriver();
        WebDriverWait myWait;
        //  WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://demo.guru99.com/test/newtours/");
        driver.manage().window().maximize();
    }

    @Test
    public void validData()
    {
        WebElement usernameEle= driver.findElement(By.name("userName"));
        usernameEle.clear();
        driver.findElement(By.name("userName")).sendKeys("aa");
        driver.findElement(By.name("password")).sendKeys("123");
       // driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
        driver.findElement(By.name("submit")).click();
        //Assert that login succeed
        //get the message after loggedin
        String lt="LoginexpectResu Successfull";
        String actualResult= driver.findElement(By.cssSelector("h3")).getText();
//** Hard Assertions
        //First Assertion
        System.out.println("First Assertion");
        Assert.assertEquals(actualResult.contains(lt),true);
        Assert.assertTrue(actualResult.contains(lt));


      WebElement signOffButton=  driver.findElements(By.xpath("//a[@href='index.php']")).get(2);
     String signOffText= signOffButton.getText();
     System.out.println("SignOff is "+signOffText);

     //cssSelector   ("a[href=\"/loggout\"]]")

        //Second Assertion
        System.out.println("Second Assertion");
      Assert.assertTrue(signOffButton.isDisplayed());

      //Third Assertion   Assert that url after login is --
        System.out.println("Third Assertion");
      Assert.assertEquals(driver.getCurrentUrl(),"https://demo.guru99.com/test/newtours/login_sucess.php");


    }

    @Test
    public void inValidData()
    {
        WebElement usernameEle2= driver.findElement(By.name("userName"));
        usernameEle2.clear();
        driver.findElement(By.name("userName")).sendKeys("aaInvalod");
        driver.findElement(By.name("password")).sendKeys("123Invalid");
        //driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
        driver.findElement(By.name("submit")).click();
        String expectedResult="Enter your userName and password correct!12";
        String actualResult=driver.findElement(By.xpath("//td[@width='112']//span")).getText();
        System.out.println("actualResult is "+actualResult);
        Assert.assertTrue(actualResult.contains(expectedResult),"Error Message: Text not matched");

    }

    @AfterTest
    public  void closeDriver()throws InterruptedException
    {
        driver.quit();

    }






}
