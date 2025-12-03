package co.edu.udea.vivemedellin.screen.tasks;

import co.edu.udea.vivemedellin.screen.interactions.EnviarComentario;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class Escribir implements Task{

    private final String comentario;

    public Escribir(String comentario){
        this.comentario = comentario;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(EnviarComentario.conTexto(comentario));
    }
    
    public static Escribir comentario(String comentario){
        return Tasks.instrumented(Escribir.class, comentario);
    }

}
