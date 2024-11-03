<%-- 
    Document   : editarPrestamo
    Created on : 3/11/2024, 8:48:43 a. m.
    Author     : amaya
--%>
<%@page import="Logica.Prestamo"%>
<%@page import="Logica.Estudiante"%>
<%@page import="Logica.Libro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Prestamo</title>
    </head>
    <body>
        <% Prestamo prest = (Prestamo) request.getSession().getAttribute("prestEditar");%>
        <h1>Datos del Prestamo</h1>
        <button onclick="location.href = 'index.jsp'">Menu</button>
        <form action="SVEditar_Prestamo" method="POST">

            <p><label>Id estudiante</label><input type="text" name="id_estudiante_fk"value="<%=prest.getEstu().getId_estudiante()%>" readonly></p> 
            <p><label>Id libro</label><input type="text" name="id_libro_fk"value="<%=prest.getLib().getId_libro()%>" readonly></p>
            <p><label>Fecha de solicitud </label><input type="date" name="fecha_solicitud"value="<%=prest.getFecha_solicitud()%>"></p> 
            <p><label>Fecha de entrega </label><input type="date" name="fecha_entrega"value="<%=prest.getFecha_entrega()%>"></p> 
            <p><label>Fecha de inicio </label><input type="date" name="fecha_inicio"value="<%=prest.getFecha_inicio()%>"></p> 
            <button type="submit">Guardar</button>



        </form>
    </body>
</html>
