Feature: Accediendo al alplicativo

  Rule: Se deben validar todos los tipos de error que pueden ocurriri al tratar de ingresar con las
  credenciales invalidas y a su vez el acceso con las credenciales validas.

    Background:
      Given El usuario accede al inicio de sesion

    @login @humo @integracion
    Scenario: El usuario accede al aplicativo con las credenciales validas
      When Ingresa las credenciales "7416" y "7416"
      Then puede visualizar el dashboard del aplicativo


    @loginFailed
    Scenario: Se valida que las alertas del login funcionen
      When El usuario no ingresa las credenciales
      And Intentamos dar en el boton Ingresar
      Then Se muestran todas las alertas
      And Cierra el navegador

    @Relogin
    Scenario: El usuario accede al aplicativo con las credenciales invalidas
      When Ingresa las credenciales "7416" y "7415"
      And Las credenciales son invalidas visualiza una alerta,luego introdice correctamente las credenciales
      And Ingresa las credenciales "7416" y "7416"
      Then puede visualizar el dashboard del aplicativo
      And  Cierra el navegador