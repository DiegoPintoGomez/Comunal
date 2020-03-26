<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="utf-8">
        <title>Abrir Cuenta</title>
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <section class="Encabezado">
            <ul id="menu">
                <li><a href="InicialCajero.jsp">Inicio</a></li>
                <li><a href="AgregarCuenta.jsp">Crear Cuenta</a></li>
                <li><a href="AgregarCliente.jsp">Agregar Cliente</a></li>
                <li><a href="Retiro.jsp">Retiros</a></li>
                <li><a href=”#”>Depositos</a></li>
                <li><a href=”#”>Transferencias</a></li>
            </ul>
        </section>

        <section class="box2">
            <h1 >Abrir Cuenta </h1>
            <form id="formulario" action="" method="GET" class="Formularios">
                <table class="formulario">

                    <tbody>

                        <tr>
                            <td>
                                <label for="cédula"><strong>Cédula:</strong></label>
                            </td>
                            <td>
                                <input type="text" id="Cedula" name="nombre" size="25" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="Nombre"><strong>Nombre</strong></label>

                            </td>
                            <td>
                                <input type="text" id="Nombre" name="nombre" size="25" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="Apellidos"><strong>Apellidos:</strong></label>
                            </td>
                            <td>
                                <input type="text" id="Apellidos" name="nombre" size="25" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="Telefono"><strong>Telefono</strong></label>
                            </td>
                            <td>
                                <input type="text" id="Telefono" name="nombre" size="25" />
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
