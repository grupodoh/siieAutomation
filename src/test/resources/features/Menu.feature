Feature: Navegando por el menu de la aplicación

  Rule: Se deben validar todos los Hipervinculos del menu funcionen con normalidad accedeindo a cada módulo.

        @menu
        Scenario: El usuario accede a todos los modulos ubicados en el menu lateral izquierda iniciando desde el login
          Given El usuario accede al inicio de sesion
          And Ingresa las credenciales "7416" y "7416"
          When el usuario accede al módulo Gestión Operativa
          And  el usuario accede al módulo Indicadores
          And  el usuario accede al módulo Parametrización
          And el usuario accede al módulo Seguridad
          And el usuario accede al módulo Administración
          Then Cierra el navegador

    @humo
    Scenario: El usuario accede a todos los modulos ubicados en el menu lateral izquierda
      Given puede visualizar el dashboard del aplicativo
      When el usuario accede al módulo Gestión Operativa
      And  el usuario accede al módulo Indicadores
      And  el usuario accede al módulo Parametrización
      And el usuario accede al módulo Seguridad
      And el usuario accede al módulo Administración
      Then Cierra el navegador


