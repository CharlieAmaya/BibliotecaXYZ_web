<%@page import="java.util.List"%>
<%@page import="Logica.Pedido_nuevolibro"%>
<%@page import="Logica.Estudiante"%>
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
        <h1>Lista de Pedidos</h1>
        <button onclick="location.href = 'index.jsp'">Menu</button>
        <%
            List<Pedido_nuevolibro> listaPedidoNuevoLibro = (List) request.getSession().getAttribute("listaPedidoNuevoLibro");
            int cont = 1;
            for (Pedido_nuevolibro pNL : listaPedidoNuevoLibro) {%>

        <table style="border: 1px solid black; border-collapse: collapse;"> 
            <thead> 
                <tr> 
                    <th style="border: 1px solid black;">ID</th> 
                    <th style="border: 1px solid black;">ID estudiante</th> 
                    <th style="border: 1px solid black;">Fecha de Solicitud</th> 
                    <th style="border: 1px solid black;">Estado</th> 
                    <th style="border: 1px solid black;">Nombre Libro</th> 
                    <th style="border: 1px solid black;">Editorial</th> 
                    <th style="border: 1px solid black;">Autor</th> 
                    <th style="border: 1px solid black;">Acción</th> 
                </tr> 
            </thead> 
            <tbody> 
                <tr> 
                    <td style="border: 1px solid black;"><%=pNL.getId_pedidoNuevoLibro()%></td> 
                    <td style="border: 1px solid black;"><%=pNL.getEstu().getId_estudiante()%></td> 
                    <td style="border: 1px solid black;"><%=pNL.getFecha_solicitud()%></td> 
                    <td style="border: 1px solid black;"><%=pNL.getEstado()%></td> 
                    <td style="border: 1px solid black;"><%=pNL.getNombreLibro()%></td> 
                    <td style="border: 1px solid black;"><%=pNL.getEditorial()%></td> 
                    <td style="border: 1px solid black;"><%=pNL.getAutor()%></td> 

                    <td style="display:flex; width: 230px">
                        <form name="eliminar" action="SVEliminar_PedidoNuevoLibro" method="POST">
                            <button type="submit">Eliminar</button>
                            <input type="hidden" name="id_PedidoNuevoLibro" value="<%=pNL.getId_pedidoNuevoLibro()%>"><!-- Enviar datos a eliminar -->
                        </form> 
                        <form name="editar" action="SVEditar_PedidoNuevoLibro" method="GET">
                            <button type="submit">Editar</button>
                            <input type="hidden" name="id_PedidoNuevoLibro_Edit" value="<%=pNL.getId_pedidoNuevoLibro()%>"><!-- Enviar datos a editar -->
                        </form> 
                    </td> 
                </tr> <!-- Agrega más filas aquí -->
            </tbody>
        </table>

        <% cont = cont + 1;
            }%>
        

    </body>
</html>
