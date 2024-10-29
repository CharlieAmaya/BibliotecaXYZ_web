/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import Logica.Controladora;
import Logica.Estudiante;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author amaya
 */
@WebServlet(name = "SVEstudiantes", urlPatterns = {"/SVEstudiantes"})
public class SVEstudiantes extends HttpServlet {

    Controladora control = new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Estudiante>listaEstudiantes = new ArrayList<>();
        listaEstudiantes = control.traerEstudiante();
        
        HttpSession misesion = request.getSession();
        misesion.setAttribute("listaEstudiantes", listaEstudiantes);
        
        response.sendRedirect("mostrarEstudiante.jsp");
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //String id_estudiante = request.getParameter("id_estudiante");
        String nombre = request.getParameter("nombre");
        String edad = request.getParameter("edad");
        String correo = request.getParameter("correo");
        String num_contacto = request.getParameter("num_contacto");
        
        Estudiante estu = new Estudiante();
        
        //estu.setId_estudiante(id_estudiante);
        estu.setNombre(nombre);
        estu.setEdad(edad);
        estu.setCorreo(correo);
        estu.setNum_contacto(num_contacto);
        
        control.crearEstudiante(estu);
        response.sendRedirect("index.jsp");
        
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
