<%@page import="Model.dao.ServicioCuenta"%>
<%@page import="Model.dao.ServicioCliente"%>
<%@page import="Objetos.Cuenta"%>
<%@page import="Model.dao.ServicioFavorita"%>
<%@page import="Objetos.favorita"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="utf-8">
        <title>Abrir Cuenta</title>
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%
            HttpSession sesion1 = request.getSession();
            String Cliente = "";
            List<favorita> l = new ArrayList();
            List<Cuenta> k = new ArrayList();
            if (sesion1.getAttribute("usuario") != null) {
             
            }

        %>

        <%@ include file="Menu.jsp"%>
        <section class="box2">
            <h1>Transferencia por cajas </h1>
            
            
            <form id="Deposito" action="GenerarDeposito" method="POST" class="Formularios">
                <table class="formulario">
                    <tbody>
                        <tr>
                            <td>
                                <label for="valor">Buscar Por:</label>
                            </td>
                            <td>
                                <input type="text" id="valor" name="valor" size="25" />
                            </td>
                            <td>
                                <select id="Dato" name="Dato" size="1">
                                    <option value="1" selected="true">Cedula Cliente</option>
                                    <option value="0">Numero de Cuenta</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="3">
                                <button type="submit">Buscar</button>
                            </td> 
                        </tr>
                         <tr>
                            <td>
                                <label for="valor">Buscar Por:</label>
                            </td>
                            <td>
                                <input type="text" id="valor" name="valor" size="25" />
                            </td>
                            <td>
                                <select id="Dato" name="Dato" size="1">
                                    <option value="1" selected="true">Cedula Cliente</option>
                                    <option value="0">Numero de Cuenta</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="3">
                                <button type="submit">Buscar</button>
                            </td> 
                        </tr>
                    </tbody>
                </table>
            </form>
            
            
            
            
            <form id="Transferencia" action="Trasferencia" method="POST" class="Formularios">
                <table class="formulario">
                    <tbody>
                    <td>
                        <label for="cuenta">Numero de Cuenta de origen</label>
                    </td>
                    <td>
                        <select id="Cuenta" name="Cuenta" size="1">
                            <%for (int j = 1; j <= k.size(); j++) {
                                    out.println("<option value='" + k.get(j - 1).getNum_cuenta() + "'>");
                                    out.println(k.get(j - 1).getNum_cuenta());
                                    out.print("</option>");
                                }
                            %>
                        </select>
                    </td>
                    <tr>
                        <td>
                            <label for="cuenta">Numero de Cuenta a Transferir</label>
                        </td>
                        <td>
                            <select id="Favorita" name="Favorita" size="1">
                                <%for (int i = 1; i <= l.size(); i++) {
                                        out.println("<option value='" + l.get(i - 1).getCuenta_num_cuenta() + "'>");
                                        out.println(l.get(i - 1).getCuenta_num_cuenta());
                                        out.print("</option>");
                                    }
                                %>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="monto">Monto a Transferir</label>
                        </td>
                        <td>
                            <input type="text" id="monto" name="monto" size="25" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="valor">Detalle:</label>
                        </td>
                        <td>
                            <input type="text" id="detalle" name="detalle" size="25" />
                        </td>                    
                    </tr>
                    <tr>
                        <td colspan="3">
                            <button type="submit">Realizar transferencia</button>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </form>
        </section>


    </body>
</html>
