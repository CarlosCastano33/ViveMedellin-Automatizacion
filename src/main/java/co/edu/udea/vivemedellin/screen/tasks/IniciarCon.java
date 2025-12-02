package co.edu.udea.vivemedellin.screen.tasks;

import co.edu.udea.vivemedellin.screen.interactions.AccederCon;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class IniciarCon implements Task {

    private final String correo;
    private final String contrasena;

    public IniciarCon(String correo, String contrasena){
       this.correo = correo;
       this.contrasena = contrasena;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(AccederCon.credenciales(correo, contrasena));
    }

    public static IniciarCon credencialesValidas(){
        return Tasks.instrumented(IniciarCon.class, "carlose.castano@udea.edu.co", "Medallo3*");
    }

    public static IniciarCon credencialesInvalidas(){
        return Tasks.instrumented(IniciarCon.class, "carlose.castano@udea.edu.co", "contraseña errónea");
    }
}
