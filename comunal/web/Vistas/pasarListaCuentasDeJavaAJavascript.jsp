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
        
         <div class="modal fade" id="Modal4"   tabindex="-1" role="dialog" aria-labelledby="ModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <h5 class="modal-title" id="ModalLabel">Transferencia</h5>
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <form id="formT" action="TransferirCajero">
                        <table class="table table-bordered table-striped mb-0" id="PerfilTable">
                            <thead>
                                <tr>
                                    <th>Cedula de Cuenta Depositante</th>
                                    <th>
                                        <input class="form-control" onkeyup="numeroCedulaCuentaTD(<%=formato(listaC)%>)" placeholder="Numero de Cuenta" id="CedulaTD" name="CedulaTD" >
                                    </th>
                                </tr>
                                <tr>
                                    <th scope="col">Numero de Cuenta Depositante</th>
                                    <th >
                                        <div class="input-group mb-3">
                                            <div class="input-group-prepend">
                                                <button class="btn1 dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Cuentas</button>
                                                <div class="dropdown-menu" id="menuTD">
                                                </div>
                                            </div>
                                            <input type="text" required="true" onkeyup="numeroCuentaTD(<%=formato(listaC)%>)" id="CuentaTD" name="CuentaTD" class="form-control" aria-label="Cuenta">
                                        </div>
                                    </th>
                                </tr>
                                <tr>
                                    <th><label>Cedula de Cliente a Depositar</label> </th>
                                    <th>  <input type="text" name="despositarCedula" onkeyup="numeroCedulaCuentaT(<%=formato(listaC)%>)" required="true" class="form-control" placeholder="Cedula de Cliente" name="CedulaT" id="CedulaT"></h3>
                                    </th>
                                </tr>
                                <tr>
                                    <th><label>Numero de Cuenta a Depositar</label> </th>
                                    <th >
                                        <div class="input-group mb-3">
                                            <div class="input-group-prepend">
                                                <button class="btn1 dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Cuentas</button>
                                                <div class="dropdown-menu" id="menuTT">
                                                </div>
                                            </div>
                                            <input type="text" required="true" onkeyup="numeroCuentaT(<%=formato(listaC)%>)" id="CuentaT" name="CuentaT" class="form-control" aria-label="Cuenta">
                                        </div>
                                    </th>
                                </tr>

                                <tr>
                                    <th><label>Monto a depositar</label> </th>
                                    <th>   <input type="number" min="0" name="montoT" class="form-control" required="true"  placeholder="0.0" id="montoT" >
                                    </th>

                                </tr>
                                <tr>
                                    <th scope="col">Detalle</th>
                                    <th > <textarea rows="2" name="DetalleT" required="true" cols="30"></textarea> </th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <th style="text-align: center;"colspan="2">

                                        <button type="submit" class="btn btn-default"><img  src="../assets/imagenes/aceptar.png" style=" width: 50px; height: 50px;"></button>
                                        <button class="btn btn-default" data-dismiss="modal" aria-label="Close"><img  src="../assets/imagenes/cancelar.png" style=" width: 50px; height: 50px;"></button>

                                    </th>
                                </tr>

                            </tbody>
                        </table>
                    </form>

                </div>
            </div>
        </div>
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
