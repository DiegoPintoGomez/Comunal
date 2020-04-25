
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import Model.dao.ServicioCliente;
import Model.dao.ServicioCuenta;
import Model.dao.ServicioTipo_Cuenta;
import Model.dao.ServicioUsuario;
import Objetos.Contrasenna;
import Objetos.Cuenta;
import Objetos.Usuario;
import Objetos.cliente;
import Objetos.tipo_cuenta;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;
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
@WebServlet(name = "AgregarCuenta", urlPatterns = {"/AgregarCuenta"})
public class AgregarCuenta extends HttpServlet {

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
        
        int Cliente =Integer.valueOf( request.getParameter("Cliente"));
        String Cedula = request.getParameter("Cedula");
        
        if(Cliente==1){
            int clave2=1;
            String clave=Contrasenna.getPassword();
           String usuario =request.getParameter("Usuario");
           
            Usuario usu = new Usuario(usuario,clave,clave2,2);
            
            ServicioUsuario su=new ServicioUsuario();
            
            su.insertarUsuario(usu);
            
            cliente cli = new cliente();
            cli.setId_usuario(usuario);
            
            
            String nombre = request.getParameter("Nombre");
            String apellidos = request.getParameter("Apellidos");
            String telefono = request.getParameter("Telefono");
            
        
            cli.setId_cliente(Cedula);
            cli.setApellidos(apellidos);
            cli.setNombre(nombre);
            cli.setTelefono(telefono);
        
            ServicioCliente SC = new ServicioCliente();
            SC.insertarCliente(cli);
            
            request.setAttribute("Us", usuario);
            request.setAttribute("Clave", clave);
        }
        
        double limite = Integer.valueOf(request.getParameter("limite"));
        String moneda = request.getParameter("moneda");
        
        int tipo =Integer.valueOf( request.getParameter("TipoCuenta"));
        
        ServicioTipo_Cuenta  STC= new ServicioTipo_Cuenta();
        
        Optional<tipo_cuenta> tc = STC.obtenertipo_cuenta(tipo);
        
        ServicioCuenta SC= new ServicioCuenta();
        
        Cuenta cu = new Cuenta();
        
        cu.setCliente_id_cliente(Cedula);
        cu.setLimite_transferencia_diaria(limite);
        cu.setMoneda_nombre(moneda);
        cu.setTipo_cuenta_id_tipo_cuenta(tipo);
        
        SC.insertarCuenta(cu);
       
       
            RequestDispatcher dispatcher = request.getRequestDispatcher("ExitosaCajero.jsp");
            dispatcher.forward(request, response);
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
