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
public class Movimiento {
    int id_movimiento;
    double cuenta_num_cuenta;
    double monto;
    Date fecha;
    int aplicado;
    String movimientocol;

    public Movimiento(int id_movimiento, double cuenta_num_cuenta, double monto, Date fecha, int aplicado, String movimientocol) {
        this.id_movimiento = id_movimiento;
        this.cuenta_num_cuenta = cuenta_num_cuenta;
        this.monto = monto;
        this.fecha = fecha;
        this.aplicado = aplicado;
        this.movimientocol = movimientocol;
    }

    public Movimiento() {
    }

    public int getId_movimiento() {
        return id_movimiento;
    }

    public double getCuenta_num_cuenta() {
        return cuenta_num_cuenta;
    }

    public double getMonto() {
        return monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public int getAplicado() {
        return aplicado;
    }

    public String getMovimientocol() {
        return movimientocol;
    }

    public void setId_movimiento(int id_movimiento) {
        this.id_movimiento = id_movimiento;
    }

    public void setCuenta_num_cuenta(double cuenta_num_cuenta) {
        this.cuenta_num_cuenta = cuenta_num_cuenta;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setAplicado(int aplicado) {
        this.aplicado = aplicado;
    }

    public void setMovimientocol(String movimientocol) {
        this.movimientocol = movimientocol;
    }

    @Override
    public String toString() {
        return "Movimiento{" + "id_movimiento=" + id_movimiento + ", cuenta_num_cuenta=" + cuenta_num_cuenta + ", monto=" + monto + ", fecha=" + fecha + ", aplicado=" + aplicado + ", movimientocol=" + movimientocol + '}';
    }
    
    
}
