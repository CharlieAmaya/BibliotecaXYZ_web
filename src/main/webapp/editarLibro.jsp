<%-- 
    Document   : editarLibro
    Created on : 29/10/2024, 9:33:27 p. m.
    Author     : amaya
--%>

<%@page import="Logica.Libro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Libro</title>
    </head>
    <body>
        <% Libro lib = (Libro) request.getSession().getAttribute("libEditar"); %>
        <h1>Datos del Libro</h1>
        <form action="SVEditar_libro" method="POST">

            
            <p><label>Nombre libro </label><input type="text" name="nombre"value="<%=lib.getNombre()%>"></p>
            <p><label>Autor </label><input type="text" name="autor"value="<%=lib.getAutor()%>"></p>
            <p><label>Idioma </label><input type="text" name="idioma"value="<%=lib.getIdioma()%>"></p>
            <p><label>Genero </label><input type="text" name="genero"value="<%=lib.getGenero()%>"></p>
            <p><label>Fecha de publicacion </label><input type="date" name="fecha_public"value="<%=lib.getFecha_publicacion()%>"></p>
            <p><label>Inventario </label><input type="text" name="inventario"value="<%=lib.getInventario()%>"></p>
            <p><label>Editorial </label><input type="text" name="editorial"value="<%=lib.getEditorial()%>"></p>
            <button type="submit">Guardar</button>
            <button onclick="location.href = 'libro.jsp'">Libros</button>
        </form>
    </body>
</html>
