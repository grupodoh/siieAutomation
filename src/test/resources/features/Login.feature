Feature: Accediendo al alplicativo

  Rule: Se deben validar todos los tipos de error que pueden ocurriri al tratar de ingresar con las
  credenciales invalidas y a su vez el acceso con las credenciales validas.

    @login @humo
    Scenario: El usuario accede al aplicativo con las credenciales validas
      Given El usuario accede al inicio de sesion
      When Ingresa las credenciales validas
      Then puede visualizar el dashboard del aplicativo

      @loginFailed @humo
        Scenario: Se valida que las alertas del login funcionen
          Given El usuario no ingresa las credenciales
          When Intentamos dar en el boton Ingresar
          Then Se muestran todas las alertas