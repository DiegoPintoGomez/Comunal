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
import java.sql.Date;
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
public class ServicioTransferencia {
     
       public int insertarTransferencia(String cuenta_origen, String cuenta_destino, String monto) {
           int i=0;
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Trasferencia.INSERTAR.obtenerComando());) {
            stm.clearParameters();
            //
            //generar el numero de la cuenta
            //
            stm.setString(1,cuenta_origen);
            stm.setString(2,cuenta_destino);
            stm.setString(3,monto);
            stm.setDate(4,new Date(System.currentTimeMillis()));
            stm.setInt(5, 1);
            
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
