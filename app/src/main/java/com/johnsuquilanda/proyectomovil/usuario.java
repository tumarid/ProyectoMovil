package com.johnsuquilanda.proyectomovil;

public class usuario {
    private String usuario;
    private String contraseña;
    private String Nombre;
    private String apellido;
    private  String Telefono;
    private String Correo;
    private String Direccion;

    public usuario(String usuario) {
        this.usuario = usuario;
    }

    public usuario(String usuario, String contraseña, String nombre, String apellido, String telefono, String correo, String direccion) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        Nombre = nombre;
        this.apellido = apellido;
        Telefono = telefono;
        Correo = correo;
        Direccion = direccion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }
}
