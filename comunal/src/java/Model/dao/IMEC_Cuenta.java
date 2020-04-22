package Model.dao;

public enum IMEC_Cuenta {
    INSERTAR("INSERT INTO Cuenta ("
            + "num_cuenta, "
            + "tipo_cuenta_id_tipo_cuenta, "
            + "cliente_id_cliente, "
            + "moneda_nombre,"
            + "fecha_creacion,"
            + "limite_transferencia_diaria,"
            + "activa,"
            + "saldo_inicial,"
            + "fecha_ultima_aplicacion,"
            + " saldo_final) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"),
    MODIFICAR("UPDATE Cuenta SET saldo_inicial=saldo_final, saldo_final = saldo_final + ? WHERE num_cuenta= ?;"),
    EXCLUIR("DELETE FROM Cuenta WHERE num_cuenta=?; "),
    CONSULTAR("SELECT * FROM Cuenta WHERE num_cuenta=?; "),
    LISTAR("SELECT * FROM Cuenta WHERE cliente_id_cliente=?; ");
    
    
    IMEC_Cuenta(String comando) {
        this.comando = comando;
    }

    public String obtenerComando() {
        return comando;
    }

    private final String comando;
}
