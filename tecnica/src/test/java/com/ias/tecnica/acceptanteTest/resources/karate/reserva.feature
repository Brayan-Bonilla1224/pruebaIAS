Feature: Guardar reserva
  Background:
    * url "http://localhost:8085/api/restaurant"
    * path "/guardar"
    * def bodyRequest = read("/body_request.json")


  @PostGuardarReserva
  Scenario Outline: guardar reserva
    Given request bodyRequest
    And method POST
    Then status 200

    Examples:
      | nombre | numero|
      | prueba | 123456|

  @PutActualizarReserva
  Scenario Outline: guardar reserva
    Given request bodyRequest
    And method POST
    Then status 200

    Examples:
      | nombre | numero|
      | prueba | 123456|
