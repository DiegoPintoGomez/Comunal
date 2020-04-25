<%-- 
    Document   : Login
    Created on : 18/03/2020, 07:55:05 PM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="utf-8">
        <title>َAnimated Login Form</title>
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <form class="box" action="CambioC" method="POST">
            <h1>Cambio de clave</h1>
            <table class="">
                <tbody>
                    <tr>
                        <td>
                            <label for="ClaveVieja">Clave antigüa</label>
                        </td>
                        <td>
                            <input type="password" name="ClaveVieja">
                        </td>
                    </tr>
                    <tr>
                        <td>

                            <label for="ClaveNueva">Nueva clave</label>
                        </td>
                        <td>
                            <input type="password" name="ClaveNueva">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="submit" name="" value="Cambiar clave">
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>

    </body>
</html>

