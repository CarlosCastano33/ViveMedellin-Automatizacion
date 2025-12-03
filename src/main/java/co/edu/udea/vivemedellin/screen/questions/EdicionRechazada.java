package co.edu.udea.vivemedellin.screen.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.edu.udea.vivemedellin.screen.userinterfaces.EventoPage.ERROR_EDICION;

public class EdicionRechazada implements Question<Boolean> {

    public static EdicionRechazada value(){
        return new EdicionRechazada();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return ERROR_EDICION.resolveFor(actor).isVisible();
    }
}
