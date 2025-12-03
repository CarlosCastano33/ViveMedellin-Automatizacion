package co.edu.udea.vivemedellin.screen.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class EventoPage {

    public static final Target COMMENT_TEXTAREA =
            Target.the("Área de texto para escribir comentario")
                    .locatedBy("//*[@id=\"root\"]/div[2]/div[2]/section/div/form/textarea");
    public static final Target PUBLICAR_BUTTON =
            Target.the("Botón publicar comentario")
                    .locatedBy("//*[@id=\"root\"]/div[2]/div[2]/section/div/form/button");
    public static final Target LISTA_COMENTARIOS =
            Target.the("Lista de comentarios del evento")
                    .locatedBy("//*[@id=\"root\"]/div[2]/div[2]/section/ul");
        //borrar                    
    public static final Target MENSAJE_REQUIERE_LOGIN =
            Target.the("Mensaje de error para usuarios no autenticados")
                    .located(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/section/div/form/textarea"));
}
