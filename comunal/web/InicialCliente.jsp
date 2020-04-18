<%@page import="java.util.ArrayList"%>
<%@page import="Objetos.Cuenta"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="Model.dao.ServicioCuenta"%>
<%@page import="Model.dao.ServicioCliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="utf-8">
        <title>Inicio</title>
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%
            HttpSession sesion1 = request.getSession();
            String Cliente = "";
            List<Cuenta> l = new ArrayList();
            if (sesion1.getAttribute("usuario") != null) {
                Cliente = sesion1.getAttribute("Cliente").toString();
                ServicioCliente sc = new ServicioCliente();
                ServicioCuenta scu = new ServicioCuenta();
                l = scu.obtenerListaCuenta(Cliente);
            }

        %>

        <%@ include file="MenuCliente.jsp"%>
        <section class="box2">
            <h1 >Lista de Cuentas: </h1>


            <table class="tablaM">
                <%  int Filas = l.size();%>
                <thead>
                    <tr>
                        <th>Numero de Cuenta</th>
                        <th>Tipo</th>
                        <th>Moneda</th> 
                        <th>Fecha de Creacion</th> 
                        <th>Limite Diario</th> 
                        <th>Estado</th>
                        <th>Saldo</th> 
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (int i = 1; i <= Filas; i++) {
                            out.println("<tr>");
                            
                            out.println("<td>");
                            out.print(l.get(i-1).getNum_cuenta());
                            out.print("</td>");
                            out.println("<td>");
                            out.print(l.get(i-1).getTipo_cuenta_id_tipo_cuenta());
                            out.print("</td>");
                            out.println("<td>");
                            out.print(l.get(i-1).getMoneda_nombre());
                            out.print("</td>");
                            out.println("<td>");
                            out.print(l.get(i-1).getFecha_creacion().toString());
                            out.print("</td>");
                            out.println("<td>");
                            out.print(l.get(i-1).getLimite_transferencia_diaria());
                            out.print("</td>");
                            out.println("<td>");
                            out.print(l.get(i-1).getActiva());
                            out.print("</td>");
                            out.println("<td>");
                            out.print(l.get(i-1).getSaldo_final());
                            out.print("</td>");
                  
                            out.println("</tr>");
                        }
                    %>
                </tbody>
            </table>

        </section>
    </body>
</html>



