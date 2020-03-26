/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.dao;

import Objetos.Moneda;
import Objetos.Usuario;
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
public class ServicioMoneda {

     public Optional<Moneda> obtenerMoneda(String Moneda) {
        Optional<Moneda> r = Optional.empty();
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Moneda.CONSULTAR.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, Moneda);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    r = Optional.of(new Moneda(
                            rs.getString("nombre"),
                            rs.getString("descripcion"),
                            rs.getString("simbolo"),
                            rs.getInt("tipo_cambio_compra"),                            
                            rs.getInt("tipo_cambio_venta")
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
     
       public int insertarMoneda(Moneda Moneda) {
        int i=0;
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Moneda.INSERTAR.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1,Moneda.getNombre() );
            stm.setString(2,Moneda.getDescripcion());
            stm.setString(3,Moneda.getSimbolo());
            stm.setDouble(4,Moneda.getTipo_cambio_compra());
            stm.setDouble(4,Moneda.getTipo_cambio_venta());
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
       
       public int eliminarMoneda(Moneda usu) {
        int i=0;
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Moneda.EXCLUIR.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1,usu.getNombre());
           
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
       
       public List<Moneda> obtenerListaMoneda(String id) {
        List<Moneda> r = new ArrayList<Moneda>();
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Moneda.LISTAR.obtenerComando());) {
            stm.clearParameters();
            try (ResultSet rs = stm.executeQuery()) {
                while(rs.next()){
                    r.add(getMoneda(rs));
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
        
       private Moneda getMoneda(ResultSet rs) throws SQLException{
        
            Moneda usu= new Moneda(
                            rs.getString("nombre"),
                            rs.getString("descripcion"),
                            rs.getString("simbolo"),
                            rs.getDouble("tipo_cambio_compra"),
                            rs.getDouble("tipo_cambio_venta")
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
