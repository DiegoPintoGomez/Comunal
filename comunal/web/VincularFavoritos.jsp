<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="utf-8">
        <title>Inicio</title>
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <%@ include file="MenuCliente.jsp"%>
        <section class="box2">
            <h1>Vincular Cuenta a Favoritos</h1>
            <form id="Deposito" action="VincularCuentas" method="POST" class="Formularios">
                <table class="formulario">
                    <tbody>
                        <tr>
                            <td>
                                <strong>Numero de Cuenta a Vincular</strong>
                            </td>
                            <td>
                                <input type="text" id="cuenta" name="cuenta" size="25" />
                            </td>
                        </tr>
                        <tr>
                            <td colspan="3">
                                <button type="submit">Vincular</button>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </section>
    </body>
</html>



