<%@page import="Model.dao.ServicioCuenta"%>
<%@page import="Model.dao.ServicioCliente"%>
<%@page import="Objetos.Cuenta"%>
<%@page import="Model.dao.ServicioFavorita"%>
<%@page import="Objetos.favorita"%>
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
        <%
            HttpSession sesion1 = request.getSession();
            String Cliente = null;
            List<Cuenta> l = new ArrayList();
            if (sesion1.getAttribute("transfe2") != null) {
                Cliente = sesion1.getAttribute("transfe2").toString();
                ServicioCuenta sc = new ServicioCuenta();
                if (sesion1.getAttribute("buscar").toString().equals("1")) {
                    l = sc.obtenerListaCuenta(Cliente);
                } else {
                    l.add(sc.obtenerCuenta(Cliente).get());
                }
            }
            

            String reti1 = null;
            List<Cuenta> Cuen = new ArrayList();
            if (sesion1.getAttribute("reti") != null) {
                reti1 = sesion1.getAttribute("reti").toString();
                ServicioCuenta sc = new ServicioCuenta();
                if (sesion1.getAttribute("search").toString().equals("1")) {
                    Cuen = sc.obtenerListaCuenta(reti1);
                } else {
                    Cuen.add(sc.obtenerCuenta(reti1).get());
                }
            }

        %>

        <%@ include file="Menu.jsp"%>
        <section class="box2">
            <h1>Transferencia por cajas </h1>
            <form id="TransfereciaCajas" action="TransfereciaCajas" method="POST" class="Formularios">
                <table class="formulario">
                    <tbody>
                        <%if(Cliente==null || reti1==null ) { 
                        %>
                        <tr>
                            <td>
                                <label for="transfe">buscar cuenta origen</label>
                            </td>
                            <td>
                                <input type="text" id="transfe" name="transfe" size="25" />
                            </td>
                            <td>
                                <select id="Dato" name="Dato" size="1">
                                    <option value="1" selected="true">Cedula Cliente</option>
                                    <option value="0">Numero de Cuenta</option>
                                </select>
                            </td>
                        </tr>
                        
                        
                        
                        
                          <tr>
                            <td>
                                <label for="transfe1">Buscar cuenta destino:</label>
                            </td>
                            <td>
                                <input type="text" id="transfe1" name="transfe1" size="25" />
                            </td>
                            <td>
                                <select id="Dato1" name="Dato1" size="1">
                                    <option value="1" selected="true">Cedula Cliente</option>
                                    <option value="0">Numero de Cuenta</option>
                                </select>
                            </td>
                        </tr>
                        
                        
                        
                        <tr>
                            <td colspan="3">
                                <button type="submit">Buscar cuentas</button>
                            </td> 
                        </tr>
                        <tr>
                        <td colspan="3">
                            <p>*Debe de aplicar los dos metododos de buscar</p>
                            <p>para poder continuar con la transferencia</p>
                        </td>
                    </tr>
                        <%}%>
                    </tbody>
                </table>
            </form>
            <form id="buscar" action="buscar" method="POST" class="Formularios">
              <%if (Cliente != null && reti1 !=null) {

            %>
                <table class="formulario">
                    <tbody>
                        <tr>
                            <td>
                                <label for="valor">Seleccione la cuenta que transfiere:</label>
                            </td>
                            <td>
                                <select id="Cuenta" name="Cuenta" size="1">
                                    <%for (int j = 0; j < l.size(); j++) {
                                            out.println("<option value='" + l.get(j).getNum_cuenta() + "'>");
                                            out.println("num cuenta: "+l.get(j).getNum_cuenta() + " cedula: "+l.get(j).getCliente_id_cliente());
                                            out.print("</option>");
                                        }
                                    %>
                                </select> 
                            </td>
                        </tr>
                    
                    <td>
                        <label for="valor">Monto a Depositar:</label>
                    </td>
                    <td>
                        <input type="text" id="monto" name="monto" size="25" />
                    </td>
                    <tr>
                    <td>
                        <label for="valor">Detalle:</label>
                    </td>
                    <td>
                        <input type="text" id="detalle" name="detalle" size="25" />
                    </td>                    
                    </tr>
                    
                    
                    
                    
                    
                    
                    <tr>
                            <td>
                                <label for="valor">Seleccione la cuenta a depositar:</label>
                            </td>
                            <td>
                                <select id="Cuenta1" name="Cuenta1" size="1">
                                    <%for (int j = 0; j < Cuen.size(); j++) {
                                            out.println("<option value='" + Cuen.get(j).getNum_cuenta() + "'>");
                                            out.println("num cuenta: "+ Cuen.get(j).getNum_cuenta() + " cedula: "+Cuen.get(j).getCliente_id_cliente());
                                            out.print("</option>");
                                        }
                                    %>
                                </select>
                            </td>
                        </tr>
                    
                    <tr>
                        <td colspan="3">
                            <button type="submit">Aplicar</button>
                        </td> 
                    </tr>
                    <tr>
                        <td colspan="3">
                            <p>*Los montos a tomar en cuenta seran los de la cuenta de</p>
                            <p>origen los cuales seran evaluados segun el tipo de cambio</p>
                            <p>de la moneda de destino </p>
                        </td>
                    </tr>
                    </tbody>                    
                </table>            
                <%
                sesion1.setAttribute("ID", null);
                sesion1.setAttribute("reti", null);
                }%>             
            </form>
           
        
            
        </section>


    </body>
</html>
