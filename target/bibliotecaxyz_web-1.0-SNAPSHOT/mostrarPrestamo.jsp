<%@page import="java.util.List"%>
<%@page import="Logica.Prestamo"%>
<%@page import="Logica.Estudiante"%>
<%@page import="Logica.Libro"%>
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
        <h1>Lista de Prestamos</h1>
        <button onclick="location.href = 'index.jsp'">Menu</button>
        <%
            List<Prestamo> listaPrestamos = (List) request.getSession().getAttribute("listaPrestamo");
            int cont = 1;
            for (Prestamo prest : listaPrestamos) {%>

        <table style="border: 1px solid black; border-collapse: collapse;"> 
            <thead> 
                <tr> 
                    <th style="border: 1px solid black;">ID Prestamo</th> 
                    <th style="border: 1px solid black;">ID estudiante</th> 
                    <th style="border: 1px solid black;">ID libro</th> 
                    <th style="border: 1px solid black;">Fecha de Solicitud</th> 
                    <th style="border: 1px solid black;">Fecha de Entrega</th> 
                    <th style="border: 1px solid black;">Fecha de Inicio</th> 
                    <th style="border: 1px solid black;">Acción</th> 
                </tr> 
            </thead> 
            <tbody> 
                <tr> 
                    <td style="border: 1px solid black;"><%=prest.getId_prestamo()%></td> 
                    <td style="border: 1px solid black;"><%=prest.getEstu().getId_estudiante()%></td> 
                    <td style="border: 1px solid black;"><%=prest.getLib().getId_libro()%></td> 
                    <td style="border: 1px solid black;"><%=prest.getFecha_solicitud()%></td> 
                    <td style="border: 1px solid black;"><%=prest.getFecha_entrega()%></td> 
                    <td style="border: 1px solid black;"><%=prest.getFecha_inicio()%></td> 

                    <td style="display:flex; width: 230px">
                        <form name="eliminar" action="SVEliminar_Prestamo" method="POST">
                            <button type="submit">Eliminar</button>
                            <input type="hidden" name="id_Prestamo" value="<%=prest.getId_prestamo()%>"><!-- Enviar datos a eliminar -->
                        </form> 
                        <form name="editar" action="SVEditar_Prestamo" method="GET">
                            <button type="submit">Editar</button>
                            <input type="hidden" name="id_Prestamo_Edit" value="<%=prest.getId_prestamo()%>"><!-- Enviar datos a editar -->
                        </form> 
                    </td> 
                </tr> <!-- Agrega más filas aquí -->
            </tbody>
        </table>

        <% cont = cont + 1;
            }%>


    </body>
</html>
