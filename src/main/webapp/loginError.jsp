<%-- 
    Document   : login
    Created on : 10/11/2024, 6:15:20 p. m.
    Author     : amaya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Error inicio de sesion</title>
        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"
        ></script>
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
            crossorigin="anonymous"
            />
        <style>
            /* Estilos generales */
            body {
                font-family: Arial, sans-serif;
                background-color: #f5f5f5;
                color: #333;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
            }

            /* Estilos del formulario de inicio de sesión */
            form {
                background-color: white;
                padding: 20px;
                border-radius: 8px;
                box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            }

            form h2 {
                margin-bottom: 20px;
                color: #ff8c00; /* Color naranja */
            }

            form input {
                width: 100%;
                padding: 10px;
                margin-bottom: 15px;
                border: 1px solid #ccc;
                border-radius: 4px;
            }

            form button {
                background-color: #ff8c00; /* Color naranja */
                color: white;
                padding: 10px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                font-weight: bold;
                width: 100%;
            }

            form button:hover {
                background-color: #e07b00; /* Color naranja oscuro */
            }
        </style>
    </head>

    <body>
        <form >
            <h2>Nombre de usuario o contraseña incorrectos</h2>
            <a href="login.jsp" class="btn btn-primary btn-user btn-block" style="
               background-color: #ff8c00; /* Color naranja */
               color: white;
               padding: 10px;
               border: none;
               border-radius: 4px;
               cursor: pointer;
               font-weight: bold;
               width: 100%;
               ">
                Iniciar sesion

            </a>
        </form>

    </body>

</html>
