package co.edu.udea.vivemedellin.screen.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class Event {
    public static final Target REPLY_BUTTON =
        Target.the("Responder comentario").locatedBy("//*[@id=\"root\"]/div[2]/div[2]/section/ul/li[1]/div/div/div/div[2]/button");
    public static final Target REPLY_TEXT_BOX =
        Target.the("Escribir respuesta").locatedBy("//*[@id=\"root\"]/div[2]/div[2]/section/ul/li[1]/ul/li/form/textarea");
    
}
