package co.edu.udea.vivemedellin.screen.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class EventoPage {

    public static final Target COMMENT_TEXTAREA =
            Target.the("Área de texto para escribir comentario")
                    .located(By.id("commentTextarea"));

    public static final Target PUBLICAR_BUTTON =
            Target.the("Botón publicar comentario")
                    .located(By.xpath("//button[contains(text(),'Publicar')]"));

    public static final Target LISTA_COMENTARIOS =
            Target.the("Lista de comentarios del evento")
                    .located(By.id("commentsList"));

    public static final Target MENSAJE_REQUIERE_LOGIN =
            Target.the("Mensaje de error para usuarios no autenticados")
                    .located(By.xpath("//*[contains(text(),'Debe iniciar sesión para comentar')]"));
}
