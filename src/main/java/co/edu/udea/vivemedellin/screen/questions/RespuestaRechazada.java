package co.edu.udea.vivemedellin.screen.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static co.edu.udea.vivemedellin.screen.userinterfaces.EventoPage.COMMENT_TEXTAREA;

public class RespuestaRechazada implements Question<Boolean> {

    public static RespuestaRechazada contiene(){
        return new RespuestaRechazada();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String placeholder = COMMENT_TEXTAREA.resolveFor(actor)
                .getAttribute("placeholder");

        return placeholder != null &&
               placeholder.contains("You must log in to comment");
    }
}
