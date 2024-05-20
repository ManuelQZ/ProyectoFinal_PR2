package co.edu.uniquindio.proyecto.arcade.model;

import co.edu.uniquindio.proyecto.arcade.model.TipoUsuario;
import co.edu.uniquindio.proyecto.arcade.services.Acceso;

public class Usuario implements Acceso {

    private String nombre;
    private String correo;
    private String clave;
    private String saldo;
    private TipoUsuario tipoUsuario;

    public Usuario (String nombre, String correo, String clave, String saldo, TipoUsuario tipoUsuario) {
        this.nombre = nombre;
        this.correo = correo;
        this.clave = clave;
        this.saldo = saldo;
        this.tipoUsuario = tipoUsuario;
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

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String acceder() {
        if (tipoUsuario == TipoUsuario.CLIENTE) {
            return "cliente";
        } else if (tipoUsuario == TipoUsuario.EMPLEADO) {
            return "empleado";
        } else if (tipoUsuario == TipoUsuario.ADMINISTRADOR) {
            return "administrador";
        }
        return "error";
    }
}