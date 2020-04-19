package Model.dao;

public enum IMEC_Trasferencia {
    INSERTAR("INSERT INTO transferencia(cuenta_origen, cuenta_destino, monto, fecha, aplicado) VALUES (?,?,?,?,?);"),
            
    //MODIFICAR("UPDATE estudiante SET apellidos=?, nombre=? WHERE id=?; "),
    EXCLUIR("DELETE FROM Movimiento WHERE id_movimiento=?; "),
    CONSULTAR("SELECT * FROM Movimiento WHERE id_movimiento=?; "),
    LISTAR("SELECT * FROM Movimiento ; ");

    IMEC_Trasferencia(String comando) {
        this.comando = comando;
    }

    public String obtenerComando() {
        return comando;
    }

    private final String comando;
}
