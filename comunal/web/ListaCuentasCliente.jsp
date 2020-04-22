<%-- 
    Document   : ListaCuentasCliente
    Created on : 18/03/2020, 08:29:54 PM
    Author     : Lenovo
--%>

<%@page import="Model.dao.ServicioCuenta"%>
<%@page import="Model.dao.ServicioCliente"%>
<%@page import="Objetos.Cuenta"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
< <%
            HttpSession sesion1 = request.getSession();
            String Cliente = "";
            List<Cuenta> l = new ArrayList();
            if (sesion1.getAttribute("ID") != null) {
                Cliente = sesion1.getAttribute("ID").toString();
                ServicioCliente sc = new ServicioCliente();
                ServicioCuenta scu = new ServicioCuenta();
                l = scu.obtenerListaCuenta(Cliente);
            }
                %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="utf-8">
        <title>َAnimated Login Form</title>
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@ include file="Menu.jsp"%>
        <section class="box2">
            <h1 >Lista de Cuentas: </h1>            
            <h1> ID del usuario es:<a> <%=Cliente%> </a> </h1>
            <table class="tablaM">
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
                     <% for (Cuenta BT : l){ %>
                    <tr>
                        <td>
                            <%= BT.getNum_cuenta().toString()%>
                        </td>
                        <td>
                            <%=BT.getTipo_cuenta_id_tipo_cuenta()%>
                        </td>
                        <td>
                            <%=BT.getMoneda_nombre().toString()%>
                        </td>
                        <td>
                            <%=BT.getFecha_creacion().toString()%>
                        </td>
                        <td>
                            <%=BT.getLimite_transferencia_diaria().toString()%>
                        </td>
                        <td>
                            <%=BT.getActiva()%>
                        </td>
                        <td>
                            <%=BT.getSaldo_inicial().toString()%>
                        </td>

                    </tr>
                    <% }%>
                </tbody>
            </table>

        </section>
        <a href="Emergente.html"></a>

    </body>
</html>
