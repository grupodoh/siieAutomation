package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import methods.BrowserActions;
import methods.BrowserConfig;

import java.time.Duration;

public class LoginStepdefs {
    WebDriver driver;
    String url="https://seguridad.app.interedes.com.co/";
    String dirDriverChrome = "C:\\proyectos\\octubre\\siieAutomation\\webdrivers\\chromedriver.exe";
    String dirDriverFirefox = "C:\\proyectos\\octubre\\siieAutomation\\webdrivers\\geckodriver.exe";


    BrowserConfig config;
    BrowserActions actions;
    @Given("El usuario accede al inicio de sesion")
    public void elUsuarioAccedeAlInicioDeSesion() throws Exception {
//        config.OpenBrowserChrome();
//        config.MaximizeWindows();
//        config.UrlBase();

        System.setProperty("webdriver.chrome.driver", dirDriverChrome);
        driver = new ChromeDriver();
        Thread.sleep(3000);driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.get(url);
        Thread.sleep(5000);
    }

    @When("Ingresa las credenciales validas")
    public void ingresaLasCredencialesValidas() throws InterruptedException {
        driver.findElement(By.id("input-25")).sendKeys("7416");
        Thread.sleep(2000);
        driver.findElement(By.id("input-29")).sendKeys("7416");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/div/div/div/div/div[2]/div/div/form/div[4]")).click();

    }

    @Then("puede visualizar el dashboard del aplicativo")
    public void puedeVisualizarElDashboardDelAplicativo() throws Exception {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("/html/body/div/div/div/div/nav/div[1]/div/a[1]/div[2]/div")).isDisplayed();
        Thread.sleep(5000);
        driver.close();
    }

    @Given("El usuario no ingresa las credenciales")
    public void elUsuarioNoIngresaLasCredenciales() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", dirDriverChrome);
        driver = new ChromeDriver();
        Thread.sleep(3000);driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.get(url);
        Thread.sleep(5000);
        driver.findElement(By.id("input-25")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("input-29")).click();
        Thread.sleep(2000);
    }

    @When("Intentamos dar en el boton Ingresar")
    public void intentamosDarEnElBotonIngresar() throws InterruptedException {
        WebElement btnIngresar = driver.findElement(By.xpath("/html/body/div/div/div/div/div/div[2]/div/div/form/div[4]"));

        driver.findElement(By.xpath("/html/body/div/div/div/div/div/div[2]/div/div/form/div[4]")).click();
        Thread.sleep(2000);
        String dato = btnIngresar.getText();
        System.out.println(dato);

    }


    @Then("Se muestran todas las alertas")
    public void seMuestranTodasLasAlertas() throws InterruptedException {

        WebElement btnIngresar = driver.findElement(By.xpath("/html/body/div/div/div/div/div/div[2]/div/div/form/div[4]"));
        if (btnIngresar.isEnabled()) {
            System.out.println("El botón esta activo");
            btnIngresar.click();
        }else {
            driver.findElement(By.xpath("/html/body/div/div/div/div/div/div[2]/div/div/form/div[1]/div/div[2]/div/div/div")).isDisplayed();
            System.out.println("Se visualiza la alerta del campo Usuario");
            Thread.sleep(2000);
            driver.findElement(By.xpath("/html/body/div/div/div/div/div/div[2]/div/div/form/div[2]/div/div[2]/div/div/div")).isDisplayed();
            System.out.println("Se visualiza la alerta del campo Contraseña");
            Thread.sleep(2000);
            driver.close();
        }


    }
}
