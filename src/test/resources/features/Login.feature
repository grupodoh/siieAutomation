Feature: Accediendo al alplicativo

    Scenario: El usuario restablece la contraseña.
      Given El usuario accede al inicio de sesion
      When el usuario restablece la contraseña

    Scenario: El usuario accede con las credenciales validas.
      Given Ingresa las credenciales "3332" y "3332"
      Then puede visualizar el dashboard del aplicativo
      And Cierra el navegador


