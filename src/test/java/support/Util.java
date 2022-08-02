package support;

import definitions.Hooks;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class Util extends Hooks {

    public static WebDriverWait wait;
    public static JavascriptExecutor je;

    public Util(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        je = (JavascriptExecutor) driver;
    }

    public void ultimaVentana(){
        Set<String> idVentanas = driver.getWindowHandles();
        for (String ventana : idVentanas) {
            driver.switchTo().window(ventana);
        }
    }

    public void ventanaPrincipal(){
        driver.close();
        driver.switchTo().window("");
    }
}
