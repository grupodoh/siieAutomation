Feature: Navegando por el menu de la aplicación

  Rule: Se deben verificar que las opciones del menu funcionen con normalidad accediendo a cada módulo.

        Scenario: El usuario accede a todas las opciones del menu lateral izquierda.
          Given El usuario va al inicio de sesion
          And Ingresa credenciales "3332" y "3332"
          When accede al módulo Gestión Operativa
          And  accede al módulo Parametrización
          And  accede al módulo Seguridad
          And  accede al módulo Administración

        Scenario: El usuario cierra sesión.
          Given Cierra sesión en el aplicativo
          Then Cierra el navegador


