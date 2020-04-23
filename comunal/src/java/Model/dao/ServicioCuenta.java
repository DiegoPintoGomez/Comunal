/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.dao;


import Objetos.Cuenta;
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
public class ServicioCuenta {

     public Optional<Cuenta> obtenerCuenta(String Cuenta) {
        Optional<Cuenta> r = Optional.empty();
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Cuenta.CONSULTAR.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, Cuenta);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    r = Optional.of(new Cuenta(
                            rs.getString("num_cuenta"),
                            rs.getInt("tipo_cuenta_id_tipo_cuenta"),
                            rs.getString("cliente_id_cliente"),
                            rs.getString("moneda_nombre"),
                            rs.getDate("fecha_creacion"),
                            rs.getDouble("limite_transferencia_diaria"),
                            rs.getInt("activa"),
                            rs.getDouble("saldo_inicial"),
                            rs.getDate("fecha_ultima_aplicacion"),
                            rs.getDouble("saldo_final")
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
     
       public int insertarCuenta(Cuenta Cuenta) {
        int i=0;
        int Numcue= this.getNewNumber()+1;
        String num= String.valueOf(Numcue);
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Cuenta.INSERTAR.obtenerComando());) {
            stm.clearParameters();
            //
            //generar el numero de la cuenta
            //
            stm.setString(1,num);
            
            stm.setInt(2,Cuenta.getTipo_cuenta_id_tipo_cuenta());
            
            stm.setString(3,Cuenta.getCliente_id_cliente());
            
            stm.setString(4, Cuenta.getMoneda_nombre());
            
            stm.setDate(5,Cuenta.getFecha_creacion());
            
            stm.setDouble(6,Cuenta.getLimite_transferencia_diaria());
            
            stm.setInt(7, Cuenta.getActiva());
            
            stm.setDouble(8, Cuenta.getSaldo_inicial());
           
            stm.setDate(9,Cuenta.getFecha_ultima_aplicacion());
            
            stm.setDouble(10, Cuenta.getSaldo_final());
            
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
       
       public int eliminarCuenta(Cuenta usu) {
        int i=0;
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Cuenta.EXCLUIR.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1,usu.getNum_cuenta());
           
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
       
       public List<Cuenta> obtenerListaCuenta(String id) {
        List<Cuenta> r = new ArrayList<Cuenta>();
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Cuenta.LISTAR.obtenerComando());) {
            
            stm.clearParameters();
            stm.setString(1,id);
            try (ResultSet rs = stm.executeQuery()) {
                while(rs.next()){
                    r.add(getCuenta(rs));
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
       public List<Cuenta> obtenerListaTotalCuenta() {
        List<Cuenta> r = new ArrayList<Cuenta>();
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Cuenta.LISTARTOTAL.obtenerComando());) {     
            stm.clearParameters();
            try (ResultSet rs = stm.executeQuery()) {
                while(rs.next()){
                    r.add(getCuenta(rs));
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
        
       private Cuenta getCuenta(ResultSet rs) throws SQLException{
        
            Cuenta usu= new Cuenta(
                            rs.getString("num_cuenta"),
                            rs.getInt("tipo_cuenta_id_tipo_cuenta"),
                            rs.getString("cliente_id_cliente"),
                            rs.getString("moneda_nombre"),
                            rs.getDate("fecha_creacion"),
                            rs.getDouble("limite_transferencia_diaria"),
                            rs.getInt("activa"),
                            rs.getDouble("saldo_inicial"),
                            rs.getDate("fecha_ultima_aplicacion"),
                            rs.getDouble("saldo_final")
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
     
     public int getNewNumber(){
     Cuenta r= new Cuenta();
     String SQL= "SELECT * FROM cuenta ORDER BY num_cuenta DESC LIMIT 1";
     try (Connection cnx = obtenerConexion();
             PreparedStatement stm=cnx.prepareStatement(SQL)){
        try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    r =  new Cuenta(
                            rs.getString("num_cuenta"),
                            rs.getInt("tipo_cuenta_id_tipo_cuenta"),
                            rs.getString("cliente_id_cliente"),
                            rs.getString("moneda_nombre"),
                            rs.getDate("fecha_creacion"),
                            rs.getDouble("limite_transferencia_diaria"),
                            rs.getInt("activa"),
                            rs.getDouble("saldo_inicial"),
                            rs.getDate("fecha_ultima_aplicacion"),
                            rs.getDouble("saldo_final")
                    );
                    
                }
            }
     }
     catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
     if(r.getNum_cuenta().equals("")){
     return 0;
     }
        int i=Integer.valueOf(r.getNum_cuenta());
        ++i;
        return i;
     }
     
     public void actualizaMonto(double d,String id) {
          try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Cuenta.MODIFICAR.obtenerComando());) {
            stm.clearParameters();
            stm.setDouble(1, d);
            stm.setString(2, id);
            stm.executeUpdate();
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
           System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
     }
     
     
     
}
