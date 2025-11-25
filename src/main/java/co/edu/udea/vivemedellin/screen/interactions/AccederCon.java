package co.edu.udea.vivemedellin.screen.interactions;

import co.edu.udea.vivemedellin.screen.utils.WaitTime;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static co.edu.udea.vivemedellin.screen.userinterfaces.Home.INICIAR_SESION_BUTTON;

public class Clickear implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        // TODO DEBE ABIR INICIO, LLENAR FORMULARIO Y DARLE ENTER
        actor.attemptsTo(Click.on(INICIAR_SESION_BUTTON));
        actor.attemptsTo();
        WaitTime.putWaitTimeOf(1000);
    }

    public static Clickear inicioDeSesion(String correo, String contrasena){
        return Tasks.instrumented(Clickear.class, correo, contrasena);
    }
}