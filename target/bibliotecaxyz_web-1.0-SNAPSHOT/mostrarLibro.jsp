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
        <%
            List<Libro> listaLibro = (List) request.getSession().getAttribute("listaLibro");
            int cont = 1;
            for (Libro lib : listaLibro) {%>

        <p><b>Libro # <%=cont%></b></p>
        <p>ID : <%=lib.getId_libro()%></p>
        <p>Nombre : <%=lib.getNombre()%></p>
        <p>Autor : <%=lib.getAutor()%></p>
        <p>Idioma : <%=lib.getIdioma()%></p>
        <p>Genero : <%=lib.getGenero()%></p>
        <p>Fecha de publicacion : <%=lib.getFecha_publicacion()%></p>
        <p>Inventario : <%=lib.getInventario()%></p>
        <p>Editorial : <%=lib.getEditorial()%></p>
        <p>--------------------------</p>
        <% cont = cont + 1;
            }%>
        <button onclick="location.href = 'libro.jsp'">Libros</button>

    </body>
</html>
