<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<%    
HttpSession sesion = request.getSession();
String usuario="";
if(sesion.getAttribute("usuario")!=null){
usuario=sesion.getAttribute("usuario").toString();
}else{
    out.print("<stript>location.replace('Login.jsp');</stript>");
}
%>

<section class="Encabezado">
    <div id="datos">
        <p><%= usuario%></p>
    </div>
    <ul id="menu">
        <li><a href="InicialCajero.jsp">Inicio</a></li>
        <li><a href="AgregarCuenta.jsp">Crear Cuenta</a></li>
        <li><a href="AgregarCliente.jsp">Agregar Cliente</a></li>
        <li><a href="Retiro.jsp">Retiros</a></li>
        <li><a href="Deposito.jsp">Depositos</a></li>
        <li><a href="Transferencia.jsp">Transferencias</a></li>
    </ul>
</section>