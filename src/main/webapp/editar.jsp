<%-- 
    Document   : editar
    Created on : 28/10/2024, 8:01:35 p. m.
    Author     : amaya
--%>

<%@page import="Logica.Estudiante"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Estudiante</title>
    </head>
    <body>
        <% Estudiante estu = (Estudiante) request.getSession().getAttribute("estuEditar"); %>
        <h1>Datos del estudiante</h1>
        <form action="SVEditar" method="POST">

            <p><label>nombre estudiante</label><input type="text" name="nombre" value="<%=estu.getNombre()%>"></p>
            <p><label>edad estudiante</label><input type="text" name="edad" value="<%=estu.getEdad()%>"></p>
            <p><label>correo estudiante</label><input type="text" name="correo" value="<%=estu.getCorreo()%>"></p>
            <p><label>num contacto estudiante</label><input type="text" name="num_contacto" value="<%=estu.getNum_contacto()%>"></p>
            <button type="submit">Guardar</button>
        </form>
    </body>
</html>
