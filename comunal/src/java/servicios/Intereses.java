/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import Model.dao.ServicioCuenta;
import Model.dao.ServicioMoneda;
import Model.dao.ServicioMovimiento;
import Model.dao.ServicioTipo_Cuenta;
import Objetos.Cuenta;
import Objetos.Movimiento;
import Objetos.tipo_cuenta;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "Intereses", urlPatterns = {"/Intereses"})
public class Intereses extends HttpServlet {

    void intereses(Cuenta c) {
        if (c.getSaldo_final() != 0) {
            ServicioMovimiento sm = new ServicioMovimiento();
            ServicioTipo_Cuenta st = new ServicioTipo_Cuenta();
            ServicioCuenta sc = new ServicioCuenta();
            tipo_cuenta t = st.obtenertipo_cuenta(c.getTipo_cuenta_id_tipo_cuenta()).get();
            double monto = c.getSaldo_final() * t.getTasa_interés();
            Movimiento movi = new Movimiento();
            movi.setAplicado(1);
            movi.setCuenta_num_cuenta(Double.valueOf(c.getNum_cuenta()));
            movi.setFecha(new Date(System.currentTimeMillis()));
            movi.setMovimientocol("Intereses ganados a su cuanta");
            movi.setMonto(monto);
            sm.insertarMovimiento(movi);
            sc.actualizaMonto(monto, c.getNum_cuenta());
        }
    }

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
        if (request.getServletPath().equals("/Intereses")) {
            try {
                ServicioCuenta sc = new ServicioCuenta();
                List<Cuenta> l = new ArrayList();
                l = sc.obtenerListaTotalCuenta();
                for (int j = 0; j < l.size(); j++) {
                    intereses(l.get(j));
                }
                RequestDispatcher dispatcher = request.getRequestDispatcher("ExitosaCajero.jsp");
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
