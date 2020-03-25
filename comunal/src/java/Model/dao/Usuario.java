/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.dao;

/**
 *
 * @author diego
 */
public class Usuario {
    String id_usuario;
    String Clave_acceso;
    int clave_vencida;
    int rol;

    public Usuario(String id_usuario, String Clave_acceso, int clave_vencida, int rol) {
        this.id_usuario = id_usuario;
        this.Clave_acceso = Clave_acceso;
        this.clave_vencida = clave_vencida;
        this.rol = rol;
    }

    public Usuario() {
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public String getClave_acceso() {
        return Clave_acceso;
    }

    public int getClave_vencida() {
        return clave_vencida;
    }

    public int getRol() {
        return rol;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public void setClave_acceso(String Clave_acceso) {
        this.Clave_acceso = Clave_acceso;
    }

    public void setClave_vencida(int clave_vencida) {
        this.clave_vencida = clave_vencida;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id_usuario=" + id_usuario + ", Clave_acceso=" + Clave_acceso + ", clave_vencida=" + clave_vencida + ", rol=" + rol + '}';
    }
    
    
    
}
