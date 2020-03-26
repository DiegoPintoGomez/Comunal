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
public class cliente {
    private String id_cliente;
    private String id_usuario;
    private String apellidos;
    private String nombre;
    private String telefono;

    public cliente() {
    }

    public cliente(String id_cliente, String id_usuario, String apellidos, String nombre, String telefono) {
        this.id_cliente = id_cliente;
        this.id_usuario = id_usuario;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "cliente{" + "id_cliente=" + id_cliente + ", id_usuario=" + id_usuario + ", apellidos=" + apellidos + ", nombre=" + nombre + ", telefono=" + telefono + '}';
    }
    
    
}
