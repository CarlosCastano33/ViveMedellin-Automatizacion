package co.edu.udea.vivemedellin.screen.interactions;

import co.edu.udea.vivemedellin.screen.utils.WaitTime;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.edu.udea.vivemedellin.screen.userinterfaces.Home.*;

public class AccederCon implements Interaction {

    private final String correo;
    private final String contrasena;

    public AccederCon(String correo, String contrasena){
        this.correo = correo;
        this.contrasena = contrasena;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        
        actor.attemptsTo(Click.on(INICIAR_SESION_BUTTON));
        actor.attemptsTo(Enter.theValue(correo).into(EMAIL_INPUT));
        actor.attemptsTo(Enter.theValue(contrasena).into(PASSWORD_INPUT));
        WaitTime.putWaitTimeOf(1000);
        actor.attemptsTo(Click.on(INICIAR_SESION_ENVIAR_BUTTON));
        WaitTime.putWaitTimeOf(5000);
    }

    public static AccederCon credenciales(String correo, String contrasena){
        return Tasks.instrumented(AccederCon.class, correo, contrasena);
    }
}