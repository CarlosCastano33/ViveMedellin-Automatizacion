package co.edu.udea.vivemedellin.screen.stepdefinitions;

import co.edu.udea.vivemedellin.screen.tasks.*;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;

public class StepDefinition {

    public final Actor usuario = Actor.named("usuario");

    @Before
    public void config(){
        WebDriver driver = Serenity.getDriver(); // deja que serenity lo gestione
        usuario.can(BrowseTheWeb.with(driver));
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("que el usuario está en la pantalla de inicio de sesión")
    public void abrirViveMedellin() {
        usuario.attemptsTo(Abrir.viveMedellin());
    }

    @When("intenta iniciar sesión con credenciales válidas")
    public void iniciarSesionConCredencialesValidas() {
        usuario.attemptsTo(IniciarCon.credencialesValidas());
    }

    @When("intenta iniciar sesión con credenciales inválidas")
    public void iniciarSesionConCredencialesInvalidas() {
        usuario.attemptsTo(IniciarCon.credencialesInvalidas());
    }

}
