<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="utf-8">
        <title>Abrir Cuenta</title>
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
        <script type="text/javascript">
            function showContent() {
                element = document.getElementById("content");
                input = document.getElementById("id");
                check = document.getElementById("nuevo");
                if (check.checked) {
                    element.style.display = 'block';
                    input.style.display = 'none';
                } else {
                    element.style.display = 'none';
                    input.style.display = 'block';
                }
            }
        </script>
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
            <h1>Abrir Cuenta </h1>
            <form id="formulario" action="AgregarClienteNuevo" method="POST" class="Formularios">
                <input type="radio" name="Cliente" id="nuevo" value="1" onchange="javascript:showContent()" />
                <label for="cliente">Nuevo</label>
                <input type="radio" name="Cliente" id="cliente" value="0" onchange="javascript:showContent()" />
                <label for="cliente">Cliente</label>
                <div id="id" style=" display: block; margin: 5px;">
                    <label for="Nombre"><strong>Idcliente</strong></label>
                    <input type="text" id="cedula" name="cedula" size="25" />
                </div>
                <div id="content" style="display: none;">
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

                        </tbody>
                    </table>

                </div>

                <div style="margin: 30px">
                    <button type="reset">Borrar</button>&nbsp;
                    <button type="submit">Enviar</button>
                </div>
            </form>




        </section>


    </body>
</html>
