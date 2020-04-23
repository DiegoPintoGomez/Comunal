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
        <%@ include file="Menu.jsp"%>

        <section class="box2">
            <h1>Aplicar los intereses</h1>
            <form id="intereses" action="Intereses" method="POST" class="Formularios">
                <table class="formulario">
                    <tbody>
                    <tr>
                        <td>
                            <button type="submit">Aplicar</button>
                        </td> 
                    </tr>
                    </tbody>
                </table>
            </form>
        </section>
    </body>
</html>
