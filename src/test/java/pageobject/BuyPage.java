package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import support.Util;

public class BuyPage extends Util {

    @FindBy(xpath = "//select[@name='quantity']") protected WebElement cmbCantidad;
    @FindBy(xpath = "//input[@type='submit']") protected WebElement btnBuyNow;

    public BuyPage(){
        PageFactory.initElements(driver,this);
    }

    public void elegirCantidad(String cantidad){
        wait.until(ExpectedConditions.visibilityOf(cmbCantidad));
        new Select(cmbCantidad).selectByVisibleText(cantidad);
    }

    public void clickComprar(){
        btnBuyNow.click();
    }
}
