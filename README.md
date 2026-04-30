# Tarea 04: Multimedia y UX - Spyro The Dragon 🐉
**BK Programación | Proyecto desarrollado por: Irene Condado Alcantarilla**

## 📖 Propósito del Proyecto
Este proyecto consiste en la evolución multimedia de una aplicación base inspirada en el universo de **Spyro the Dragon**[cite: 1]. El objetivo principal es mejorar la retención del usuario y la competitividad de la app mediante el uso estratégico de elementos visuales, sonoros y sorpresas interactivas (Easter Eggs), asegurando una experiencia de usuario (UX) inmersiva y funcional.

## 📂 Ficheros Modificados y Creados
Para cumplir con los estándares de calidad de la empresa, se han gestionado los siguientes recursos técnicos:

### 🎨 Interfaz y Diseño (XML)
*   **`layout/guia.xml`**: Creado para la superposición de la guía interactiva, utilizando fondos semitransparente para mantener el contexto de la app base.
*   **`layout/video_player.xml`**: Interfaz de pantalla completa diseñada específicamente para la reproducción del Easter Egg de vídeo.
*   **`drawable/cristal_background.xml`**: Fondo personalizado mediante la clase Drawable con degradados inspirados en la estética de Spyro (cristales y gemas).
*   **`anim/pop_in.xml`**: Animación de escala aplicada a los bocadillos informativos para una aparición dinámica.

### ⚙️ Lógica y Funcionalidad (Kotlin)
*   **`MainActivity.kt`**: Implementación de la lógica de navegación de la guía (6 pasos), gestión de `SharedPreferences` para el mostrado único y control de audio.
*   **`VideoPlayer.kt`**: Nueva actividad que gestiona la reproducción del video temático y el retorno automático tras finalizar.
*   **`CetroRiptoView.kt`**: Clase de vista personalizada que utiliza la **API Canvas** para animar el brillo y la energía mágica del cetro de Ripto.
*   **`CharactersAdapter.kt`**: Modificado para integrar el `LongClickListener` sobre el personaje Ripto y disparar la animación de Canvas.
*   **`WorldsAdapter.kt`**: Modificado para incluir la lógica de detección de tres clics consecutivos sobre un mismo mundo.

### 📋 Configuración y Recursos Multimedia
*   **`AndroidManifest.xml`**: Actualizado para registrar la nueva actividad `VideoPlayer` y permitir la navegación entre componentes.
*   **`res/raw/spyro_video.mp4`**: Recurso de vídeo para el Easter Egg de la sección Mundos.
*   **`res/raw/clic.mp3`**: Efecto de sonido temático para las interacciones y avances en la guía.

## ✨ Funcionalidades Destacadas
1.  **Guía Interactiva (Onboarding)**: Sistema de 6 pantallas con bloqueo de interacción que explica Personajes, Mundos, Coleccionables e Información.
2.  **Easter Egg de Vídeo**: Activación por interacción múltiple (triple clic) en la lista de mundos.
3.  **Easter Egg Canvas**: Animación avanzada de brillo, cambio de color e intensidad progresiva en el cetro de Ripto mediante pulsación prolongada.
4.  **Persistencia de Estado**: Sistema que garantiza que la guía se muestre únicamente en la primera ejecución de la app.

## ⚙️ Instrucciones de Uso
1.  **Clonación**:
    ```bash
    git clone [https://github.com/black-cat-17/Tarea4_CondadoAlcantarilla_Irene.git](https://github.com/black-cat-17/Tarea4_CondadoAlcantarilla_Irene.git)