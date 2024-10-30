/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import Logica.Controladora;
import Logica.Libro;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author amaya
 */
@WebServlet(name = "SVLibro", urlPatterns = {"/SVLibro"})
public class SVLibro extends HttpServlet {

    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Libro> listaLibro = new ArrayList<>();
        listaLibro = control.traerLibros();

        HttpSession misesion = request.getSession();
        misesion.setAttribute("listaLibro", listaLibro);

        response.sendRedirect("mostrarLibro.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //String id_libro = request.getParameter("id_libro");
        String nombre = request.getParameter("nombre");
        String autor = request.getParameter("autor");
        String idioma = request.getParameter("idioma");
        String genero = request.getParameter("genero");
        Date fecha_publicacion = null;

        String stringfecha_public = request.getParameter("fecha_public");
        int inventario = Integer.parseInt(request.getParameter("inventario"));
        String editorial = request.getParameter("editorial");

        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        try {
            fecha_publicacion = formato.parse(stringfecha_public);
            response.getWriter().println("Fecha convertida");
        } catch (ParseException e) {
            e.printStackTrace();
            response.getWriter().println("Error al convertir la fecha.");
        }

        Libro Lib = new Libro();

        //estu.setId_estudiante(id_estudiante);
        Lib.setNombre(nombre);
        Lib.setAutor(autor);
        Lib.setGenero(genero);
        Lib.setIdioma(idioma);
        Lib.setInventario(inventario);
        Lib.setFecha_publicacion(fecha_publicacion);
        Lib.setEditorial(editorial);

        control.crearLibro(Lib);
        response.sendRedirect("libro.jsp");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
