package Model.dao;

public enum IMEC_Usuario {
    INSERTAR("INSERT INTO Usuario (id_usuario,clave_acceso,clave_vencida,rol) VALUES (?, ?, ?)?"),
    MODIFICAR("UPDATE estudiante SET apellidos=?, nombre=? WHERE id=?; "),
    EXCLUIR("DELETE FROM estudiante WHERE id=?; "),
    CONSULTAR("SELECT id, apellidos, nombre FROM estudiante WHERE id=?; "),
    LISTAR("SELECT id, apellidos, nombre FROM estudiante ORDER BY apellidos; ");

    IMEC_Usuario(String comando) {
        this.comando = comando;
    }

    public String obtenerComando() {
        return comando;
    }

    private final String comando;
}
