package stepdefinitions;
import methods.BrowserActions;
import methods.BrowserConfig;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.BeforeClass;

public class MenuStepdefs {

    BrowserConfig config = new BrowserConfig();
    BrowserActions actions = new BrowserActions();

    @BeforeClass
    @Given("El usuario va al inicio de sesion")
    public void elUsuarioVaAlInicioDeSesion() throws Exception {
        config.OpenBrowserChrome();
        config.MaximizeWindows();
        config.UrlBase();
    }

    @And("Ingresa credenciales {string} y {string}")
    public void ingresaCredencialesY(String user, String pass) {
        config.CredentialsUser("input-25", user);
        config.CredentialsPass("input-29", pass);
        config.BtnAcces("//*[@id='app']/div/div/div[2]/div/div/form/div[4]");
    }

    @When("accede al módulo Gestión Operativa")
    public void accedeAlMóduloGestiónOperativa() throws InterruptedException {
        config.tiempoDeEspera("/html/body/div/div/div/div/nav/div[1]/div/a[1]/div[2]/div");
        config.accesToModule("/html/body/div/div/div/div/nav/div[1]/div/a[1]/div[2]/div");
        config.tiempoDeEspera("//*[@id='app']/div[1]/main/div/div[2]/div/div[1]/div/div[2]/div/div[3]");
        config.validateElementByText("//*[@id='app']/div[1]/main/div/div[2]/div/div[1]/div/div[2]/div/div[3]", "Detalle");
    }

    @And("accede al módulo Parametrización")
    public void accedeAlMóduloParametrización() throws InterruptedException {
        config.tiempoDeEspera("//*[@id='app']/div/nav/div[1]/div/a[2]/div[2]/div");
        config.accesToModule("//*[@id='app']/div/nav/div[1]/div/a[2]/div[2]/div");
        config.tiempoDeEspera("/html/body/div/div/div/div/main/div/div[2]/div/div[1]/div/div[2]/div/div[3]");
        config.validateElementByText("/html/body/div/div/div/div/main/div/div[2]/div/div[1]/div/div[2]/div/div[3]","Formularios dinámicos");
        Thread.sleep(1000);
        
    }

    @And("accede al módulo Seguridad")
    public void accedeAlMóduloSeguridad() throws InterruptedException {
        config.tiempoDeEspera("(//div[@class='v-list-item__content'])[3]");
        config.accesToModule("(//div[@class='v-list-item__content'])[3]");
        config.tiempoDeEspera("//div/div/div[@class='v-tab v-tab--active']");
        config.validateElementByText("//div/div/div[@class='v-tab v-tab--active']","Usuarios");
        Thread.sleep(1000);
    }

    @And("accede al módulo Administración")
    public void accedeAlMóduloAdministración() throws InterruptedException {
        config.tiempoDeEspera("(//div[@class='v-list-item__content'])[4]");
        config.clic("(//div[@class='v-list-item__content'])[4]");
        config.tiempoDeEspera("(//div[@tabindex='0'])[4]");
        //config.validateElementByText("(//div[@tabindex='0'])[5]","Reportes");
    }

    @Given("Cierra sesión en el aplicativo")
    public void cierraSesiónEnElAplicativo() throws InterruptedException {
        config.tiempoDeEspera("//div/div[@class='mx-2']");
        config.clic("//div/div[@class='mx-2']");
        config.tiempoDeEspera("//div/div/button[@type='button']");
        config.clic("//div/div/button[@type='button']");

    }


}
