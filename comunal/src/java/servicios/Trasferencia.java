/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import Model.dao.ServicioCuenta;
import Model.dao.ServicioFavorita;
import Model.dao.ServicioMoneda;
import Model.dao.ServicioMovimiento;
import Model.dao.ServicioTransferencia;
import Objetos.Moneda;
import Objetos.Movimiento;
import Objetos.favorita;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
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
@WebServlet(name = "Trasferencia", urlPatterns = {"/Trasferencia", "/ConsulMov"})
public class Trasferencia extends HttpServlet {

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
        if (request.getServletPath().equals("/Trasferencia")) {
            try {
                String Cuenta = request.getParameter("Cuenta");
                String favorita = request.getParameter("Favorita");
                String monto = request.getParameter("monto");
                String detalle = request.getParameter("detalle");
                ServicioCuenta c = new ServicioCuenta();

                if (c.obtenerCuenta(Cuenta).get().getLimite_transferencia_diaria() < Double.valueOf(monto)) {
                    request.setAttribute("Mensaje", "El monto excede el limite diario de transferencia");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("ErrorCliente.jsp");
                    dispatcher.forward(request, response);
                }else if (c.obtenerCuenta(Cuenta).get().getSaldo_final() < Double.valueOf(monto)) {
                    request.setAttribute("Mensaje", "Fondos insuficientes");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("ErrorCliente.jsp");
                    dispatcher.forward(request, response);
                } else {
                    ServicioTransferencia st = new ServicioTransferencia();
                    st.insertarTransferencia(Cuenta, favorita, monto);
                    insertarmovimientos(Cuenta, favorita, Double.valueOf(monto), detalle);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("ExitosaCliente.jsp");
                    dispatcher.forward(request, response);
                }

            } catch (Exception e) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("ErrorCliente.jsp");
                dispatcher.forward(request, response);
            }
        }
        if (request.getServletPath().equals("/ConsulMov")) {
            try {
                String valor = null;
                valor = request.getParameter("Valor");
                HttpSession sesion = request.getSession();
                sesion.setAttribute("valor", valor);
                RequestDispatcher dispatcher = request.getRequestDispatcher("ConsultaMovimientos.jsp");
                dispatcher.forward(request, response);
            } catch (Exception e) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("ErrorCliente.jsp");
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

    void insertarmovimientos(String Cuenta1, String Cuenta2, double monto, String Detalle) {

        ServicioMovimiento sm = new ServicioMovimiento();
        ServicioCuenta sc = new ServicioCuenta();
        ServicioMoneda smo = new ServicioMoneda();
        Moneda m1 = smo.obtenerMoneda(sc.obtenerCuenta(Cuenta1).get().getMoneda_nombre()).get();

        Moneda m = smo.obtenerMoneda(sc.obtenerCuenta(Cuenta2).get().getMoneda_nombre()).get();
        double monto2 = m1.conversion(m1, m, monto);
        Movimiento movi = new Movimiento();
        Movimiento movi2 = new Movimiento();
        movi.setAplicado(1);
        movi2.setAplicado(1);
        movi.setCuenta_num_cuenta(Double.valueOf(Cuenta1));
        movi2.setCuenta_num_cuenta(Double.valueOf(Cuenta2));
        movi.setFecha(new Date(System.currentTimeMillis()));
        movi2.setFecha(new Date(System.currentTimeMillis()));
        movi.setMovimientocol(Detalle);
        movi2.setMovimientocol(Detalle);
        movi.setMonto(0 - Double.valueOf(monto));
        movi2.setMonto(Double.valueOf(monto2));
        sm.insertarMovimiento(movi);
        sm.insertarMovimiento(movi2);

        sc.actualizaMonto(monto2, Cuenta2);
        sc.actualizaMonto(0 - monto, Cuenta1);
    }
}
