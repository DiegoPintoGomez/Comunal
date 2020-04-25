package Model.dao;

public enum IMEC_Usuario {
    INSERTAR("INSERT INTO Usuario (id_usuario, clave_acceso, clave_vencida, rol) VALUES (?, ?, ?, ?)"),
    MODIFICAR("UPDATE Usuario SET clave_acceso=?, clave_vencida=0 WHERE id_usuario=?; "),
    EXCLUIR("DELETE FROM Usuario WHERE id_usuario=?; "),
    CONSULTAR("SELECT id_usuario,clave_acceso,clave_vencida,rol FROM usuario WHERE id_usuario=?; "),
    LISTAR("SELECT * FROM Usuario ; ");

    IMEC_Usuario(String comando) {
        this.comando = comando;
    }

    public String obtenerComando() {
        return comando;
    }

    private final String comando;
}
