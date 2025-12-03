package co.edu.udea.vivemedellin.screen.questions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static co.edu.udea.vivemedellin.screen.userinterfaces.EventoPage.LISTA_COMENTARIOS;

public class ComentarioEditado implements Question<Boolean> {

    private final String textoEditado;

    public ComentarioEditado(String textoEditado){
        this.textoEditado = textoEditado;
    }

    public static ComentarioEditado contiene(String texto){
        return new ComentarioEditado(texto);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String lista = LISTA_COMENTARIOS.resolveFor(actor).getText();
        return lista.contains(textoEditado);
    }
}
