<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="utf-8">
        <title>Abrir Cuenta</title>
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@ include file="Menu.jsp"%>
        <section class="box2">
             <h1>Transaccion Exitosa</h1>
             <img src="imagenes/exito.png" alt=""/>
            <% if(request.getAttribute("Us")!=null){%>
             <h2> El usuario <%=request.getAttribute("Us")%> ha sido creado con exito</h2>
             <h2> Su clave es: <%=request.getAttribute("Clave")%></h2>
             <%}%>
        </section>


    </body>
</html>
