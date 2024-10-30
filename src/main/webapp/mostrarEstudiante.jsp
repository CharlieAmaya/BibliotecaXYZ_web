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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Formulario de prueba MOSTRAR</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body>
        <h1>Lista de Estudiantes</h1>
        <%
            List<Estudiante> listaEstudiantes = (List) request.getSession().getAttribute("listaEstudiantes");
            int cont = 1;
            for (Estudiante estu : listaEstudiantes) {%>

        <p><b>Estudiante # <%=cont%></b></p>
        <p>ID : <%=estu.getId_estudiante()%></p>
        <p>Nombre : <%=estu.getNombre()%></p>
        <p>Edad : <%=estu.getEdad()%></p>
        <p>Correo : <%=estu.getCorreo()%></p>
        <p>Numero de Contacto<%=estu.getNum_contacto()%></p>
        <p>--------------------------</p>
        <% cont = cont + 1;
            }%>
        <button onclick="location.href = 'index.jsp'">Estudiante</button>

    </body>
</html>
