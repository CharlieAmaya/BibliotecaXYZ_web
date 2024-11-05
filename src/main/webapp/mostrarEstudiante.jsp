<%-- 
    Document   : mostrarEstudiante
    Created on : 27/10/2024, 7:02:04 p. m.
    Author     : amaya
--%>

<%@page import="java.util.List"%>
<%@page import="Logica.Estudiante"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Datos Estudiante</title>
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
        </style>
    </head>
    <body>
        <header>Biblioteca Virtual</header>
        <nav>
            <a href="libro.jsp">Edicion de libro</a>
            <a href="index.jsp">Menu Inicio</a>
            <a href="pedidoNuevoLibro.jsp">Solicitar Libros Nuevos</a>
            <a href="prestamo.jsp">Solicitar un prestamo de Libros</a>
        </nav>

        <h1>Lista de Estudiantes</h1>
        <table class="table table-striped"> 
            <thead> 
                <tr> 
                    <th scope="col">ID</th> 
                    <th scope="col">Nombre</th> 
                    <th scope="col">Edad</th> 
                    <th scope="col">Correo</th> 
                    <th scope="col">Numero de Contacto</th> 
                </tr> 
            </thead> 
            <tbody class="table-group-divider"> 

        <%
            List<Estudiante> listaEstudiantes = (List) request.getSession().getAttribute("listaEstudiantes");
            int cont = 1;
            for (Estudiante estu : listaEstudiantes) {%>

       
                <tr> 
                    <td scope="row"><%=estu.getId_estudiante()%></td> 
                    <td ><%=estu.getNombre()%></td> 
                    <td ><%=estu.getEdad()%></td> 
                    <td ><%=estu.getCorreo()%></td> 
                    <td ><%=estu.getNum_contacto()%></td> 
                    <td style="display:flex; width: 200px">
                        <div class="btn-group" role="group">
                            <form name="eliminar" action="SVEliminar_Estudiante" method="POST">
                                <button type="submit"  class="btn btn-danger">Eliminar</button>
                                <input type="hidden" name="id_estudiante" value="<%=estu.getId_estudiante()%>"><!-- Enviar datos a eliminar -->
                            </form> 
                            <form name="editar" action="SVEditar_Estudiante" method="GET">
                                <button type="submit"class="btn btn-warning">Editar</button>
                                <input type="hidden" name="id_estudianteEdit" value="<%=estu.getId_estudiante()%>"><!-- Enviar datos a editar -->
                            </form>
                        </div> 
                    </td> 
                </tr> <!-- Agrega más filas aquí -->
                <% cont = cont + 1;
            }%>

            </tbody>
        </table>
       
        <footer>
            <p>&copy; 2024 Biblioteca Virtual. Todos los derechos reservados.</p>
        </footer>
    </body>
</html>
