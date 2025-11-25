package co.edu.udea.vivemedellin.screen.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

public class Abrir implements Task {

    private final String url;

    public Abrir(String url) {
        this.url = url;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(url));
    }

    public static Abrir viveMedellin(){
        return Tasks.instrumented(Abrir.class, "https://frontend-vivamedellin.vercel.app/");
    }

}