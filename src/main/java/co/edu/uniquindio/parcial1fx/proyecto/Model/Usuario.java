public class Usuario {

    private String nombre;
    private String correo;
    private Double Saldo;

    public Usuario(String nombre, String correo, Double saldo) {
        this.nombre = nombre;
        this.correo = correo;
        Saldo = saldo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Double getSaldo() {
        return Saldo;
    }

    public void setSaldo(Double saldo) {
        Saldo = saldo;
    }
}