# Tarea 04: Multimedia y Experiencia de Usuario - Spyro The Dragon

**BK Programación | Proyecto desarrollado por: Irene Condado Alcantarilla**

## 🐉 Introducción
Este proyecto consiste en la evolución de una aplicación Android dedicada al universo de **Spyro the Dragon**. [cite_start]El objetivo principal, marcado por nuestra jefa de equipo Ada, ha sido mejorar la retención de usuarios y la estética de la app mediante la integración de elementos multimedia avanzados[cite: 3, 7]. [cite_start]Se ha implementado una guía interactiva para facilitar el *onboarding* y diversos "Easter Eggs" para fomentar la interactividad[cite: 10, 11].

## ✨ Características Principales
- [cite_start]**Guía de Inicio Dinámica**: Un recorrido de 6 pantallas que explica las funcionalidades de Personajes, Mundos y Coleccionables mediante bocadillos informativos animados[cite: 24, 52].
- [cite_start]**Experiencia de Usuario (UX)**: Bloqueo de interacción durante el tutorial y sistema de persistencia con `SharedPreferences` para mostrar la guía únicamente en el primer acceso[cite: 48, 49].
- **Multimedia Interactiva**:
  - [cite_start]**Easter Egg de Vídeo**: Reproducción de contenido temático tras realizar tres clics consecutivos en la sección de Mundos[cite: 58, 59].
  - [cite_start]**Animación con Canvas**: Efecto visual programado que simula la energía mágica en el cetro de Ripto mediante una pulsación prolongada.
  - [cite_start]**Audio Temático**: Integración de efectos de sonido en los botones y transiciones de la guía.

## 🛠️ Tecnologías Utilizadas
- [cite_start]**Lenguaje**: Kotlin[cite: 14].
- **Arquitectura**: Navigation Component para la gestión de fragmentos y pestañas.
- [cite_start]**Gráficos**: API Canvas de Android para dibujos dinámicos.
- [cite_start]**Persistencia**: SharedPreferences para el control de estados de la app.
- [cite_start]**UI/UX**: Material Design, Animaciones XML y Layouts con transparencias[cite: 44, 52].

## ⚙️ Instrucciones de Uso
1. **Clonación**:
   ```bash
   git clone [https://github.com/black-cat-17/Tarea4_CondadoAlcantarilla_Irene.git](https://github.com/black-cat-17/Tarea4_CondadoAlcantarilla_Irene.git)
