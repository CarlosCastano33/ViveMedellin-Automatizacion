package co.edu.udea.vivemedellin.screen.questions;

import static co.edu.udea.vivemedellin.screen.userinterfaces.Home.USUARIO_NO_AUTENTICADO;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class UsuarioNoAutenticado implements Question<String> {
    
    public static UsuarioNoAutenticado value() {
        return new UsuarioNoAutenticado();
    }
    @Override
    public String answeredBy(Actor actor) {
        return USUARIO_NO_AUTENTICADO.resolveFor(actor).getText();
    }
}

