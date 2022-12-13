package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import methods.BrowserActions;
import methods.BrowserConfig;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class LoginStepdefs {
    WebDriver driver;

    BrowserConfig config = new BrowserConfig();
    BrowserActions actions = new BrowserActions();

    @Given("El usuario accede al inicio de sesion")
    public void elUsuarioAccedeAlInicioDeSesion() throws Exception {
        config.OpenBrowserChrome();
        config.MaximizeWindows();
        config.UrlBase();
    }

    @When("Ingresa las credenciales {string} y {string}")
    public void ingresaLasCredenciales(String user, String pass) throws Exception {
        config.CredentialsUser("input-25", user);
        Thread.sleep(1000);
        config.CredentialsPass("input-29", pass);
        Thread.sleep(1000);
        config.BtnAcces("//*[@id='app']/div/div/div[2]/div/div/form/div[4]");
    }

    @Then("puede visualizar el dashboard del aplicativo")
    public void puedeVisualizarElDashboardDelAplicativo() throws Exception {
        Thread.sleep(2000);
       config.validateElementByText("/html/body/div/div/div/div/nav/div[1]/div/a[1]/div[2]/div", "Gestión operativa");
    }

    @Given("El usuario no ingresa las credenciales")
    public void elUsuarioNoIngresaLasCredenciales() throws Exception {
        config.CredentialsUser("input-25", "");
        Thread.sleep(1000);
        config.CredentialsPass("input-29", "");
        Thread.sleep(1000);
    }

    @When("Intentamos dar en el boton Ingresar")
    public void intentamosDarEnElBotonIngresar() throws InterruptedException {
        config.BtnAcces("//*[@id='app']/div/div/div[2]/div/div/form/div[4]");
        Thread.sleep(2000);
    }


    @Then("Se muestran todas las alertas")
    public void seMuestranTodasLasAlertas() throws Exception {
        config.validateElementByText("/html/body/div/div/div/div/div/div[2]/div/div/form/div[1]/div/div[2]/div/div/div","Usuario es requerido.");//
        Thread.sleep(1000);//
        Thread.sleep(1000);
        config.validateElementByText("/html/body/div/div/div/div/div/div[2]/div/div/form/div[2]/div/div[2]/div/div/div", "Contraseña es requerido");
        Thread.sleep(1000);
        Thread.sleep(1000);
    }


    @And("Las credenciales son invalidas visualiza una alerta,luego introdice correctamente las credenciales")
    public void lasCredencialesSonInvalidasVisualizaUnaAlertaLuegoIntrodiceCorrectamenteLasCredenciales() throws InterruptedException {
        Thread.sleep(1000);
        config.validateElementByText("//*[@id='app']/div[3]/div/div/div[2]","Intentar de nuevo");
        Thread.sleep(3000);
        config.BtnAcces("//*[@id='app']/div[3]/div/div/div[2]");
        Thread.sleep(1000);
      /*  config.CleanTextBox("input-25");
        Thread.sleep(1000);
        config.CleanTextBox("input-29");*/
    }


    @When("el usuario accede al módulo Gestión Operativa")
    public void elUsuarioAccedeAlMóduloGestiónOperativa() throws InterruptedException {
        Thread.sleep(2000);
        config.accesToModule("/html/body/div/div/div/div/nav/div[1]/div/a[1]/div[2]/div");
        Thread.sleep(2000);
        config.validateElementByText("//*[@id='app']/div[1]/main/div/div[2]/div/div[1]/div/div[2]/div/div[3]", "Detalle");
    }

    @Then("Cierra el navegador")
    public void cierraElNavegador() throws Exception {
        Thread.sleep(2000);
        config.CloseBrowser();
    }

    @And("el usuario accede al módulo Indicadores")
    public void ElUsuarioAccedeAlMóduloIndicadores() throws InterruptedException {
        Thread.sleep(2000);
        config.accesToModule("/html/body/div/div/div/div/nav/div[1]/div/a[2]/div[2]");
        Thread.sleep(2000);
        config.validateElementByText("/html/body/div/div/div/div/main/div/div[2]/section/div/div[1]/div/h4","Visitas realizadas");
    }

    @And("el usuario accede al módulo Parametrización")
    public void elUsuarioAccedeAlMóduloParametrización() throws InterruptedException {
        Thread.sleep(2000);
        config.accesToModule("//*[@id='app']/div/nav/div[1]/div/a[3]/div[2]");
        Thread.sleep(2000);
        config.validateElementByText("/html/body/div/div/div/div/main/div/div[2]/div/div[1]/div/div[2]/div/div[3]","Formularios dinámicos");
        Thread.sleep(1000);
    }

    @And("el usuario accede al módulo Seguridad")
    public void elUsuarioAccedeAlMóduloSeguridad() throws InterruptedException {
        Thread.sleep(2000);
        config.accesToModule("/html/body/div/div/div/div/nav/div[1]/div/a[4]/div[2]");
        Thread.sleep(2000);
        config.validateElementByText("/html/body/div/div/div/div[1]/main/div/div[2]/div/div[1]/div/div[2]/div/div[2]","Usuarios");
        Thread.sleep(1000);
    }

    @And("el usuario accede al módulo Administración")
    public void elUsuarioAccedeAlMóduloAdministración() throws InterruptedException {
        Thread.sleep(2000);
        config.accesToModule("/html/body/div/div/div/div/nav/div[1]/div/a[5]/div[2]");
        Thread.sleep(2000);
        config.validateElementByText("/html/body/div/div/div/div/main/div/div[2]/div/div/div[1]/div/div[2]/div/div[2]","Permisos");
        Thread.sleep(1000);
    }
}
