package Model.dao;

public enum IMEC_Favorita {
    INSERTAR("INSERT INTO Favorita (cliente_id_cliente, "
            + "cuenta_num_cuenta "
            + "VALUES (?, ?)"),
    //MODIFICAR("UPDATE estudiante SET apellidos=?, nombre=? WHERE id=?; "),
    EXCLUIR("DELETE FROM Favorita WHERE cliente_id_cliente=?; "),
    CONSULTAR("SELECT * FROM Favorita WHERE cliente_id_cliente=?; "),
    LISTAR("SELECT * FROM Favorita ; ");

    IMEC_Favorita(String comando) {
        this.comando = comando;
    }

    public String obtenerComando() {
        return comando;
    }

    private final String comando;
}
