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
        <%@ include file="Menu.jsp"%>

        <section class="box2">
            <h1>Abrir Cuenta </h1>
            <form id="formulario" action="AgregarClienteNuevo" method="POST" class="Formularios">

                <input type="radio" name="Cliente" id="nuevo" value="1" onchange="javascript:showContent()" />
                <label for="cliente">Nuevo</label>
                <input type="radio" name="Cliente" id="cliente" value="0" onchange="javascript:showContent()" checked />
                <label for="cliente">Cliente</label>

                <div id="id" style=" display: block; margin: 5px;">
                    <label for="Nombre"><strong>Cedula cliente:</strong></label>
                    <input type="text" id="cedula" name="cedula" size="25" />
                </div>
                </td>
                </tr>
                </tbody>
                </table>
                <div id="content" style="display: none; margin-top: 2%">
                    <table class="formulario" style="border: 1px solid #ffffff">

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
                        </tbody>
                    </table>
                </div>
                <table class="formulario" style="margin-top: 2%">
                    <tbody>

                        <tr>
                            <td>
                                <label for="Limite"><strong>Limite Diario</strong></label>
                            </td>
                            <td>
                                <input type="text" id="limite" name="limite" size="25" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="moneda"><strong>Provincia:</strong></label>
                            </td>
                            <td>
                                <select id="moneda" name="moneda" size="1">
                                    <option value="CRC" selected="true">Colones</option>
                                    <option value="EUR">Euros</option>
                                    <option value="USD">Dolar EEUU</option>
                                </select>
                            </td>
                        </tr>
                    </tbody>
                </table>


                <div style="margin: 30px">
                    <button type="reset">Borrar</button>&nbsp;
                    <button type="submit">Enviar</button>
                </div>
            </form>




        </section>


    </body>
</html>
