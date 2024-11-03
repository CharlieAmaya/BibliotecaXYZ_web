/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import Logica.Controladora;
import Logica.Estudiante;
import Logica.Libro;
import Logica.Pedido_nuevolibro;
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
@WebServlet(name = "SVPedidoNuevoLibro", urlPatterns = {"/SVPedidoNuevoLibro"})
public class SVPedidoNuevoLibro extends HttpServlet {

    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Pedido_nuevolibro> listaPedidoNuevoLibro = new ArrayList<>();
        listaPedidoNuevoLibro = control.traerPedidoNuevoLibros();

        HttpSession misesion = request.getSession();
        misesion.setAttribute("listaPedidoNuevoLibro", listaPedidoNuevoLibro);

        response.sendRedirect("mostrarPedidoNuevoLibro.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String formato = "yyyy-MM-dd";

        int id_estudiante = Integer.parseInt(request.getParameter("id_estudiante_fk"));
        String nombre = request.getParameter("nombre");
        String autor = request.getParameter("autor");
        String estado = request.getParameter("estado");

        Date fecha_solicitud = SVPrestamo.convertirStringADate(request.getParameter("fecha_solicitud"), formato);

        String editorial = request.getParameter("editorial");

        Estudiante estu = control.traerEstudiante_s(id_estudiante);

        Pedido_nuevolibro pNL = new Pedido_nuevolibro();

        pNL.setEstu(estu);

        pNL.setNombreLibro(nombre);
        pNL.setAutor(autor);
        pNL.setFecha_solicitud(fecha_solicitud);
        pNL.setEditorial(editorial);
        pNL.setEstado(estado);

        control.crearPedidoNuevoLibro(pNL);
        response.sendRedirect("pedidoNuevoLibro.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
