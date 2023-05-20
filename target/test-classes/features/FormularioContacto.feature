#caso de uso
Feature: Formulario Contacto
  el usuario desea rellenar los datos del formulario

  @escenario1
  Scenario Outline: Rellenar Formulario correctamente
    Given el cliente entra en la pagina principal
    And se dirige a la pagina Contacto
    When rellena los datos del formulario correctamente
    Then aparece el mensaje correspondiente

  @escenario2
  Scenario Outline: Rellenar Formulario con datos
    Given el cliente entra en la pagina principal
    And se dirige a la pagina Contacto
    When rellena los datos del formulario nombre "<nombre>", email "<email>", titulo "<titulo>", mensaje "<mensaje>"
    Then aparece el mensaje correspondiente

    Examples: 
      | nombre | email            | titulo | mensaje              |
      | Marcos | marcos@gmail.com | dudas  | hola me llamo Marcos |
