package methods;

import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class BrowserConfig {
    WebDriver driver;

    String url="https://seguridad.app.interedes.com.co/";

    String dirDriverChrome = "C:\\proyectos\\octubre\\siieAutomation\\webdrivers\\chromedriver.exe";

    String dirDriverFirefox = "C:\\proyectos\\octubre\\siieAutomation\\webdrivers\\geckodriver.exe";


    public WebDriver OpenBrowserChrome() throws Exception{
        System.setProperty("webdriver.chrome.driver", dirDriverChrome);
        driver = new ChromeDriver();
        Thread.sleep(3000);
        return driver;
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
        Thread.sleep(1000);
        driver.close();
    }

    public void CredentialsUser(String cssUser, String txtUser) {
        WebElement element = driver.findElement(By.id(cssUser));
        element.click();
        element.sendKeys(txtUser);
    }

    public void CredentialsPass(String cssPass, String txtPass) {
        WebElement element = driver.findElement(By.id(cssPass));
        element.click();
        element.sendKeys(txtPass);
    }

    public void BtnAcces(String cssBtnAcces) {
        WebElement element = driver.findElement(By.xpath(cssBtnAcces));
        element.click();
    }

    public void validateElementByText(String cssElement, String varAssert) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(cssElement))));
        WebElement modulo = driver.findElement(By.xpath(cssElement));
        assertEquals(modulo.getText(), varAssert);
        System.out.println("Se encontro el elemento y se validó la existencia");
        Thread.sleep(2000);
    }

/*    public  void CleanTextBox(String clearElem) throws InterruptedException {
       WebElement textBox = driver.findElement(By.id(clearElem));
       textBox.click();
       Thread.sleep(1000);
       String user = textBox.getText();
       System.out.println(user);
       Thread.sleep(1000);
    }*/

    public void clic(String element){
        WebElement menu =driver.findElement(By.xpath(element));
        menu.click();

    }

    public void accesToModule(String cssModule) throws InterruptedException{
        driver.findElement(By.xpath(cssModule)).click();
        Thread.sleep(2000);
    }



}
