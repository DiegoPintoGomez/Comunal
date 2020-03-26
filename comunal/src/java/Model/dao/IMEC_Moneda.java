package Model.dao;

public enum IMEC_Moneda {
    INSERTAR("INSERT INTO moneda (nombre,descripcion,simbolo,tipo_cambio_compra,tipo_cambio_venta) VALUES (?, ?, ?, ?, ?)"),
    //MODIFICAR("UPDATE estudiante SET apellidos=?, nombre=? WHERE id=?; "),
    EXCLUIR("DELETE FROM moneda WHERE nombre=?; "),
    CONSULTAR("SELECT * FROM moneda WHERE nombre=?; "),
    LISTAR("SELECT * FROM moneda ; ");

    IMEC_Moneda(String comando) {
        this.comando = comando;
    }

    public String obtenerComando() {
        return comando;
    }

    private final String comando;
}
