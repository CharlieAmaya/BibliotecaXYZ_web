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
        <button onclick="location.href = 'index.jsp'">Menu</button>
        <%
            List<Estudiante> listaEstudiantes = (List) request.getSession().getAttribute("listaEstudiantes");
            int cont = 1;
            for (Estudiante estu : listaEstudiantes) {%>

        <table style="border: 1px solid black; border-collapse: collapse;"> 
            <thead> 
                <tr> 
                    <th style="border: 1px solid black;">ID</th> 
                    <th style="border: 1px solid black;">Nombre</th> 
                    <th style="border: 1px solid black;">Edad</th> 
                    <th style="border: 1px solid black;">Correo</th> 
                    <th style="border: 1px solid black;">Numero de Contacto</th> 
                </tr> 
            </thead> 
            <tbody> 
                <tr> 
                    <td style="border: 1px solid black;"><%=estu.getId_estudiante()%></td> 
                    <td style="border: 1px solid black;"><%=estu.getNombre()%></td> 
                    <td style="border: 1px solid black;"><%=estu.getEdad()%></td> 
                    <td style="border: 1px solid black;"><%=estu.getCorreo()%></td> 
                    <td style="border: 1px solid black;"><%=estu.getNum_contacto()%></td> 
                    <td style="display:flex; width: 230px">
                        <form name="eliminar" action="SVEliminar_Estudiante" method="POST">
                            <button type="submit">Eliminar</button>
                            <input type="hidden" name="id_estudiante" value="<%=estu.getId_estudiante()%>"><!-- Enviar datos a eliminar -->
                        </form> 
                        <form name="editar" action="SVEditar_Estudiante" method="GET">
                            <button type="submit">Editar</button>
                            <input type="hidden" name="id_estudianteEdit" value="<%=estu.getId_estudiante()%>"><!-- Enviar datos a editar -->
                        </form> 
                    </td> 
                </tr> <!-- Agrega más filas aquí -->
            </tbody>
        </table>
        <% cont = cont + 1;
            }%>


    </body>
</html>
