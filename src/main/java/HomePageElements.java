import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePageElements {


    public By RegisterLink()
    {
        By registerLk= By.xpath("//a[@href='register.php']");
        return registerLk;
    }





    public WebElement loginnLink(WebDriver driver)
    {

        By loginnLk= By.xpath("//a[@href='login.php']");
        return driver.findElement(loginnLk);


    }




}
