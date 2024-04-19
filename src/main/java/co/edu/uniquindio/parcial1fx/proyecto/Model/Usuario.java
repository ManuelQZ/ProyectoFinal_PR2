package co.edu.uniquindio.parcial1fx.proyecto.Model;

import javafx.beans.binding.BooleanExpression;
import javafx.beans.value.ObservableValue;

public class Usuario {

    private String nombre;
    private String correo;
    private String saldo;

    public Usuario (String nombre, String correo, String saldo) {
        this.nombre = nombre;
        this.correo = correo;
        this.saldo = saldo;
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

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    public ObservableValue<String> correoProperty() {
        return null;
    }

    public ObservableValue<String> nombreProperty() {
        return null;
    }

    public BooleanExpression saldoProperty() {
    return null;
    }
}