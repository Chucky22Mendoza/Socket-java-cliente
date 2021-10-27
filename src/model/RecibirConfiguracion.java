/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Lenovo
 */
public class RecibirConfiguracion {
    private String codigo;
    private String mensaje;
    private ArcoConfiguracion datos;

    public RecibirConfiguracion() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public ArcoConfiguracion getDatos() {
        return datos;
    }

    public void setDatos(ArcoConfiguracion datos) {
        this.datos = datos;
    }
    
}
