package com.example.exameninterfaces.model;

import javax.persistence.*;

@Entity
@Table(name = "informacioncliente")
public class Cliente {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "nombre")
    private String nombre;

    @Basic
    @Column(name = "sexo")
    private String sexo;

    @Basic
    @Column
    private Double peso;

    @Basic
    @Column
    private Integer edad;

    @Basic
    @Column
    private Double talla;

    @Basic
    @Column
    private String tipoActividad;

    @Basic
    @Column
    private String observaciones;

    @Basic
    @Column
    private Double GER;

    @Basic
    @Column
    private Double GET;

    public Cliente() {

    }

    public Cliente(int id, String nombre, String sexo, Double peso, Integer edad, Double talla, String tipoActividad, String observaciones, Double GER, Double GET) {
        this.id = id;
        this.nombre = nombre;
        this.sexo = sexo;
        this.peso = peso;
        this.edad = edad;
        this.talla = talla;
        this.tipoActividad = tipoActividad;
        this.observaciones = observaciones;
        this.GER = GER;
        this.GET = GET;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Double getTalla() {
        return talla;
    }

    public void setTalla(Double talla) {
        this.talla = talla;
    }

    public String getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(String tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Double getGER() {
        return GER;
    }

    public void setGER(Double GER) {
        this.GER = GER;
    }

    public Double getGET() {
        return GET;
    }

    public void setGET(Double GET) {
        this.GET = GET;
    }
}
