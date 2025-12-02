package co.edu.udea.vivemedellin.screen.questions;

import static co.edu.udea.vivemedellin.screen.userinterfaces.Home.USUARIO_AUTENTICADO;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class UsuarioAutenticado implements Question<String> {
    
    public static UsuarioAutenticado value() {
        return new UsuarioAutenticado();
    }
    @Override
    public String answeredBy(Actor actor) {
        return USUARIO_AUTENTICADO.resolveFor(actor).getText();
    }
}

