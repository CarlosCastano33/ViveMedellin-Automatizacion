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

    public static final Target EDIT_BUTTON = Target.the("Botón editar comentario")
            .locatedBy("//*[@id=\"root\"]/div[2]/div[2]/section/ul/li[1]/div/div/div/div[1]/div[2]/button[1]");

    public static final Target EDIT_TEXTAREA = Target.the("Área de texto para editar comentario")
            .locatedBy("//*[@id=\"root\"]/div[2]/div[2]/section/ul/li[1]/div/div/div/div[2]/textarea");

    public static final Target SAVE_EDIT_BUTTON = Target.the("Botón guardar edición")
            .locatedBy("//*[@id=\"root\"]/div[2]/div[2]/section/ul/li[1]/div/div/div/div[2]/div/button[1]");

    public static final Target ERROR_EDICION = Target.the("Mensaje de error al intentar editar fuera de tiempo")
            .locatedBy("//p[contains(text(),'tiempo de edición ha expirado')]");

}
