<%-- 
    Document   : editarPedidoNuevoLibro
    Created on : 31/10/2024, 10:18:54 p. m.
    Author     : amaya
--%>

<%@page import="Logica.Pedido_nuevolibro"%>
<%@page import="Logica.Estudiante"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Pedido</title>
    </head>
    <body>
        <% Pedido_nuevolibro pNL = (Pedido_nuevolibro) request.getSession().getAttribute("pNLEditar");%>
        <h1>Datos del Pedido</h1>
        <button onclick="location.href = 'index.jsp'">Menu</button>
        <form action="SVEditar_PedidoNuevoLibro" method="POST">

            <p><label>Id estudiante</label><input type="text" name="id_estudiante_fk"value="<%=pNL.getEstu().getId_estudiante()%>" readonly></p> 
            <p><label>Nombre libro </label><input type="text" name="nombre"value="<%=pNL.getNombreLibro()%>"></p>
            <p><label>Autor </label><input type="text" name="autor"value="<%=pNL.getAutor()%>"></p>
            <p><label>Estado </label><input type="text" name="estado"value="<%=pNL.getEstado()%>"></p>
            <p><label>Fecha de solicitud </label><input type="date" name="fecha_solicitud"value="<%=pNL.getFecha_solicitud()%>"></p> 
            <p><label>Editorial </label><input type="text" name="editorial"value="<%=pNL.getEditorial()%>"></p>
            <button type="submit">Guardar</button>


             
            </form>
    </body>
</html>