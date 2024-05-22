package co.edu.uniquindio.proyecto.arcade.model;

import co.edu.uniquindio.proyecto.arcade.services.Acceso;

public class UsuarioProxy implements Acceso {

    private String correo;
    private String clave;
    private Usuario usuario;

    public UsuarioProxy() {

    }

    public boolean autenticar(){
        String correoUsuario = usuario.getCorreo();
        String claveUsuario = usuario.getClave();
        return (this.correo.equals(correoUsuario) && this.clave.equals(claveUsuario));
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        this.correo = usuario.getCorreo();
        this.clave = usuario.getClave();
    }

    @Override
    public String acceder() {
        if (autenticar()) {
            return usuario.acceder();
        }
        return "No se pudo acceder, credenciales erroneas";
    }
}