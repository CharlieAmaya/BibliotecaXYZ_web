<%-- 
    Document   : pedidoNuevoLibro
    Created on : 31/10/2024, 7:58:02 p. m.
    Author     : amaya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario Pedido nuevo libro</title>
    </head>
    <body>
        <button onclick="location.href = 'index.jsp'">Menu</button>

        <h1>Crea un nuevo Pedido</h1>
        <form action="SVPedidoNuevoLibro" method="POST">

            <p><label>Id estudiante</label><input type="text" name="id_estudiante_fk"></p>
            <p><label>Nombre libro </label><input type="text" name="nombre"></p>
            <p><label>Autor </label><input type="text" name="autor"></p>
            <p><label>Estado </label><input type="text" name="estado"></p>
            <p><label>Fecha de solicitud </label><input type="date" name="fecha_solicitud"></p>
            <p><label>Editorial </label><input type="text" name="editorial"></p>
            <button type="submit">Enviar</button>
        </form>

        <h1>Ver datos</h1>
        <form action="SVPedidoNuevoLibro" method="GET">

            <button type="submit">mostrar datos</button>
        </form>

    </body>
</html>