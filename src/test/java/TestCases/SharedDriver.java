package TestCases;

import Pages.Home;
import Pages.Login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SharedDriver {

    WebDriver dr1;
    public SharedDriver(WebDriver dr2)
    {
        this.dr1=dr2;

    }

    public void openBrowser()
    {
        System.setProperty("webdriver.gecko.driver","D:\\AnharFiles\\Sales invoice\\IdeaProjects\\oneProject\\firefoxdriver\\geckodriver.exe");
        // System.getProperty("webdriver.chrome.driver","D:\\AnharFiles\\chrome\\chromedriver.exe");
        dr1=new FirefoxDriver();
        Home h1=new Home(dr1);

        Login signOn=new Login(dr1);
    }
}
