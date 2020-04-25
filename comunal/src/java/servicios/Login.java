/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import Model.dao.ServicioCliente;
import Model.dao.ServicioUsuario;
import Objetos.Usuario;
import Objetos.cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Lenovo
 */
@WebServlet(name = "Login", urlPatterns = {"/Login", "/Cerrar", "/CambioC"})
public class Login extends HttpServlet {

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
        if (request.getServletPath().equals("/Cerrar")) {
            HttpSession sesion = request.getSession();
            sesion.invalidate();
            RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
            dispatcher.forward(request, response);
        } else if (request.getServletPath().equals("/CambioC")) {
            HttpSession sesion = request.getSession();
            String u = sesion.getAttribute("usuario").toString();
            ServicioUsuario su = new ServicioUsuario();
            Optional<Usuario> usu = su.obtenerUsuario(u);
            if (usu.get().getClave_acceso().equals(request.getParameter("ClaveVieja"))) {
                su.actualizaClave(request.getParameter("ClaveNueva"), u);
                ServicioCliente sc = new ServicioCliente();
                Optional<cliente> c = sc.obtenerCliente_id_usuario(u);
                sesion.setAttribute("nombre", c.get().getNombre());
                sesion.setAttribute("apellidos", c.get().getApellidos());

                RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
                dispatcher.forward(request, response);
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("ErrorInicio.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            try {
                String id = request.getParameter("id");
                String clave = request.getParameter("clave");
                ServicioUsuario su = new ServicioUsuario();
                Optional<Usuario> u = su.obtenerUsuario(id);
                if (u.get().getClave_acceso().equals(clave)) {
                    if (u.get().getClave_vencida() == 1) {
                        HttpSession sesion = request.getSession(true);
                        sesion.setAttribute("usuario", id);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("CambioClave.jsp");
                        dispatcher.forward(request, response);
                    }
                    if (u.get().getRol() == 1) {
                        HttpSession sesion = request.getSession(true);
                        sesion.setAttribute("usuario", id);
                        ServicioCliente sc = new ServicioCliente();
                        Optional<cliente> c = sc.obtenerCliente_id_usuario(id);
                        sesion.setAttribute("nombre", c.get().getNombre());
                        sesion.setAttribute("apellidos", c.get().getApellidos());

                        RequestDispatcher dispatcher = request.getRequestDispatcher("InicialCajero.jsp");
                        dispatcher.forward(request, response);
                    }
                    if (u.get().getRol() == 2) {
                        HttpSession sesion = request.getSession(true);
                        sesion.setAttribute("usuario", id);
                        ServicioCliente sc = new ServicioCliente();
                        Optional<cliente> c = sc.obtenerCliente_id_usuario(id);
                        sesion.setAttribute("nombre", c.get().getNombre());
                        sesion.setAttribute("apellidos", c.get().getApellidos());
                        sesion.setAttribute("Cliente", c.get().getId_cliente());
                        RequestDispatcher dispatcher = request.getRequestDispatcher("InicialCliente.jsp");
                        dispatcher.forward(request, response);
                    } else {
                        RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
                        dispatcher.forward(request, response);
                    }
                } else {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("ErrorInicio.jsp");
                    dispatcher.forward(request, response);
                }
            } catch (Exception e) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("ErrorInicio.jsp");
                dispatcher.forward(request, response);
            }
        }

    }

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
