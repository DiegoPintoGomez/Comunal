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
            <h1 >Abrir Cuenta </h1>
            <form id="formulario" action="AgregarClienteNuevo" method="POST" class="Formularios">
                <table class="formulario">

                    <tbody>

                        <tr>
                            <td>
                                <label for="cédula"><strong>Cédula:</strong></label>
                            </td>
                            <td>
                                <input type="text" id="Cedula" name="Cedula" size="25" />
                            </td>
                        </tr>
                        
                        <tr>
                            <td>
                                <label for="Usuario"><strong>Usuario:</strong></label>
                            </td>
                            <td>
                                <input type="text" id="Usuario" name="Usuario" size="25" />
                            </td>
                        </tr>
                        
                        
                        <tr>
                            <td>
                                <label for="Nombre"><strong>Nombre</strong></label>

                            </td>
                            <td>
                                <input type="text" id="Nombre" name="Nombre" size="25" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="Apellidos"><strong>Apellidos:</strong></label>
                            </td>
                            <td>
                                <input type="text" id="Apellidos" name="Apellidos" size="25" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="Telefono"><strong>Telefono</strong></label>
                            </td>
                            <td>
                                <input type="text" id="Telefono" name="Telefono" size="25" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <input type="radio" id="btn01" name="Rol" value="1">
                                <label for="btn01">Cajero</label>
                            </td>
                            <td>
                                <input type="radio" id="btn02" name="Rol" value="2">
                                <label for="btn01">Cliente</label>
                            </td>

                        </tr>
                        <tr>
                            <td>
                                <button type="reset">Borrar</button>&nbsp;
                            </td>
                            <td>
                                <button type="submit">Enviar</button>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </section>
    </body>
</html>
