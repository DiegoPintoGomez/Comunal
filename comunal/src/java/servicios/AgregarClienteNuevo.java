/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import Model.dao.ServicioCliente;
import Model.dao.ServicioUsuario;
import Objetos.Contrasenna;
import Objetos.Usuario;
import Objetos.cliente;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lenovo
 */
@WebServlet(name = "AgregarClienteNuevo", urlPatterns = {"/AgregarClienteNuevo"})
public class AgregarClienteNuevo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String id = request.getParameter("Cedula");
            String nombre = request.getParameter("Nombre");
            String apellidos = request.getParameter("Apellidos");
            String telefono = request.getParameter("Telefono");
            String Usuario = request.getParameter("Usuario");
            int rol = Integer.parseInt(request.getParameter("Rol"));
            String clave = Contrasenna.getPassword();
            int clave2 = 1;

            Usuario u = new Usuario(Usuario, clave, clave2, rol);
            cliente c = new cliente(id, Usuario, nombre, apellidos, telefono);
            ServicioUsuario su = new ServicioUsuario();
            ServicioCliente sc = new ServicioCliente();
            su.insertarUsuario(u);
            sc.insertarCliente(c);
            request.setAttribute("Us", Usuario);
            request.setAttribute("Clave", clave);
            RequestDispatcher dispatcher = request.getRequestDispatcher("ExitosaCajero.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {

        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(
                "Login.jsp");
        dispatcher.forward(request, response);
    }
    //jkdhjdhdhdhdhdhd

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
