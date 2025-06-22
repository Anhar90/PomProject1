package Pages22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class LoginPage2 {


     public   WebDriver driver;
    LoginElements loginEle;
    signInSteps sign1;


    @BeforeTest
    public  void openBrowser2()
    {
      // System.setProperty("webdriver.gecko.driver","D:\\AnharFiles\\Sales invoice\\IdeaProjects\\oneProject\\firefoxdriver\\geckodriver.exe") ;
       driver=new FirefoxDriver();
       driver.navigate().to(" https://demo.guru99.com/test/newtours/");
       driver.manage().window().maximize();
        loginEle=new LoginElements();
        sign1=new signInSteps();
    }

     public WebElement usernameEle1()
     {

         //locate elememt username
         By username=By.name("userName");
         WebElement usernameEle=driver.findElement(username);
         return  usernameEle;

     }

     public void loginSteps(String userName,String password)
     {
         loginEle.usernamePOM(driver).clear();
         loginEle.usernamePOM(driver).sendKeys(userName);


         // driver.findElement(By.name("password")).sendKeys("123");
         loginEle.passwordPOM(driver).clear();
         loginEle.passwordPOM(driver).sendKeys(password);

         driver.findElement(By.name("submit")).click();

     }

//This is the test cases
    @Test
    public void validData()
    {
       // driver.navigate().to(" https://demo.guru99.com/test/newtours/");
         //loginEle=new LoginElements();
        //TestPageElements tLogEle=new TestPageElements();
        sign1.loginStepsPom(driver,"Test","123");



       // String actualResult=  driver.findElement(By.xpath("//h3")).getText();
       WebElement succText= loginEle.successText(driver);
       String actualResult=succText.getText();
        System.out.println("text is "+actualResult);

        //assertion
        Assert.assertEquals(actualResult,"Login Successfully");


    }

    @Test
    public void inValidData()
    {


        //TestPageElements tLogEle=new TestPageElements();
        sign1.loginStepsPom(driver,"123","123test");

        String actualResult=driver.findElement(loginEle.failedLoginText()).getText();

        System.out.println("text in invalid data is "+actualResult);

        //assertion
       // Assert.assertEquals(actualResult,"Login Successfully");



    }


    @AfterTest
    public void closeBrowser2()
    {
        driver.quit();
    }







    }

