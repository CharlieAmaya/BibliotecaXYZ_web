<%-- 
    Document   : index
    Created on : 27/10/2024, 5:16:59 p. m.
    Author     : amaya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Formulario de prueba</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body>

        <button onclick="location.href = 'index.jsp'">Menu</button>

        <h1>Datos del estudiante</h1>
        <form action="SVEstudiantes" method="POST">

            <p><label>nombre estudiante</label><input type="text" name="nombre"></p>
            <p><label>edad estudiante</label><input type="text" name="edad"></p>
            <p><label>correo estudiante</label><input type="text" name="correo"></p>
            <p><label>num contacto estudiante</label><input type="text" name="num_contacto"></p>
            <button type="submit">Enviar</button>
        </form>

        <h1>Ver datos</h1>
        <form action="SVEstudiantes" method="GET">

            <button type="submit">mostrar datos</button>
        </form>

    </body>
</html>