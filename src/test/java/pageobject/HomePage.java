package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import support.Util;

public class HomePage extends Util {

    @FindBy(xpath = "//nav[@id='nav']/a[2]") protected WebElement lnkGenerarNumeroTarjeta;

    public HomePage(){
        PageFactory.initElements(driver,this);
    }

    public void clickGenerarTarjeta(){
        wait.until(ExpectedConditions.elementToBeClickable(lnkGenerarNumeroTarjeta));
        lnkGenerarNumeroTarjeta.click();
    }
}
