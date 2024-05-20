package co.edu.uniquindio.proyecto.arcade.model;

import co.edu.uniquindio.proyecto.arcade.services.Acceso;

public class UsuarioProxy implements Acceso {

    private String correo;
    private String clave;
    private Usuario usuario;

    public UsuarioProxy(String correo, String clave, Usuario usuario) {
        this.correo = correo;
        this.clave = clave;
        this.usuario = usuario;
    }

    public boolean autenticar(){
        String correoUsuario = usuario.getCorreo();
        String claveUsuario = usuario.getClave();
        return (this.correo.equals(correoUsuario) && this.clave.equals(claveUsuario));
    }

    @Override
    public String acceder() {
        if (autenticar()) {
            return usuario.acceder();
        }
        return "No se pudo acceder, credenciales erroneas";
    }
}