/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import Logica.Controladora;
import Logica.Estudiante;
import Logica.Libro;
import Logica.Prestamo;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Date;
import static servlets.SVPrestamo.convertirStringADate;

/**
 *
 * @author amaya
 */
@WebServlet(name = "SVEditar_Prestamo", urlPatterns = {"/SVEditar_Prestamo"})
public class SVEditar_Prestamo extends HttpServlet {

    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id_editar = Integer.parseInt(request.getParameter("id_Prestamo_Edit"));
        Prestamo prest = control.traerPrestamo(id_editar);

        HttpSession misesion = request.getSession();
        misesion.setAttribute("prestEditar", prest);

        response.sendRedirect("editarPrestamo.jsp");

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

        Prestamo prest = (Prestamo) request.getSession().getAttribute("prestEditar");

        prest.setEstu(estu);
        prest.setLib(lib);
        prest.setFecha_entrega(fecha_entrega);
        prest.setFecha_inicio(fecha_inicio);
        prest.setFecha_solicitud(fecha_solicitud);

        control.editarPrestamo(prest);
        response.sendRedirect("prestamo.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
