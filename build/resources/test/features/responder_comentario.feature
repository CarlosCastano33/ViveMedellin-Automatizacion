Feature: Responder comentarios
    Como usuario,
    quiero dejar comentarios a forma de respuesta de otros comentarios
    de eventos publicados en la plataforma
    para interactuar directamente con otros usuarios y generar conversaciones.

    Scenario: Respuesta exitosa a un comentario
        Given que el usuario está en la pantalla de inicio de sesión
            #Given que el usuario está autenticado en la plataforma
        And se encuentra visualizando un comentario en un evento
        #When escribe una respuesta a un comentario y envía el mensaje
        #Then la respuesta queda anidada al comentario original
        #And la respuesta se muestra inmediatamente en el hilo del comentario

    Scenario: Respuesta sin autentificación
        Given que el usuario no está autenticado
        When intenta responder un comentario
        Then el sistema rechaza responder
        #And no se permite enviar la respuesta