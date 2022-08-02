package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import support.Util;

public class PaymentProcessPage extends Util {

    @FindBy(id = "card_nmuber") protected WebElement tflCardNumber;
    @FindBy(id = "month") protected WebElement cmbMonth;
    @FindBy(id = "year") protected WebElement cmbYear;
    @FindBy(id = "cvv_code") protected WebElement tflCvv;
    @FindBy(xpath = "//input[@type='submit']") protected WebElement btnPay;

    public PaymentProcessPage(){
        PageFactory.initElements(driver,this);
    }

    public void ingresarNumeroTarjeta(String numeroTarjeta){
        wait.until(ExpectedConditions.visibilityOf(tflCardNumber));
        tflCardNumber.sendKeys(numeroTarjeta);
    }
    public void elegirMonth(String month){
        new Select(cmbMonth).selectByVisibleText(month);
    }
    public void elegirYear(String year){
        new Select(cmbYear).selectByVisibleText(year);
    }
    public void ingresarCvv(String cvv){
        tflCvv.sendKeys(cvv);
    }
    public void clickPay(){
        btnPay.click();
    }
}
