/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.dao;
 

import Objetos.Movimiento;
import Objetos.favorita;
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
public class ServicioMovimiento {

     public Optional<Movimiento> obtenerMovimiento(int Movimiento) {
        Optional<Movimiento> r = Optional.empty();
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Movimiento.CONSULTAR.obtenerComando());) {
            stm.clearParameters();
            stm.setInt(1, Movimiento);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    r = Optional.of(new Movimiento(
                            rs.getInt("id_movimiento"),
                            rs.getDouble("cuenta_num_cuenta"),
                            rs.getDouble("monto"),
                            rs.getDate("fecha"),
                            rs.getInt("aplicado"),
                            rs.getString("moviento")
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
     
       public int insertarMovimiento(Movimiento Movimiento) {
        int i=0;
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Movimiento.INSERTAR.obtenerComando());) {
            stm.clearParameters();
            stm.setInt(1,Movimiento.getId_movimiento());
            stm.setDouble(2,Movimiento.getCuenta_num_cuenta());
            stm.setDouble(3,Movimiento.getMonto());
            stm.setDate(4, Movimiento.getFecha());
            stm.setInt(5,Movimiento.getAplicado());
            stm.setString(6, Movimiento.getMovimientocol());

            
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
       
       public int eliminarfavorita(favorita usu) {
        int i=0;
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Favorita.EXCLUIR.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1,usu.getCliente_id_cliente());
           
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
       
       public List<favorita> obtenerListaFavorita(String id) {
        List<favorita> r = new ArrayList<favorita>();
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Favorita.LISTAR.obtenerComando());) {
            stm.clearParameters();
            try (ResultSet rs = stm.executeQuery()) {
                while(rs.next()){
                    r.add(getFavorita(rs));
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
        
       private favorita getFavorita(ResultSet rs) throws SQLException{
        
            favorita usu= new favorita(
                            rs.getString("cliente_id_cliente"),
                            rs.getString("cuenta_num_cuenta")
                          
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
