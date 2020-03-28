<%-- 
    Document   : pasarListaCuentasDeJavaAJavascript
    Created on : Mar 28, 2020, 12:19:39 AM
    Author     : metal
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        ArrayList<cliente> clintes = request.getAttribute("listaDeCuentas");
        %>
        <input id="cuentaIngresada" onkeyup="numeroCuentaR(<%=formato(clintes)%>)">
        <input id="campoCedula">
    </body>
    <%!
        public String formato(ArrayList<cliente> listaCli) {
            StringBuffer sb = new StringBuffer();
            sb.append("[");
            int i = 0;
            for (cliente cl : listaCli) {
                i++;
                sb.append("{").append("\'").append("id").append("\'").append(" : ").append(cl.getId_cliente()).append(", ");
                sb.append("\'").append("nombre").append("\'").append(": ").append("\'").append(cl.getNombre()).append("\'").append(", ");
                sb.append("\'").append("apellido").append("\'").append(" : ").append("\'").append(cl.getApellidos()).append("\'").append(",");
                sb.append("\'").append("cuentas").append("\'").append(" : [");
                ArrayList<cuenta> cuentas = cl.getCuentasX();
                for (cuenta cuent : cuentas) {
                    sb.append("{").append("\'").append("numeroCuenta").append("\'").append(" : ").append(cuent.getNcuenta()).append("}");
                    if (cuentas.size() > i) {
                        sb.append(",");
                    }
                }
                sb.append("]}");
                if (listaCli.size() > i) {
                    sb.append(",");
                }

            }
            sb.append("]");
            return sb.toString();
        }
    %>
</html>
<script>
    function numeroCuentaR(lista) {
        cuenta = Number(document.getElementById("cuentaIngresada").value);
        campo = document.getElementById("campoCedula");
        for (var i = 0; i < lista.length; i++) {
            cuen = lista[i].valueOf()['cuentas'];
            for (var j = 0; j < cuen.length; j++) {
                if (cuen[j].valueOf()['numeroCuenta'] === cuenta) {
                    campo.value = lista[i].valueOf()['id'];
                    j = cuen.length;
                }
            }
            i = lista.length;

        }
    }
</script>
