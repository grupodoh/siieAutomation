package methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserConfig {
    WebDriver driver;

    String url="https://seguridad.app.interedes.com.co/";

    String dirDriverChrome = "C:\\proyectos\\octubre\\siieAutomation\\webdrivers\\chromedriver.exe";

    String dirDriverFirefox = "C:\\proyectos\\octubre\\siieAutomation\\webdrivers\\geckodriver.exe";



    public void OpenBrowserChrome() throws Exception{
        System.setProperty("webdriver.chrome.driver", dirDriverChrome);
        driver = new ChromeDriver();
        Thread.sleep(3000);
    }

    public void OpenBrowserFirefox() throws Exception{
        System.setProperty("webdriver.gecko.driver", dirDriverFirefox);
        driver = new FirefoxDriver();
        Thread.sleep(3000);
    }

    public void MaximizeWindows() throws Exception{
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }
    public void UrlBase() throws Exception{
        driver.get(url);
        Thread.sleep(5000);
    }

    public  void  CloseBrowser() throws  Exception{
        Thread.sleep(3000);
        driver.close();
    }

}
