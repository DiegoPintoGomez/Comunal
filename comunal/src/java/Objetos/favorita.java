/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/**
 *
 * @author diego
 */
public class favorita {
    String  cliente_id_cliente;
    String  cuenta_num_cuenta;

    public favorita(String cliente_id_cliente, String cuenta_num_cuenta) {
        this.cliente_id_cliente = cliente_id_cliente;
        this.cuenta_num_cuenta = cuenta_num_cuenta;
    }

    public favorita() {
    }

    public String getCliente_id_cliente() {
        return cliente_id_cliente;
    }

    public String getCuenta_num_cuenta() {
        return cuenta_num_cuenta;
    }

    public void setCliente_id_cliente(String cliente_id_cliente) {
        this.cliente_id_cliente = cliente_id_cliente;
    }

    public void setCuenta_num_cuenta(String cuenta_num_cuenta) {
        this.cuenta_num_cuenta = cuenta_num_cuenta;
    }
    
      
}
