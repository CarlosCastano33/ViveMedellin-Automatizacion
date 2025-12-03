package co.edu.udea.vivemedellin.screen.tasks;

import co.edu.udea.vivemedellin.screen.interactions.EditarComentario;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class Editar implements Task {

    private final String nuevoTexto;

    public Editar(String nuevoTexto){
        this.nuevoTexto = nuevoTexto;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(EditarComentario.conTexto(nuevoTexto));
    }

    public static Editar comentario(String nuevoTexto){
        return Tasks.instrumented(Editar.class, nuevoTexto);
    }
}
