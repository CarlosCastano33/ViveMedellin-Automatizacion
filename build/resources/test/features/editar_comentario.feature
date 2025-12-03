Feature: Edición de comentarios publicados
  Como usuario,
  quiero editar mis comentarios después de publicarlos
  para corregir errores tipográficos o mejorar su claridad.

  Scenario: Usuario edita un comentario dentro del tiempo permitido
    Given que el usuario está autenticado y es autor del comentario
    And el comentario fue publicado hace menos de una hora
    When selecciona la opción para editar, modifica el texto y guarda los cambios
    Then se actualiza el comentario para todos los usuarios

  Scenario: Usuario intenta editar un comentario fuera del tiempo permitido
    Given que el usuario está autenticado y es autor del comentario
    And el comentario fue publicado hace más de una hora
    When intenta editar el comentario
    Then se muestra un mensaje indicando que el tiempo de edición ha expirado
