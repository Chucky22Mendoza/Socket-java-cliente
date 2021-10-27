/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author Lenovo
 */
public class ArcoConfiguracion {
    private String nombre_arco;
    private String descripcion;
    private Coordenadas coordenadas;
    private int frecuencia_sincronizacion;
    private String ip_servidor;
    private String ip_rfid;
    private String direccion_log;
    private String tipo_arco;
    private String nombre_entidad;
    private List<Carril> carriles;

    public ArcoConfiguracion() {
    }

    public String getNombre_arco() {
        return nombre_arco;
    }

    public void setNombre_arco(String nombre_arco) {
        this.nombre_arco = nombre_arco;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Coordenadas getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(Coordenadas coordenadas) {
        this.coordenadas = coordenadas;
    }

    public int getFrecuencia_sincronizacion() {
        return frecuencia_sincronizacion;
    }

    public void setFrecuencia_sincronizacion(int frecuencia_sincronizacion) {
        this.frecuencia_sincronizacion = frecuencia_sincronizacion;
    }

    public String getIp_servidor() {
        return ip_servidor;
    }

    public void setIp_servidor(String ip_servidor) {
        this.ip_servidor = ip_servidor;
    }

    public String getIp_rfid() {
        return ip_rfid;
    }

    public void setIp_rfid(String ip_rfid) {
        this.ip_rfid = ip_rfid;
    }

    public String getDireccion_log() {
        return direccion_log;
    }

    public void setDireccion_log(String direccion_log) {
        this.direccion_log = direccion_log;
    }

    public String getTipo_arco() {
        return tipo_arco;
    }

    public void setTipo_arco(String tipo_arco) {
        this.tipo_arco = tipo_arco;
    }

    public String getNombre_entidad() {
        return nombre_entidad;
    }

    public void setNombre_entidad(String nombre_entidad) {
        this.nombre_entidad = nombre_entidad;
    }

    public List<Carril> getCarriles() {
        return carriles;
    }

    public void setCarriles(List<Carril> carriles) {
        this.carriles = carriles;
    }
    
}
