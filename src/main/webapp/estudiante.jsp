<%-- Document : index Created on : 27/10/2024, 5:16:59 p. m. Author : amaya --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Formulario Estudiante</title>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
      crossorigin="anonymous"
    ></script>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
      crossorigin="anonymous"
    />
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
      form {
        background-color: white;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
        width: 100%;
        max-width: 500px;
        margin: 0 auto;
      }
    </style>
  </head>
  <body>
       <!-- Validacion-->
        <% HttpSession misession = request.getSession();
            String usuario = (String) request.getSession().getAttribute("usuario");
            if (usuario == null) {
            response.sendRedirect("sinlogin.jsp");
            }

        %>
    <header>Biblioteca Virtual</header>
    <nav>
      <a href="libro.jsp">Edicion de libro</a>
      <a href="index.jsp">Menu Inicio</a>
      <a href="pedidoNuevoLibro.jsp">Solicitar Libros Nuevos</a>
      <a href="prestamo.jsp">Solicitar un prestamo de Libros</a>
    </nav>

    <h1>Datos del estudiante</h1>
    <form action="SVEstudiantes" method="POST">
      <div class="mb-3">
        <label class="form-check-label">nombre estudiante</label
        ><input type="text" name="nombre" class="form-control" />
      </div>
      <div class="mb-3">
        <label class="form-check-label">edad estudiante</label
        ><input type="text" name="edad" class="form-control" />
      </div>
      <div class="mb-3">
        <label class="form-check-label">correo estudiante</label
        ><input type="text" name="correo" class="form-control" />
      </div>
      <div class="mb-3">
        <label class="form-check-label">num contacto estudiante</label
        ><input type="text" name="num_contacto" class="form-control" />
      </div>
      <button type="submit" class="btn btn-primary">Enviar</button>
    </form>

    <h1
      style="
        display: flex;
        justify-content: center;
        align-items: center;
        flex-direction: column;
      "
    >
      Ver datos
    </h1>
    <form action="SVEstudiantes" method="GET">
      <button type="submit" class="btn btn-primary">mostrar datos</button>
    </form>
  </body>
</html>
