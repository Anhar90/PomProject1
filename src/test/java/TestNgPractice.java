import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgPractice {



    SoftAssertion ss=new SoftAssertion();
    HomePageElements elements=new HomePageElements();
    WebDriver dr;

    @Test
    public  void  VerifyHometitle()throws  InterruptedException
    {

        ss.openBrowser();
        WebDriver dr2=ss.driver;
       //String expected="\"Welcome: Mercury Tours\"";
        String expected="Welcome: Mercury Tours";
       //Expected :"Welcome: Mercury Tours"
       String actualResult = dr.getTitle();
       Assert.assertEquals(actualResult,expected,"Error Home Page Title");


    }



    public  void clickSignInn()
    {
        WebDriver dr2=ss.driver;

        WebElement signonEl=elements.loginnLink(dr2);
        signonEl.click();

    }
    @Test
    public  void verifySignnIN()
    {

        clickSignInn();
        String expected="Sign-on : Mercury Tours";
        String actual=dr.getTitle();
        Assert.assertEquals(actual,expected,"Error Sign-on page Title");
    }


    @AfterTest
    public void closeBrowser()throws InterruptedException
    {
        ss.closeDriver();

    }





}
