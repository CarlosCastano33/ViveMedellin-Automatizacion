package co.edu.udea.vivemedellin.screen.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static co.edu.udea.vivemedellin.screen.userinterfaces.EventoPage.LISTA_COMENTARIOS;

public class ComentarioPublicado implements Question<Boolean> {

    private final String comentario;

    public ComentarioPublicado(String comentario){
        this.comentario = comentario;
    }

    public static ComentarioPublicado contiene(String comentario){
        return new ComentarioPublicado(comentario);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String lista = LISTA_COMENTARIOS.resolveFor(actor).getText();
        return lista.contains(comentario);
    }
}
