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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lenovo
 */
@WebServlet(name = "Intereses", urlPatterns = {"/Intereses"})
public class Intereses extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Intereses</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Intereses at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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

    void intereses(Cuenta c) {
        if (c.getSaldo_final() != 0) {
            ServicioMovimiento sm = new ServicioMovimiento();
            ServicioTipo_Cuenta st =new ServicioTipo_Cuenta();
            ServicioCuenta sc=new ServicioCuenta();
            tipo_cuenta t=st.obtenertipo_cuenta(c.getTipo_cuenta_id_tipo_cuenta()).get();
            double monto= c.getSaldo_final()*t.getTasa_interés();
            Movimiento movi = new Movimiento();
            movi.setAplicado(1);
            movi.setCuenta_num_cuenta(Double.valueOf(c.getNum_cuenta()));
            movi.setFecha(new Date(System.currentTimeMillis()));
            movi.setMovimientocol("Intereses ganados a su cuanta");
            movi.setMonto(0 - Double.valueOf(monto));
            sm.insertarMovimiento(movi);
            sc.actualizaMonto(monto, c.getNum_cuenta());
        }
    }

}
