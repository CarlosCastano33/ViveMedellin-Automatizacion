package co.edu.udea.vivemedellin.screen.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import static co.edu.udea.vivemedellin.screen.userinterfaces.Event.REPLY_BUTTON;

public class Enviar implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(REPLY_BUTTON));

    }
    
public static Enviar respuesta(){
    return Tasks.instrumented(Enviar.class);
}

}
