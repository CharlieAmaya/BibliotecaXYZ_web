/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import Logica.Controladora;
import Logica.Estudiante;
import Logica.Pedido_nuevolibro;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author amaya
 */
@WebServlet(name = "SVEditar_Estudiante", urlPatterns = {"/SVEditar_Estudiante"})
public class SVEditar_Estudiante extends HttpServlet {

    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id_editar = Integer.parseInt(request.getParameter("id_estudianteEdit"));
        Estudiante estu = control.traerEstudiante_s(id_editar);

        HttpSession misesion = request.getSession();
        misesion.setAttribute("estuEditar", estu);

        response.sendRedirect("editarEstudiante.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //String id_estudiante = request.getParameter("id_estudiante");
        String nombre = request.getParameter("nombre");
        String edad = request.getParameter("edad");
        String correo = request.getParameter("correo");
        String num_contacto = request.getParameter("num_contacto");

        Estudiante estu = (Estudiante) request.getSession().getAttribute("estuEditar");
        //List<Pedido_nuevolibro> pNL = estu.getListaPedidosNL();

       // List<Pedido_nuevolibro> pNL = estu.getListaPedidosNL(); 
       // estu.setListaPedidosNL(pNL);
        
        //estu.setId_estudiante(id_estudiante);
        estu.setNombre(nombre);
        estu.setEdad(edad);
        estu.setCorreo(correo);
        estu.setNum_contacto(num_contacto);
        
        System.out.println("Nombre estudiante" + nombre);
        //System.out.println("Lista" + pNL);
        
       
        
        
        //estu.setListaPedidosNL(pNL);
       

        control.editarEstudiante(estu);
        response.sendRedirect("index.jsp");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
