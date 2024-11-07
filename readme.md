# Proyecto de Login y Registro en Java

## Descripción
Este es un proyecto de un sistema de login y registro desarrollado en Java utilizando MySQL y una interfaz gráfica con Swing.

## Requisitos
- JDK 23 o superior.
- MySQL instalado.
- Conector JDBC para MySQL (`mysql-connector-java`).
- Una base de datos MySQL configurada con una tabla de usuarios.

## Instrucciones

1. **Configurar la base de datos:**
   - Crea una base de datos llamada `login_db` en MySQL.
   - Ejecuta el siguiente script SQL para crear la tabla de usuarios:
     ```sql
     CREATE TABLE users (
         id INT AUTO_INCREMENT PRIMARY KEY,
         username VARCHAR(50) NOT NULL,
         password VARCHAR(100) NOT NULL
     );
     ```

2. **Configurar el proyecto:**
   - Descarga o clona el repositorio.
   - Si usas un IDE como IntelliJ IDEA o Eclipse, abre el proyecto y asegúrate de tener la biblioteca JDBC de MySQL (`mysql-connector-java`) en el classpath del proyecto.

3. **Ejecutar el proyecto:**
   - Ejecuta el archivo `main.java.ui.RegisterForm` para acceder al formulario de registro.
   - Luego, ejecuta el archivo `main.java.ui.LoginForm` para iniciar sesión.

4. **Revisar el código:**
   - Si necesitas modificar o entender cómo funciona el código, revisa los archivos en las carpetas `ui`, `dao`, `database`, etc.

## Problemas conocidos:
   - Si la conexión a la base de datos no está configurada correctamente, puede aparecer un error de conexión.

## Autor
Andres Ricardo Bateca Jaimes
