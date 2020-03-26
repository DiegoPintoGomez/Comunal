package Model.dao;

public enum IMEC_Movimiento {
    INSERTAR("INSERT INTO Movimiento (id_movimiento,"
            + "cuenta_num_cuenta,"
            + "monto,"
            + "fecha,"
            + "aplicado,"
            + "movimientocol) VALUES (?, ?, ?, ?, ?, ?)"),
    //MODIFICAR("UPDATE estudiante SET apellidos=?, nombre=? WHERE id=?; "),
    EXCLUIR("DELETE FROM Movimiento WHERE id_movimiento=?; "),
    CONSULTAR("SELECT * FROM Movimiento WHERE id_movimiento=?; "),
    LISTAR("SELECT * FROM Movimiento ; ");

    IMEC_Movimiento(String comando) {
        this.comando = comando;
    }

    public String obtenerComando() {
        return comando;
    }

    private final String comando;
}
