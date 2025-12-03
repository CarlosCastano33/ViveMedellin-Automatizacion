package co.edu.udea.vivemedellin.screen.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

import static co.edu.udea.vivemedellin.screen.userinterfaces.EventoPage.*;

public class EscribirComentario implements Interaction {

    private final String comentario;

    public EscribirComentario(String comentario){
        this.comentario = comentario;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                net.serenitybdd.screenplay.actions.Enter
                        .theValue(comentario)
                        .into(COMMENT_TEXTAREA)
        );
        actor.attemptsTo(
                net.serenitybdd.screenplay.actions.Click
                        .on(PUBLICAR_BUTTON)
        );
    }

    public static EscribirComentario conTexto(String comentario){
        return Tasks.instrumented(EscribirComentario.class, comentario);
    }
}
