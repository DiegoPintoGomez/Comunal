/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.dao;

import Objetos.cliente;
import coneccion.BaseDatos;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public class ServicioCliente {

     public Optional<cliente> obtenerCliente(String id) {
        Optional<cliente> r = Optional.empty();
        try (Connection cnx = obtenerConexion();
            PreparedStatement stm = cnx.prepareStatement(IMEC_Cliente.CONSULTAR.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, id);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    r = Optional.of(new cliente(
                            rs.getString("id_cliente"),
                            rs.getString("usuario_id_usuario"),
                            rs.getString("apellidos"),
                            rs.getString("nombre"),
                            rs.getString("telefono")
                    ));
                }
            }
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
          return r;
    }
     
     public Optional<cliente> obtenerCliente_id_usuario(String id){
         Optional<cliente> r = Optional.empty();
         try (Connection cnx = obtenerConexion();
         PreparedStatement stm = cnx.prepareStatement(IMEC_Cliente.OBTENER.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, id);
             try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    r = Optional.of(new cliente(
                            rs.getString("id_cliente"),
                            rs.getString("usuario_id_usuario"),
                            rs.getString("apellidos"),
                            rs.getString("nombre"),
                            rs.getString("telefono")
                    ));
                }
            }
      } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
          return r;
    }
     
       public int insertarCliente(cliente usu) {
        int i=0;
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Cliente.INSERTAR.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1,usu.getId_usuario() );
            stm.setString(2,usu.getId_usuario());
            stm.setString(3,usu.getApellidos());
            stm.setString(4,usu.getNombre());
            stm.setString(5,usu.getTelefono());
           
             i=stm.executeUpdate();
            
                
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return i;
    }
       
       public int eliminarCliente(cliente usu) {
        int i=0;
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Cliente.EXCLUIR.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1,usu.getId_usuario() );
           
             i=stm.executeUpdate();
            
                
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return i;
    }
       
       public List<cliente> obtenerListaCliente(String id) {
        List<cliente> r = new ArrayList<cliente>();
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Cliente.LISTAR.obtenerComando());) {
            stm.clearParameters();
            try (ResultSet rs = stm.executeQuery()) {
                while(rs.next()){
                    r.add(getCliente(rs));
                }
            }
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
          return r;
    }
        
       private cliente getCliente(ResultSet rs) throws SQLException{
        
            cliente usu= new cliente(
                            rs.getString("id_cliente"),
                            rs.getString("usuario_id_usuario"),
                            rs.getString("apellidos"),
                            rs.getString("nombre"),
                            rs.getString("telefono")
                    
            );
            return usu; 
            
        }
       
     
     public Connection obtenerConexion() throws
            ClassNotFoundException,
            IllegalAccessException,
            InstantiationException,
            IOException,
            SQLException {
        BaseDatos bd = BaseDatos.obtenerInstancia();
        Connection cnx = bd.obtenerConexion();
        return cnx;
    }
}
