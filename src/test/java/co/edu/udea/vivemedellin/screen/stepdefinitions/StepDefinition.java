package co.edu.udea.vivemedellin.screen.stepdefinitions;

import co.edu.udea.vivemedellin.screen.questions.ComentarioRechazado;
import co.edu.udea.vivemedellin.screen.questions.RespuestaRechazada;
import co.edu.udea.vivemedellin.screen.questions.UsuarioAutenticado;
import co.edu.udea.vivemedellin.screen.questions.UsuarioNoAutenticado;
import co.edu.udea.vivemedellin.screen.tasks.*;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;
import static org.hamcrest.Matchers.equalTo;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;


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

    @Then("el acceso es concedido y es redirigido a la página principal")
    public void accesoConcedido() {
        System.out.println(UsuarioAutenticado.value().answeredBy(usuario));
        usuario.should(seeThat(UsuarioAutenticado.value(), equalTo("CC")));
        usuario.attemptsTo(Cerrar.sesion());
    }

    @When("intenta iniciar sesión con credenciales inválidas")
    public void iniciarSesionConCredencialesInvalidas() {
        usuario.attemptsTo(IniciarCon.credencialesInvalidas());
    }

    @Then ("el sistema rechaza el intento de acceso")
    public void accesoRechazado() {
        usuario.should(seeThat(UsuarioNoAutenticado.value(), equalTo("Email o contraseña incorrectos")));
    }

    @And ("se encuentra visualizando un comentario en un evento")
    public void abrirEvento(){
        usuario.attemptsTo(Abrir.evento());
    }

    @When ("escribe una respuesta a un comentario y envía el mensaje")
    public void respondeComentario(){
        usuario.attemptsTo(Responder.comentario());
    }

    @Given ("que el usuario no está autenticado")
    public void usuarioNoHaIniciadoSesion(){
        usuario.attemptsTo(Abrir.viveMedellin());
    }

    @When ("intenta responder un comentario")
    public void intentaResponderAComentario(){
        usuario.attemptsTo(Abrir.evento());
    }

    @Then ("el sistema rechaza responder")
    public void rechazaRespuesta(){
        usuario.should(seeThat(RespuestaRechazada.contiene(), equalTo(true)));
    }
    
}
