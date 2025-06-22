package WikiPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class logOutLink {


    public WebElement logOutEle(WebDriver dd)
    {
        return dd.findElement(By.xpath("//span[text()='Log out']"));
    }




    By menuItem=By.id("vector-user-links-dropdown-checkbox");

    //Method to view menu
    public  void clickMenuItems(WebDriver dd)
    {
        dd.findElement(menuItem).click();

    }
}
