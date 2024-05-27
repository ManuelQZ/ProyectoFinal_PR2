package co.edu.uniquindio.proyecto.arcade.model.builder;

import co.edu.uniquindio.proyecto.arcade.model.TipoUsuario;
import co.edu.uniquindio.proyecto.arcade.model.Usuario;

public class UsuarioBuilder {

    public String nombre;
    public String correo;
    public String clave;
    public String saldo;
    public TipoUsuario tipoUsuario;

    public UsuarioBuilder () {
    }

    public UsuarioBuilder nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public UsuarioBuilder correo(String correo) {
        this.correo = correo;
        return this;
    }

    public UsuarioBuilder saldo(String saldo) {
        this.saldo = saldo;
        return this;
    }

    public UsuarioBuilder tipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
        return this;
    }

    public UsuarioBuilder clave(String clave) {
        this.clave = clave;
        return this;
    }

    public Usuario build() {
        return new Usuario(this);
    }
}
