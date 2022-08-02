package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.*;

public class PruebaCompra {

    BuyPage buyPage;
    CardNumberPage cardNumberPage;
    HomePage homePage;
    PaymentProcessPage paymentProcessPage;
    PayResultPage pay;

    public PruebaCompra(){
        buyPage = new BuyPage();
        cardNumberPage = new CardNumberPage();
        homePage = new HomePage();
        paymentProcessPage = new PaymentProcessPage();
        pay = new PayResultPage();
    }

    @Given("un usuario ingresa al sitio web")
    public void unUsuarioIngresaAlSitioWeb() {
        Hooks.driver.get("https://demo.guru99.com/payment-gateway/index.php");
    }

    @When("genera su numero de tarjeta")
    public void generaSuNumeroDeTarjeta() {
        homePage.clickGenerarTarjeta();
        homePage.ultimaVentana();
        cardNumberPage.obtenerNumeroTarjeta();
        cardNumberPage.obtenerNumeroCvv();
        cardNumberPage.obtenerFecha();
        cardNumberPage.ventanaPrincipal();
    }

    @And("elige la cantidad de {string}")
    public void eligeLaCantidadDe(String cantidad) {
        buyPage.elegirCantidad(cantidad);

    }

    @And("realiza la compra del producto")
    public void realizaLaCompraDelProducto() {
        buyPage.clickComprar();
    }

    @And("ingresa los datos de la compra")
    public void ingresaLosDatosDeLaCompra() {
        paymentProcessPage.ingresarNumeroTarjeta(CardNumberPage.numeroTarjeta);
        paymentProcessPage.elegirMonth(CardNumberPage.month);
        paymentProcessPage.elegirYear(CardNumberPage.year);
        paymentProcessPage.ingresarCvv(CardNumberPage.numeroCvv);
    }

    @And("paga el producto")
    public void pagaElProducto() {
        paymentProcessPage.clickPay();
    }

    @Then("validar el mensaje de pago {string}")
    public void validarElMensajeDePago(String mensaje) {
        pay.comprobarMensajeExitoso(mensaje);
        pay.guardarIdPage();
    }

    @And("regresar a la pagina principal")
    public void regresarALaPaginaPrincipal() {
        pay.regresarHome();
    }
}
