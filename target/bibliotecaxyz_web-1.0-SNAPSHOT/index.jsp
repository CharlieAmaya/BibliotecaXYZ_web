<%-- Document : index Created on : 27/10/2024, 5:16:59 p. m. Author : amaya --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Menu - Biblioteca Virtual</title>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
      crossorigin="anonymous"
    ></script>
    <style>
      /* Estilos generales */
      body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f5f5f5;
        color: #333;
      }

      /* Estilo del encabezado */
      header {
        background-color: #ff8c00; /* Color naranja */
        padding: 15px;
        text-align: center;
        color: white;
        font-size: 24px;
      }

      /* Estilo del menú de navegación */
      nav {
        background-color: #ff8c00; /* Color naranja */
        display: flex;
        justify-content: center;
        padding: 10px;
      }

      nav a {
        color: white;
        margin: 0 15px;
        text-decoration: none;
        font-size: 16px;
        font-weight: bold;
      }

      nav a:hover {
        text-decoration: underline;
      }

      /* Estilo de la sección de contenido */
      main {
        padding: 20px;
        text-align: center;
      }

      /* Estilo del pie de página */
      footer {
        background-color: #ff8c00; /* Color naranja */
        color: white;
        text-align: center;
        padding: 10px;
        position: fixed;
        width: 100%;
        bottom: 0;
      }
    </style>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
      crossorigin="anonymous"
    />
  </head>

  <body>
    <!-- Encabezado -->
    <header>Biblioteca Virtual</header>

    <nav>
      <a href="libro.jsp">Edicion de Libros</a>
      <a href="estudiante.jsp">Edicion de Estudiantes</a>
      <a href="pedidoNuevoLibro.jsp">Solicitar Libros Nuevos</a>
      <a href="prestamo.jsp">Solicitar un prestamo de Libros</a>
    </nav>

    <footer>
      <p>&copy; 2024 Biblioteca Virtual. Todos los derechos reservados.</p>
    </footer>
    <main>
      <h2>Bienvenido</h2>
      <p>
        Bienvenido a la sección de lectura de libros. Aquí podrás encontrar una
        selección de libros para leer en línea.
      </p>
      <img src="portada1.jpg" />
      <img src="portada2.jpg" />
      <img src="portada3.jpg" />
      <img src="portada4.png" />
      <!-- Aquí puedes agregar contenido específico de libros que los usuarios pueden leer -->
    </main>
  </body>
</html>
