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
            <h1>Deposito</h1>
            <form id="Deposito" action="GenerarDeposito" method="POST" class="Formularios">
                <table class="formulario">
                    <tbody>
                        <tr>
                            <td>
                                <strong>Buscar Por:</strong>
                            </td>
                            <td>
                                <input type="text" id="valor" name="valor" size="25" />
                            </td>
                            <td>
                                <select id="Dato" name="Dato" size="1">
                                    <option value="Cedula" selected="true">Cedula Cliente</option>
                                    <option value="Numero">Numero de Cuenta</option>
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
        </section>
    </body>
</html>
