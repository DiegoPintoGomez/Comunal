<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<%
    HttpSession sesion = request.getSession();
    String usuario = "";
    String nombre = "";
    if (sesion.getAttribute("usuario") != null) {
        usuario = sesion.getAttribute("usuario").toString();
        nombre = sesion.getAttribute("nombre").toString() + sesion.getAttribute("apellidos").toString();;
    } else {
        response.sendRedirect("Cerrar");
    }
%>

<section class="Encabezado">
    <div id="datos">
        <p><%= usuario + "    " + nombre+" "%><a href="Cerrar">Cerrar Sesion</a></p>
    </div>
    <ul id="menu">
        <li><a href="InicialCajero.jsp">Inicio</a></li>
        <li><a href="AgregarCuenta.jsp">Crear Cuenta</a></li>
        <li><a href="AgregarCliente.jsp">Agregar Cliente</a></li>
        <li><a href="Retiro.jsp">Retiros</a></li>
        <li><a href="Deposito.jsp">Depositos</a></li>
        <li><a href="AplicarIntereses.jsp">Aplicar Intereses</a></li>   
    </ul>
</section>