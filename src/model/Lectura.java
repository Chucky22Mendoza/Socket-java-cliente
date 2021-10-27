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
public class Lectura {
    private String id;
    private String fecha_hora;
    private String id_carril;
    private String cve_arco;
    private List<Images> img_vehiculo;
    private String num_placa;
    private String niv;
    private String tid;
    private String nci;
    private String id_sis_entidades;

    public Lectura() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(String fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public String getId_carril() {
        return id_carril;
    }

    public void setId_carril(String id_carril) {
        this.id_carril = id_carril;
    }

    public String getCve_arco() {
        return cve_arco;
    }

    public void setCve_arco(String cve_arco) {
        this.cve_arco = cve_arco;
    }

    public List<Images> getImg_vehiculo() {
        return img_vehiculo;
    }

    public void setImg_vehiculo(List<Images> img_vehiculo) {
        this.img_vehiculo = img_vehiculo;
    }

    public String getNum_placa() {
        return num_placa;
    }

    public void setNum_placa(String num_placa) {
        this.num_placa = num_placa;
    }

    public String getNiv() {
        return niv;
    }

    public void setNiv(String niv) {
        this.niv = niv;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getNci() {
        return nci;
    }

    public void setNci(String nci) {
        this.nci = nci;
    }

    public String getId_sis_entidades() {
        return id_sis_entidades;
    }

    public void setId_sis_entidades(String id_sis_entidades) {
        this.id_sis_entidades = id_sis_entidades;
    }
    
}
