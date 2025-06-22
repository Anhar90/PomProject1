package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home {


    WebDriver dr1;
    public Home(WebDriver dr2)
    {
        this.dr1=dr2;
    }
    By signonBtnElement= By.xpath("//a[@href='login.php']");

    public WebElement signonBtn()
    {
       return  dr1.findElement(signonBtnElement);

    }

    public  void clickSignon()
    {
        signonBtn().click();

    }




}
