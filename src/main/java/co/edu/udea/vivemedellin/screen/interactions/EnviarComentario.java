package co.edu.udea.vivemedellin.screen.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.edu.udea.vivemedellin.screen.userinterfaces.EventoPage.*;

import co.edu.udea.vivemedellin.screen.utils.WaitTime;

public class EnviarComentario implements Interaction {

    private final String comentario;

    public EnviarComentario(String comentario){
        this.comentario = comentario;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(comentario).into(COMMENT_TEXTAREA));
        actor.attemptsTo(Click.on(PUBLICAR_BUTTON));
        WaitTime.putWaitTimeOf(1000);
    }

    public static EnviarComentario conTexto(String comentario){
        return Tasks.instrumented(EnviarComentario.class, comentario);
    }
}
