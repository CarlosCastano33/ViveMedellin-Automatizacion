package co.edu.udea.vivemedellin.screen.tasks;

import co.edu.udea.vivemedellin.screen.interactions.Clickear;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class Seleccionar implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Clickear.inicioDeSesion());
    }

    public static Seleccionar pantallaInicioDeSesion(){
        return Tasks.instrumented(Seleccionar.class);
    }
}
