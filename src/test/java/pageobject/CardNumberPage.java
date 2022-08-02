package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import support.Util;

public class CardNumberPage extends Util {

    public static String numeroTarjeta;
    public static String numeroCvv;
    public static String month;
    public static String year;

    @FindBy(xpath = "//*[contains(text(),'Card Number:')]") protected WebElement lblNumeroTarjeta;
    @FindBy(xpath = "//*[contains(text(),'CVV:')]") protected WebElement lblNumeroCvv;
    @FindBy(xpath = "//*[contains(text(),'Exp:')]") protected WebElement lblFechaExpiracion;

    public CardNumberPage(){
        PageFactory.initElements(driver,this);
    }

    public void obtenerNumeroTarjeta(){
        wait.until(ExpectedConditions.visibilityOf(lblNumeroTarjeta));
        numeroTarjeta = lblNumeroTarjeta.getText().replace("Card Number:- ","");
    }

    public void obtenerNumeroCvv(){
        numeroCvv = lblNumeroCvv.getText().replace("CVV:- ","");
    }
    public void obtenerFecha(){
        String[] fecha = lblFechaExpiracion.getText().replace("Exp:- ","").split("/");
        month = fecha[0];
        year = fecha[1];
    }
}
