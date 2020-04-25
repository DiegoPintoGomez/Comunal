/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import Model.dao.ServicioCliente;
import Model.dao.ServicioCuenta;
import Model.dao.ServicioMovimiento;
import Objetos.Movimiento;
import Objetos.cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author diego
 */
@WebServlet(name = "TransfereciaCajas", urlPatterns = {"/TransfereciaCajas"})
public class TransfereciaCajas extends HttpServlet {

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
            if(request.getServletPath().equals("/buscar")){
             try {
            String cuenta = request.getParameter("Cuenta");
            double monto = Double.valueOf(request.getParameter("monto"));
            int aplicado=1;
            String detalle = request.getParameter("detalle");
            Movimiento movi = new Movimiento();
            ServicioMovimiento SM = new ServicioMovimiento();
            
            movi.setAplicado(aplicado);
            movi.setCuenta_num_cuenta(Double.valueOf(cuenta));
            movi.setFecha(new Date(System.currentTimeMillis()));
            movi.setMovimientocol(detalle);
            movi.setMonto(monto);
            SM.insertarMovimiento(movi);
            
            ServicioCuenta SC = new ServicioCuenta();
            SC.actualizaMonto(monto, cuenta);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("Deposito.jsp");
            dispatcher.forward(request, response);
        }
         catch (Exception e) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("ErrorCajero.jsp");
            dispatcher.forward(request, response);
        }
        }
        
        

            if(request.getServletPath().equals("/TransfereciaCajas")){
        try {
            String dato = request.getParameter("transfe");
            String dato2 = request.getParameter("Dato");
            HttpSession sesion = request.getSession();
            
            if(!dato.equals("")){           
                sesion.setAttribute("ID", dato);
            }
            sesion.setAttribute("buscar", dato2);
            cliente c = new cliente();
            if(dato2.equals("1")){
            ServicioCliente sc = new ServicioCliente();
            c = sc.obtenerCliente(dato).get();
            }


            
            
            String dato3 = request.getParameter("transfe1");
            String dato4 = request.getParameter("Dato1");

            if(!dato3.equals("")){           
                sesion.setAttribute("reti", dato3);
            }
            
            sesion.setAttribute("search", dato4);
            cliente cli = new cliente();
            
            if(dato4.equals("1")){
            ServicioCliente sc = new ServicioCliente();
            cli = sc.obtenerCliente(dato3).get();
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("TransferenciaCajas.jsp");
            dispatcher.forward(request, response);
            
            
            } catch (Exception e) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("ErrorCajero.jsp");
            
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
