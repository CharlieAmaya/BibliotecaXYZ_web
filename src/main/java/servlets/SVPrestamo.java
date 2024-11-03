/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import Logica.Controladora;
import Logica.Estudiante;
import Logica.Libro;
import Logica.Pedido_nuevolibro;
import Logica.Prestamo;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author amaya
 */
@WebServlet(name = "SVPrestamo", urlPatterns = {"/SVPrestamo"})
public class SVPrestamo extends HttpServlet {

    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Prestamo> listaPrestamo = new ArrayList<>();
        listaPrestamo = control.traerPrestamos();

        HttpSession misesion = request.getSession();
        misesion.setAttribute("listaPrestamo", listaPrestamo);

        response.sendRedirect("mostrarPrestamo.jsp");
    }

    public static Date convertirStringADate(String fechaEnString, String formato) {
        SimpleDateFormat sdf = new SimpleDateFormat(formato);
        Date fecha = null;
        try {
            fecha = sdf.parse(fechaEnString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return fecha;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String formato = "yyyy-MM-dd";

        int id_estudiante = Integer.parseInt(request.getParameter("id_estudiante_fk"));
        int id_libro = Integer.parseInt(request.getParameter("id_libro_fk"));

        Date fecha_solicitud = convertirStringADate(request.getParameter("fecha_solicitud"), formato);
        Date fecha_entrega = convertirStringADate(request.getParameter("fecha_entrega"), formato);
        Date fecha_inicio = convertirStringADate(request.getParameter("fecha_inicio"), formato);

        Estudiante estu = control.traerEstudiante_s(id_estudiante);
        Libro lib = control.traerLibro(id_libro);

        Prestamo prest = new Prestamo();

        prest.setEstu(estu);
        prest.setLib(lib);
        prest.setFecha_entrega(fecha_entrega);
        prest.setFecha_inicio(fecha_inicio);
        prest.setFecha_solicitud(fecha_solicitud);
        
        
        control.crearPrestamo(prest);
        response.sendRedirect("prestamo.jsp");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
