Feature: Comentarios en los eventos

  Scenario: Usuario autenticado comenta en un evento
    Given que el usuario ha iniciado sesión
    And se encuentra en la página de detalles de un evento publicado
    When escribe un comentario en el cuadro de texto
      #And presiona el botón Publicar
      #Then el comentario se guarda en la base de datos
    Then aparece inmediatamente en la lista de comentarios del evento

  Scenario: Usuario intenta comentar sin autenticarse
    Given que el usuario no ha iniciado sesión
    When intenta escribir un comentario en un evento
    Then el sistema rechaza la acción
    #And muestra el mensaje "Debe iniciar sesión para comentar"

  Scenario: Usuario publica comentario con formato enriquecido
    Given que el usuario ha iniciado sesión
    And se encuentra en la página de detalles de un evento publicado
    When escribe un comentario usando formato enriquecido
      #And presiona el botón Publicar
      #Then el comentario se guarda en la base de datos
      #Then se muestra en la lista de comentarios con el formato aplicado
    Then aparece inmediatamente en la lista de comentarios del evento
