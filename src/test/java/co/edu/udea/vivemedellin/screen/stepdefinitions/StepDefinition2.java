package co.edu.udea.vivemedellin.screen.stepdefinitions;

import co.edu.udea.vivemedellin.screen.interactions.EscribirComentario;
import co.edu.udea.vivemedellin.screen.questions.ComentarioPublicado;
import co.edu.udea.vivemedellin.screen.questions.UsuarioAutenticado;
import co.edu.udea.vivemedellin.screen.questions.UsuarioNoAutenticado;
import co.edu.udea.vivemedellin.screen.tasks.*;
import io.cucumber.java.Before;
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

public class StepDefinition2 {

    public final Actor usuario = Actor.named("usuario");

    @Before
    public void config(){
        WebDriver driver = Serenity.getDriver(); // deja que serenity lo gestione
        usuario.can(BrowseTheWeb.with(driver));
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("que el usuario ha iniciado sesión")
    public void usuarioHaIniciadoSesion() {
        usuario.attemptsTo(Abrir.viveMedellin());
        usuario.attemptsTo(IniciarCon.credencialesValidas());
    }

    @Given("se encuentra en la página de detalles de un evento publicado")
    public void usuarioEnEvento() {
        usuario.attemptsTo(IrAlEvento.pagina());
    }

    @When("escribe un comentario en el cuadro de texto")
    public void escribeComentario() {
        usuario.remember("comentario", "Este es un comentario automático");
        usuario.attemptsTo(EscribirComentario.conTexto("Este es un comentario automático"));
    }

    @When("presiona el botón Publicar")
    public void presionaPublicar() {
        // incluido en la interacción EscribirComentario
    }

    @Then("el comentario se guarda en la base de datos")
    public void comentarioGuardado() {
        String comentario = usuario.recall("comentario");
        usuario.should(seeThat(ComentarioPublicado.contiene(comentario), equalTo(true)));
    }

    @Then("aparece inmediatamente en la lista de comentarios del evento")
    public void apareceEnLista() {
        String comentario = usuario.recall("comentario");
        usuario.should(seeThat(ComentarioPublicado.contiene(comentario), equalTo(true)));
    }


    @Given("que el usuario no ha iniciado sesión")
    public void usuarioNoAutenticado() {
        usuario.attemptsTo(Abrir.viveMedellin());
    }

    @When("intenta escribir un comentario en un evento")
    public void intentaEscribirComentario() {
        usuario.attemptsTo(IrAlEvento.pagina());
    }

    @Then("la funcionalidad de publicación de comentarios rechaza la acción")
    public void funcionalidadRechazaAccion() {
        usuario.should(seeThat(UsuarioNoAutenticado.value(), equalTo("Debe iniciar sesión para comentar")));
    }


    @When("escribe un comentario usando formato enriquecido")
    public void escribeConFormato() {
        usuario.remember("comentario", "**Comentario en negritas** con *cursivas*");
        usuario.attemptsTo(EscribirComentario.conTexto("**Comentario en negritas** con *cursivas*"));
    }

    @Then("se muestra el comentario con el formato aplicado")
    public void seMuestraConFormato() {
        String comentario = usuario.recall("comentario");
        usuario.should(seeThat(ComentarioPublicado.contiene("negritas"), equalTo(true)));
    }


}
