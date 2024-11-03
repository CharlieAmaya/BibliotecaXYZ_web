<%-- 
    Document   : libro
    Created on : 29/10/2024, 7:22:33 p. m.
    Author     : amaya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario Libro</title>
    </head>
    <body>
        <button onclick="location.href = 'index.jsp'">Menu</button>

        <h1>Datos del Libro</h1>
        <form action="SVLibro" method="POST">

            <p><label>Nombre libro </label><input type="text" name="nombre"></p>
            <p><label>Autor </label><input type="text" name="autor"></p>
            <p><label>Idioma </label><input type="text" name="idioma"></p>
            <p><label>Genero </label><input type="text" name="genero"></p>
            <p><label>Fecha de publicacion </label><input type="date" name="fecha_public"></p>
            <p><label>Inventario </label><input type="text" name="inventario"></p>
            <p><label>Editorial </label><input type="text" name="editorial"></p>
            <button type="submit">Enviar</button>
        </form>

        <h1>Ver datos</h1>
        <form action="SVLibro" method="GET">

            <button type="submit">mostrar datos</button>

        </form>

    </body>
</html>
