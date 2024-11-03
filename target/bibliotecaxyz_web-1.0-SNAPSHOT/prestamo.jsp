<%-- 
    Document   : prestamo
    Created on : 3/11/2024, 8:36:57 a. m.
    Author     : amaya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario Prestamo</title>
    </head>
    <body>
        <button onclick="location.href = 'index.jsp'">Menu</button>

        <h1>Crea un nuevo prestamo</h1>
        <form action="SVPrestamo" method="POST">

            <p><label>Id estudiante</label><input type="text" name="id_estudiante_fk"></p>
            <p><label>Id libro</label><input type="text" name="id_libro_fk"></p>
            <p><label>Fecha de solicitud </label><input type="date" name="fecha_solicitud"></p>
            <p><label>Fecha de entrega</label><input type="date" name="fecha_entrega"></p>
            <p><label>Fecha de inicio</label><input type="date" name="fecha_inicio"></p>

            <button type="submit">Enviar</button>
        </form>

        <h1>Ver datos</h1>
        <form action="SVPrestamo" method="GET">

            <button type="submit">mostrar datos</button>
        </form>
    </body>
</html>
