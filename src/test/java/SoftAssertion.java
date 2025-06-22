import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion {
    LOginPage logginEles;
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

        logginEles =new LOginPage();
        HomePageElements h1pageElements=new HomePageElements();
    }

   public WebElement userNameEle()
    {

        //name if Element
        By userName=By.name("userName");
        //Locate WebElement
        WebElement userNameTxtBox= driver.findElement(userName);
       return userNameTxtBox ;
    }


    public void loginSteps1(String username,String password)
    {
        userNameEle().clear();
        //call function
      //  userNameEle().sendKeys("aa");
        userNameEle().sendKeys(username);

        logginEles.passwordPOM(driver).clear();
       // logginEles.passwordPOM(driver).sendKeys("123");
        logginEles.passwordPOM(driver).sendKeys(password);
        // driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
        logginEles.submitBtn(driver).click();
    }

    @Test
    public void validData()
    {


       logginEles.loginSteps(driver,"aa","123");

        //Assert that login succeed
        //get the message after loggedin
        String expectResult="Login Successfully";
        String actualResult= driver.findElement(logginEles.successLogin()).getText();
//** Soft Assertions

        SoftAssert assSoft=new SoftAssert();

        //First Assertion
        System.out.println("First Assertion");
        assSoft.assertEquals(actualResult.contains(expectResult),true);
        assSoft.assertTrue(actualResult.contains(expectResult));


      WebElement signOffButton=  driver.findElements(By.xpath("//a[@href='index.php']")).get(2);
     String signOffText= signOffButton.getText();
     System.out.println("SignOff is "+signOffText);

     //cssSelector   ("a[href=\"/loggout\"]]")

        //Second Assertion
        System.out.println("Second Assertion");
        assSoft.assertTrue(signOffButton.isDisplayed());

      //Third Assertion   Assert that url after login is --
        System.out.println("Third Assertion");
        assSoft.assertEquals(driver.getCurrentUrl(),"https://demo.guru99.com/test/newtours/login_sucess.php");
        assSoft.assertAll();


    }

    @Test
    public void inValidData()
    {

//Enter usename using pom design passtern

//Enter password using POM

        //driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
//Press Submit using pom
        logginEles.loginSteps(driver,"aaInvalid","123Invalid");


        String expectedResult="Enter your userName and password correct";
        String actualResult=driver.findElement(logginEles.errorMessage()).getText();
        System.out.println("actualResult is "+actualResult);

        SoftAssert ass2Soft=new SoftAssert();
        System.out.println("First assertion");
        ass2Soft.assertTrue(actualResult.contains(expectedResult),"Error Message: Text not matched");

        //Second Assert
        System.out.println("Second assertion");
        ass2Soft.assertFalse(logginEles.submitBtn(driver).isDisplayed(),"Web Element is displayed");

        ass2Soft.assertAll();



    }

    @AfterTest
    public  void closeDriver()throws InterruptedException
    {
        driver.quit();

    }






}
