package co.edu.uniquindio.proyecto.arcade.model;

import co.edu.uniquindio.proyecto.arcade.model.builder.UsuarioBuilder;
import co.edu.uniquindio.proyecto.arcade.services.Acceso;

public class Usuario implements Acceso {

    private String nombre;
    private String correo;
    private String clave;
    private String saldo;
    private TipoUsuario tipoUsuario;

    public Usuario (UsuarioBuilder builder) {
        this.nombre = builder.nombre;
        this.correo = builder.correo;
        this.clave = builder.clave;
        this.saldo = builder.saldo;
        this.tipoUsuario = builder.tipoUsuario;
    }

    public String getNombre() {
        return nombre;
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

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
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