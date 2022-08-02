package pageobject;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import support.Util;

public class PayResultPage extends Util {

    @FindBy(xpath = "//*[text()='Order ID']//preceding::h2") protected WebElement lblMensajeExitoso;
    @FindBy(xpath = "//*[text()='Order ID']//following::strong") protected WebElement lblIdPago;
    @FindBy(xpath = "//a[@class='button special']") protected WebElement btnHome;

    public PayResultPage(){
        PageFactory.initElements(driver,this);
    }

    public void comprobarMensajeExitoso(String mensaje){
        wait.until(ExpectedConditions.visibilityOf(lblMensajeExitoso));
        Assert.assertEquals(mensaje,lblMensajeExitoso.getText());
    }

    public void guardarIdPage(){
        String idPago = lblIdPago.getText();
    }

    public void regresarHome(){
        btnHome.click();
    }
}
