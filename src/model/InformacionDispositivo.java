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
public class InformacionDispositivo {
    private String ip;
    private String Dispositivo;
    private String direccion_log;

    public InformacionDispositivo() {
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDispositivo() {
        return Dispositivo;
    }

    public void setDispositivo(String Dispositivo) {
        this.Dispositivo = Dispositivo;
    }

    public String getDireccion_log() {
        return direccion_log;
    }

    public void setDireccion_log(String direccion_log) {
        this.direccion_log = direccion_log;
    }
    
}
