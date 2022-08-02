Feature:Funcionalidad de la compra un producto
 Scenario Outline: compra de un producto
   Given un usuario ingresa al sitio web
   When genera su numero de tarjeta
   And elige la cantidad de "<cantidad>"
   And realiza la compra del producto
   And ingresa los datos de la compra
   And paga el producto
   Then validar el mensaje de pago "Payment successfull!"
   And regresar a la pagina principal
   Examples:
   |cantidad|
   |2       |
   |4       |