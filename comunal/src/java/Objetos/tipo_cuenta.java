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
public class tipo_cuenta {
    int id_tipo_cuenta;
    String descripcion;
    double tasa_interés;

    public tipo_cuenta(int id_tipo_cuenta, String descripcion, double tasa_interés) {
        this.id_tipo_cuenta = id_tipo_cuenta;
        this.descripcion = descripcion;
        this.tasa_interés = tasa_interés;
    }

    public int getId_tipo_cuenta() {
        return id_tipo_cuenta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getTasa_interés() {
        return tasa_interés;
    }

    public void setId_tipo_cuenta(int id_tipo_cuenta) {
        this.id_tipo_cuenta = id_tipo_cuenta;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setTasa_interés(double tasa_interés) {
        this.tasa_interés = tasa_interés;
    }

    @Override
    public String toString() {
        return "tipo_cuenta{" + "id_tipo_cuenta=" + id_tipo_cuenta + ", descripcion=" + descripcion + ", tasa_inter\u00e9s=" + tasa_interés + '}';
    }
    
    
}
