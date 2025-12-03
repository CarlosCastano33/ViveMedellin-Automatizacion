package co.edu.udea.vivemedellin.screen.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class IrAlEvento implements Task {

    private final String urlEvento;

    public IrAlEvento(String urlEvento){
        this.urlEvento = urlEvento;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                net.serenitybdd.screenplay.actions.Open.url(urlEvento)
        );
    }

    public static IrAlEvento pagina(){
        return Tasks.instrumented(IrAlEvento.class,
                "https://frontend-vivamedellin.vercel.app/event-01"
        );
    }
}
