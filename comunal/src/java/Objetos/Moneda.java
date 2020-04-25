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
public class Moneda {

    String nombre;
    String descripcion;
    String simbolo;
    double tipo_cambio_compra;
    double tipo_cambio_venta;

    public Moneda() {
    }

    public Moneda(String nombre, String descripcion, String simbolo, double tipo_cambio_compra, double tipo_cambio_venta) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.simbolo = simbolo;
        this.tipo_cambio_compra = tipo_cambio_compra;
        this.tipo_cambio_venta = tipo_cambio_venta;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public double getTipo_cambio_compra() {
        return tipo_cambio_compra;
    }

    public double getTipo_cambio_venta() {
        return tipo_cambio_venta;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public void setTipo_cambio_compra(double tipo_cambio_compra) {
        this.tipo_cambio_compra = tipo_cambio_compra;
    }

    public void setTipo_cambio_venta(double tipo_cambio_venta) {
        this.tipo_cambio_venta = tipo_cambio_venta;
    }

    @Override
    public String toString() {
        return "Moneda{" + "nombre=" + nombre + ", descripcion=" + descripcion + ", simbolo=" + simbolo + ", tipo_cambio_compra=" + tipo_cambio_compra + ", tipo_cambio_venta=" + tipo_cambio_venta + '}';
    }

    public double conversion(Moneda m1, Moneda m2, double monto) {
        double moneda = (m1.getTipo_cambio_compra() * monto / m2.getTipo_cambio_venta());
        return redondearDecimales(moneda,2);
    }

    public double redondearDecimales(double valorInicial, int numeroDecimales) {
        double parteEntera, resultado;
        resultado = valorInicial;
        parteEntera = Math.floor(resultado);
        resultado = (resultado - parteEntera) * Math.pow(10, numeroDecimales);
        resultado = Math.round(resultado);
        resultado = (resultado / Math.pow(10, numeroDecimales)) + parteEntera;
        return resultado;
    }
}
