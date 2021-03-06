package Model.dao;

public enum IMEC_Cliente {
    INSERTAR("INSERT INTO cliente (id_cliente, usuario_id_usuario, apellidos, nombre, telefono) VALUES (?, ?, ?, ?, ?); "),
    //MODIFICAR("UPDATE estudiante SET apellidos=?, nombre=? WHERE id=?; "),
    EXCLUIR("DELETE FROM cliente WHERE id_cliente=?; "),
    CONSULTAR("SELECT * FROM cliente WHERE id_cliente=?; "),
    LISTAR("SELECT * FROM cliente ; "),
    OBTENER("SELECT * FROM CLIENTE WHERE  usuario_id_usuario=?; ");
    
    

    IMEC_Cliente(String comando) {
        this.comando = comando;
    }

    public String obtenerComando() {
        return comando;
    }

    private final String comando;
}
