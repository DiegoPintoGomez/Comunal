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
        <li><a href="ConsultaMovimientos.jsp">Consulta Movimeintos</a></li>
        <li><a href="Transferencia.jsp">Trasnferencias</a></li>
        <li><a href="VincularFavoritos.jsp">Vincular a Favoritos</a></li>
    </ul>
</section>