package co.edu.udea.vivemedellin.screen.stepdefinitions;

import co.edu.udea.vivemedellin.screen.questions.ComentarioEditado;
import co.edu.udea.vivemedellin.screen.questions.EdicionRechazada;
import co.edu.udea.vivemedellin.screen.tasks.Editar;
import co.edu.udea.vivemedellin.screen.tasks.Abrir;
import co.edu.udea.vivemedellin.screen.tasks.IniciarCon;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

import org.openqa.selenium.WebDriver;

public class StepDefinition3 {

    public final Actor usuario = Actor.named("usuario");

    @Before
    public void config(){
        WebDriver driver = Serenity.getDriver(); // deja que serenity lo gestione
        usuario.can(BrowseTheWeb.with(driver));
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("que el usuario está autenticado y es autor del comentario")
    public void usuarioAutenticado() {
        usuario.attemptsTo(Abrir.viveMedellin());
        usuario.attemptsTo(IniciarCon.credencialesValidas());
        usuario.attemptsTo(Abrir.evento());
    }

    @When("selecciona la opción para editar, modifica el texto y guarda los cambios")
    public void editaComentario() {
        usuario.remember("nuevoTexto", "Comentario editado automáticamente");
        usuario.attemptsTo(Editar.comentario("Comentario editado automáticamente"));
    }

    @Then("se actualiza el comentario para todos los usuarios")
    public void comentarioActualizado() {
        String nuevoTexto = usuario.recall("nuevoTexto");
        usuario.should(seeThat(ComentarioEditado.contiene(nuevoTexto), equalTo(true)));
    }

    // Escenario 2
    @And("el comentario fue publicado hace más de una hora")
    public void comentarioViejo() {
        usuario.attemptsTo(Abrir.evento());
    }

    @When("intenta editar el comentario")
    public void intentaEditar() {
        usuario.attemptsTo(Editar.comentario("Intento de edición tardía"));
    }

    @Then("se muestra un mensaje indicando que el tiempo de edición ha expirado")
    public void edicionDenegada() {
        usuario.should(seeThat(EdicionRechazada.value(), equalTo(true)));
    }
}
