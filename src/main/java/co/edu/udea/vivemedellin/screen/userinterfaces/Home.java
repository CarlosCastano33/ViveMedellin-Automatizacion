package co.edu.udea.vivemedellin.screen.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Home {

    public static final Target INICIAR_SESION_BUTTON =
            Target.the("Iniciar sesión emergente").locatedBy("//*[@id=\"root\"]/nav/div/div/div[3]/button[1]");
    public static final Target EMAIL_INPUT =
            Target.the("Email input").located(By.id("email"));
    public static final Target PASSWORD_INPUT =
            Target.the("Contraseña input").located(By.id("password"));
    public static final Target INICIAR_SESION_ENVIAR_BUTTON =
            Target.the("Iniciar sesión emergente").locatedBy("//*[@id=\"radix-:r3:\"]/form/div[3]/button[2]");

}