package Model.dao;

public enum IMEC_tipo_cuenta {
    INSERTAR("INSERT INTO tipo_cuenta (id_tipo_cuenta, descripción, tasa_interés) VALUES (?, ?, ?)"),
    //MODIFICAR("UPDATE estudiante SET apellidos=?, nombre=? WHERE id=?; "),
    EXCLUIR("DELETE FROM tipo_cuenta WHERE id_tipo_cuenta = ?;"),
    CONSULTAR("SELECT * FROM tipo_cuenta WHERE id_tipo_cuenta=?; "),
    LISTAR("SELECT * FROM tipo_cuenta ; ");

    IMEC_tipo_cuenta(String comando) {
        this.comando = comando;
    }

    public String obtenerComando() {
        return comando;
    }

    private final String comando;
}
