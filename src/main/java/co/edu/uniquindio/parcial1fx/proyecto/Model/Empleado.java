package co.edu.uniquindio.parcial1fx.proyecto.Model;

public class Empleado {

    private String nombre;
    private String cargo;
    private String nivelPermiso;

    public Empleado(String nombre, String cargo, String nivelPermiso) {
        this.nombre = nombre;
        this.cargo = cargo;
        this.nivelPermiso = nivelPermiso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNivelPermiso() {
        return nivelPermiso;
    }

    public void setNivelPermiso(String nivelPermiso) {
        this.nivelPermiso = nivelPermiso;
    }
}
