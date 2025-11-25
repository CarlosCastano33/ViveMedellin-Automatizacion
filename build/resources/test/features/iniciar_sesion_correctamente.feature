
  Feature: Inicio de sesión exitoso
    Como usuario,
    quiero iniciar sesión en la plataforma
    para acceder a las funcionalidades de interacción social y poder comentar en los eventos.

    Scenario: Usuario inicia sesión con credenciales válidas
      Given que el usuario está en la pantalla de inicio de sesión
      When intenta iniciar sesión con el correo "<correo>" y la contraseña "<contraseña>"
      Then el acceso es concedido
      And es redirigido a la página principal
      And la sesión permanece activa hasta que decida cerrarla

    Scenario: Usuario intenta iniciar sesión con credenciales inválidas
      Given que el usuario está en la pantalla de inicio de sesión
      When ingresa credenciales inválidas
      And intenta iniciar sesión
      Then el sistema rechaza el intento de acceso
      And muestra un mensaje de error "Credenciales incorrectas"

    Scenario: Usuario accede con sesión activa sin volver a iniciar sesión
      Given que el usuario tiene una sesión activa en la plataforma
      When accede nuevamente sin haber cerrado sesión
      Then el sistema omite el inicio de sesión
      And dirige al usuario directamente a la página principal
