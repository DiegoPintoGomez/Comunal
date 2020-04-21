<%@page import="Objetos.Movimiento"%>
<%@page import="Model.dao.ServicioMovimiento"%>
<%@page import="Model.dao.ServicioCuenta"%>
<%@page import="Model.dao.ServicioCliente"%>
<%@page import="Objetos.Cuenta"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
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
            List<Movimiento> m = new ArrayList();
            String ValorR = null;
            if (sesion1.getAttribute("usuario") != null) {
                Cliente = sesion1.getAttribute("Cliente").toString();
                ServicioCliente sc = new ServicioCliente();
                ServicioCuenta scu = new ServicioCuenta();
                l = scu.obtenerListaCuenta(Cliente);
                if (sesion1.getAttribute("valor") != null) {
                    ValorR = sesion1.getAttribute("valor").toString();
                    ServicioMovimiento sm = new ServicioMovimiento();
                    m = sm.obtenerListaMovimientosCuenta(ValorR);
                }
            }

        %>

        <%@ include file="MenuCliente.jsp"%>
        <section class="box2">
            <h1 >Consulta de Movimientos: </h1>
            <form id="Movimiento" action="ConsulMov" method="POST" class="Formularios">
                <table class="formulario">
                    <tbody>
                    <td>
                        <label for="Valor">Numero de Cuenta a consultar</label>
                    </td>
                    <td>
                        <select id="Valor" name="Valor" size="1">
                            <%for (int j = 1; j <= l.size(); j++) {
                                    out.println("<option value='" + l.get(j - 1).getNum_cuenta() + "'>");
                                    out.println(l.get(j - 1).getNum_cuenta());
                                    out.print("</option>");
                                }
                            %>
                        </select>
                    </td>
                    <tr>
                        <td colspan="3">
                            <button type="submit">Consultar Movimientos</button>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </form>
            <div>
                <%if (sesion1.getAttribute("valor") != null) {%>
                <h1 >Numero de cuanta Consultada: <%out.println(ValorR);%></h1>
                <table class="tablaM">
                    <%  int Filas = 0;

                        Filas = m.size();
                    %>
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Monto</th>
                            <th>Fecha</th> 
                            <th>Estado</th> 
                            <th>Detalle</th> 
                        </tr>
                    </thead>
                    <tbody>
                        <%
                                for (int i = 1; i <= Filas; i++) {
                                    out.println("<tr>");

                                    out.println("<td>");
                                    out.print(m.get(i - 1).getId_movimiento());
                                    out.print("</td>");
                                    out.println("<td>");
                                    out.print(m.get(i - 1).getMonto());
                                    out.print("</td>");
                                    out.println("<td>");
                                    out.print(m.get(i - 1).getFecha().toString());
                                    out.print("</td>");
                                    out.println("<td>");
                                    if (m.get(i - 1).getAplicado() == 1) {
                                        out.print("aplicado");
                                    } else {
                                        out.print("Pendiente");
                                    };
                                    out.print("</td>");
                                    out.println("<td>");
                                    out.print(m.get(i - 1).getMovimientocol());
                                    out.print("</td>");

                                    out.println("</tr>");
                                }
                            }
                        %>
                    </tbody>
                </table>
            </div>
        </section>
    </body>
</html>



