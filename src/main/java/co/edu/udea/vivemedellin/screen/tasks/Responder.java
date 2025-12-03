package co.edu.udea.vivemedellin.screen.tasks;

import co.edu.udea.vivemedellin.screen.interactions.Enviar;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class Responder implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enviar.respuesta());
    }
    
    public static Responder comentario(){
        return Tasks.instrumented(Responder.class);
    }

}
