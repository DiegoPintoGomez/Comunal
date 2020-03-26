/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.sql.Date;

/**
 *
 * @author diego
 */
public class Cuenta {
    String  num_cuenta;
    int tipo_cuenta_id_tipo_cuenta;
    String cliente_id_cliente;
    String  moneda_nombre;
    Date fecha_creacion;
    Double limite_transferencia_diaria;
    int activa;
    Double saldo_inicial;
    Date fecha_ultima_aplicacion;
    Double saldo_final;

    public Cuenta(String num_cuenta, int tipo_cuenta_id_tipo_cuenta, String cliente_id_cliente, String moneda_nombre, Date fecha_creacion, Double limite_transferencia_diaria, int activa, Double saldo_inicial, Date fecha_ultima_aplicacion, Double saldo_final) {
        this.num_cuenta = num_cuenta;
        this.tipo_cuenta_id_tipo_cuenta = tipo_cuenta_id_tipo_cuenta;
        this.cliente_id_cliente = cliente_id_cliente;
        this.moneda_nombre = moneda_nombre;
        this.fecha_creacion = fecha_creacion;
        this.limite_transferencia_diaria = limite_transferencia_diaria;
        this.activa = activa;
        this.saldo_inicial = saldo_inicial;
        this.fecha_ultima_aplicacion = fecha_ultima_aplicacion;
        this.saldo_final = saldo_final;
    }

    public Cuenta() {
    }

    public String getNum_cuenta() {
        return num_cuenta;
    }

    public int getTipo_cuenta_id_tipo_cuenta() {
        return tipo_cuenta_id_tipo_cuenta;
    }

    public String getCliente_id_cliente() {
        return cliente_id_cliente;
    }

    public String getMoneda_nombre() {
        return moneda_nombre;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public Double getLimite_transferencia_diaria() {
        return limite_transferencia_diaria;
    }

    public int getActiva() {
        return activa;
    }

    public Double getSaldo_inicial() {
        return saldo_inicial;
    }

    public Date getFecha_ultima_aplicacion() {
        return fecha_ultima_aplicacion;
    }

    public Double getSaldo_final() {
        return saldo_final;
    }

    public void setNum_cuenta(String num_cuenta) {
        this.num_cuenta = num_cuenta;
    }

    public void setTipo_cuenta_id_tipo_cuenta(int tipo_cuenta_id_tipo_cuenta) {
        this.tipo_cuenta_id_tipo_cuenta = tipo_cuenta_id_tipo_cuenta;
    }

    public void setCliente_id_cliente(String cliente_id_cliente) {
        this.cliente_id_cliente = cliente_id_cliente;
    }

    public void setMoneda_nombre(String moneda_nombre) {
        this.moneda_nombre = moneda_nombre;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public void setLimite_transferencia_diaria(Double limite_transferencia_diaria) {
        this.limite_transferencia_diaria = limite_transferencia_diaria;
    }

    public void setActiva(int activa) {
        this.activa = activa;
    }

    public void setSaldo_inicial(Double saldo_inicial) {
        this.saldo_inicial = saldo_inicial;
    }

    public void setFecha_ultima_aplicacion(Date fecha_ultima_aplicacion) {
        this.fecha_ultima_aplicacion = fecha_ultima_aplicacion;
    }

    public void setSaldo_final(Double saldo_final) {
        this.saldo_final = saldo_final;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "num_cuenta=" + num_cuenta + ", tipo_cuenta_id_tipo_cuenta=" + tipo_cuenta_id_tipo_cuenta + ", cliente_id_cliente=" + cliente_id_cliente + ", moneda_nombre=" + moneda_nombre + ", fecha_creacion=" + fecha_creacion + ", limite_transferencia_diaria=" + limite_transferencia_diaria + ", activa=" + activa + ", saldo_inicial=" + saldo_inicial + ", fecha_ultima_aplicacion=" + fecha_ultima_aplicacion + ", saldo_final=" + saldo_final + '}';
    }
    
    
}
