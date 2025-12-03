package co.edu.udea.vivemedellin.screen.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.edu.udea.vivemedellin.screen.userinterfaces.EventoPage.*;
import co.edu.udea.vivemedellin.screen.utils.WaitTime;

public class EditarComentario implements Interaction {

    private final String nuevoTexto;

    public EditarComentario(String nuevoTexto){
        this.nuevoTexto = nuevoTexto;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(EDIT_BUTTON),
                Enter.theValue(nuevoTexto).into(EDIT_TEXTAREA),
                Click.on(SAVE_EDIT_BUTTON)
        );

        WaitTime.putWaitTimeOf(1500);
    }

    public static EditarComentario conTexto(String nuevoTexto){
        return Tasks.instrumented(EditarComentario.class, nuevoTexto);
    }
}
