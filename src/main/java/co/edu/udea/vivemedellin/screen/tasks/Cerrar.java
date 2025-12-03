package co.edu.udea.vivemedellin.screen.tasks;

import static co.edu.udea.vivemedellin.screen.userinterfaces.Home.CERRAR_SESION;
import static co.edu.udea.vivemedellin.screen.userinterfaces.Home.USUARIO_AUTENTICADO;

import co.edu.udea.vivemedellin.screen.utils.WaitTime;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class Cerrar implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(USUARIO_AUTENTICADO));
        WaitTime.putWaitTimeOf(1000);
        actor.attemptsTo(Click.on(CERRAR_SESION));
        WaitTime.putWaitTimeOf(1000);
    }
    
    public static Cerrar sesion(){
        return Tasks.instrumented(Cerrar.class);
    }
}
