<%-- 
    Document   : mostrarLibro
    Created on : 29/10/2024, 8:20:19 p. m.
    Author     : amaya
--%>

<%@page import="java.util.List"%>
<%@page import="Logica.Libro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Formulario MOSTRAR</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body>
        <h1>Lista de Libros</h1>
        <button onclick="location.href = 'index.jsp'">Menu</button>
        <%
            List<Libro> listaLibro = (List) request.getSession().getAttribute("listaLibro");
            int cont = 1;
            for (Libro lib : listaLibro) {%>

        <table style="border: 1px solid black; border-collapse: collapse;"> 
            <thead> 
                <tr> 
                    <th style="border: 1px solid black;">ID</th> 
                    <th style="border: 1px solid black;">Nombre</th> 
                    <th style="border: 1px solid black;">Autor</th> 
                    <th style="border: 1px solid black;">Idioma</th> 
                    <th style="border: 1px solid black;">Genero</th> 
                    <th style="border: 1px solid black;">Fecha de Publicación</th> 
                    <th style="border: 1px solid black;">Inventario</th> 
                    <th style="border: 1px solid black;">Editorial</th> 
                    <th style="border: 1px solid black;">Acción</th> 
                </tr> 
            </thead> 
            <tbody> 
                <tr> 
                    <td style="border: 1px solid black;"><%=lib.getId_libro()%></td> 
                    <td style="border: 1px solid black;"><%=lib.getNombre()%></td> 
                    <td style="border: 1px solid black;"><%=lib.getAutor()%></td> 
                    <td style="border: 1px solid black;"><%=lib.getIdioma()%></td> 
                    <td style="border: 1px solid black;"><%=lib.getGenero()%></td> 
                    <td style="border: 1px solid black;"><%=lib.getFecha_publicacion()%></td> 
                    <td style="border: 1px solid black;"><%=lib.getInventario()%></td> 
                    <td style="border: 1px solid black;"><%=lib.getEditorial()%></td>

                    <td style="display:flex; width: 230px">
                        <form name="eliminar" action="SVEliminar_libro" method="POST">
                            <button type="submit">Eliminar</button>
                            <input type="hidden" name="id_libro" value="<%=lib.getId_libro()%>"><!-- Enviar datos a eliminar -->
                        </form> 
                        <form name="editar" action="SVEditar_libro" method="GET">
                            <button type="submit">Editar</button>
                            <input type="hidden" name="id_libroEdit" value="<%=lib.getId_libro()%>"><!-- Enviar datos a editar -->
                        </form> 
                    </td> 
                </tr> <!-- Agrega más filas aquí -->
            </tbody>
        </table>



        <% cont = cont + 1;
            }%>


    </body>
</html>
