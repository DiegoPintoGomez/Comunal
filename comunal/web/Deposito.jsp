<%@page import="Model.dao.ServicioCuenta"%>
<%@page import="Objetos.Cuenta"%>
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
            String Cliente = null;
            List<Cuenta> l = new ArrayList();
            if (sesion1.getAttribute("ID") != null) {
                Cliente = sesion1.getAttribute("ID").toString();
                ServicioCuenta sc = new ServicioCuenta();
                if (sesion1.getAttribute("buscar").toString().equals("1")) {
                    l = sc.obtenerListaCuenta(Cliente);
                } else {
                    l.add(sc.obtenerCuenta(Cliente).get());
                }
            }
        %>

        <%@ include file="Menu.jsp"%>

        <section class="box2">
            <h1>Deposito</h1>
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
                    </tbody>
                </table>
            </form>
            <%if (Cliente != null) {

            %>
            <form id="aplicar" action="aplicar" method="POST" class="Formularios">
                <table class="formulario">
                    <tbody>
                        <tr>
                            <td>
                                <label for="valor">Seleccione la cuenta a depositar:</label>
                            </td>
                            <td>
                                <select id="Cuenta" name="Cuenta" size="1">
                                    <%for (int j = 0; j < l.size(); j++) {
                                            out.println("<option value='" + l.get(j).getNum_cuenta() + "'>");
                                            out.println(l.get(j).getNum_cuenta());
                                            out.print("</option>");
                                        }
                                    %>
                                </select>
                            </td>
                        </tr>
                    <td>
                        <label for="valor">Monto a Depositat:</label>
                    </td>
                    <td>
                        <input type="text" id="monto" name="monto" size="25" />
                    </td>
                    <tr>
                        <td colspan="3">
                            <button type="submit">Aplicar</button>
                        </td> 
                    </tr>
                    </tbody>
                </table>
            </form>
            <%}%>

        </section>
    </body>
</html>
