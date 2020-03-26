/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.dao;

import Objetos.Moneda;
import Objetos.tipo_cuenta;
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
public class ServicioTipo_Cuenta {

     public Optional<tipo_cuenta> obtenertipo_cuenta(String tipo_cuenta) {
        Optional<tipo_cuenta> r = Optional.empty();
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_tipo_cuenta.CONSULTAR.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, tipo_cuenta);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    r = Optional.of(new tipo_cuenta(
                            rs.getInt("id_tipo_cuenta"),
                            rs.getString("descripción"),
                            rs.getDouble("tasa_interés")
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
     
       public int insertarTipo_cuenta(tipo_cuenta tipo_cuenta) {
        int i=0;
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_tipo_cuenta.INSERTAR.obtenerComando());) {
            stm.clearParameters();
            stm.setInt(1, tipo_cuenta.getId_tipo_cuenta());
            stm.setString(2, tipo_cuenta.getDescripcion());
            stm.setDouble(3, tipo_cuenta.getTasa_interés());
            
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
       
       public int eliminartipo_cuenta(tipo_cuenta usu) {
        int i=0;
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Moneda.EXCLUIR.obtenerComando());) {
            stm.clearParameters();
            stm.setInt(1,usu.getId_tipo_cuenta());
           
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
       
       public List<tipo_cuenta> obtenerListaTipo_cuenta( ) {
        List<tipo_cuenta> r = new ArrayList<tipo_cuenta>();
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_tipo_cuenta.LISTAR.obtenerComando());) {
            stm.clearParameters();
            try (ResultSet rs = stm.executeQuery()) {
                while(rs.next()){
                    r.add(getTipo_cuenta(rs));
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
        
       private tipo_cuenta getTipo_cuenta(ResultSet rs) throws SQLException{
        
            tipo_cuenta usu= new tipo_cuenta(
                            rs.getInt("id_tipo_cuenta"),
                            rs.getString("descripción"),
                            rs.getDouble("tasa_interés")
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
