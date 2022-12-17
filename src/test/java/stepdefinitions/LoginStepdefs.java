package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import methods.BrowserActions;
import methods.BrowserConfig;

import java.time.Duration;

public class LoginStepdefs {
    //WebDriver driver;

    BrowserConfig config = new BrowserConfig();
    BrowserActions actions = new BrowserActions();

    @BeforeClass
    @Given("El usuario accede al inicio de sesion")
    public void elUsuarioAccedeAlInicioDeSesion() throws Exception {
        config.OpenBrowserChrome();
        config.MaximizeWindows();
        config.UrlBase();
    }
    @When("el usuario restablece la contraseña")
    public void elUsuarioRestableceLaContraseña() throws InterruptedException {
        config.tiempoDeEspera("//a[@class='forgot-password']");
        config.clic("//a[@class='forgot-password']");
        config.tiempoDeEspera("//*[@id='app']/div[3]/div/div/div[1]/i");
        Thread.sleep(2000);
        config.clic("//div[@class='btn-cancel-changepassword']");
        Thread.sleep(2000);
        config.clic("(//div[@class='flex-close'])[2]");
    }


    @Given("Ingresa las credenciales {string} y {string}")
    public void ingresaLasCredenciales(String user, String pass) throws Exception {
        config.CredentialsUser("input-25", user);
        config.CredentialsPass("input-29", pass);
        config.BtnAcces("//*[@id='app']/div/div/div[2]/div/div/form/div[4]");
    }


    @Then("puede visualizar el dashboard del aplicativo")
    public void puedeVisualizarElDashboardDelAplicativo() throws Exception {
        config.tiempoDeEspera("/html/body/div/div/div/div/nav/div[1]/div/a[1]/div[2]/div");
       config.validateElementByText("/html/body/div/div/div/div/nav/div[1]/div/a[1]/div[2]/div", "Gestión operativa");
    }

    @Then("Cierra el navegador")
    public void cierraElNavegador() throws Exception {
        Thread.sleep(2000);
        config.CloseBrowser();
    }

    //------------------------------------------------------------------------------------------



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


    @And("Ingresa a programación")
    public void ingresaAProgramación() throws InterruptedException {
       config.tiempoDeEspera("//*[@id='app']/div[1]/main/div/div[2]/div/div[1]/div/div[2]/div/div[4]");
        config.accesToModule("//*[@id='app']/div[1]/main/div/div[2]/div/div[1]/div/div[2]/div/div[4]");
    }

    @Then("Se muestra la información")
    public void seMuestraLaInformación() {
    }


}
