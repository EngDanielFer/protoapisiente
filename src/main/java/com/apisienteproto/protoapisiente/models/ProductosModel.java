package com.apisienteproto.protoapisiente.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="productos")
public class ProductosModel {

    @Id
    // @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column
    private String nombre_producto;

    @Column
    private String descripcion_producto;

    @Column
    private int peso_producto;

    @Column
    private double costo_produccion;

    @Column
    private double ganancia_por_mayor;

    @Column
    private double ganancia_detal;

    @Column
    private double precio_por_mayor;

    @Column
    private double precio_detal;

    @Column(columnDefinition="LONGBLOB")
    private byte[] imagen_producto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getDescripcion_producto() {
        return descripcion_producto;
    }

    public void setDescripcion_producto(String descripcion_producto) {
        this.descripcion_producto = descripcion_producto;
    }

    public int getPeso_producto() {
        return peso_producto;
    }

    public void setPeso_producto(int peso_producto) {
        this.peso_producto = peso_producto;
    }

    public double getCosto_produccion() {
        return costo_produccion;
    }

    public void setCosto_produccion(double costo_produccion) {
        this.costo_produccion = costo_produccion;
    }

    public double getGanancia_por_mayor() {
        return ganancia_por_mayor;
    }

    public void setGanancia_por_mayor(double ganancia_por_mayor) {
        this.ganancia_por_mayor = ganancia_por_mayor;
    }

    public double getGanancia_detal() {
        return ganancia_detal;
    }

    public void setGanancia_detal(double ganancia_detal) {
        this.ganancia_detal = ganancia_detal;
    }

    public double getPrecio_por_mayor() {
        return precio_por_mayor;
    }

    public void setPrecio_por_mayor(double precio_por_mayor) {
        this.precio_por_mayor = precio_por_mayor;
    }

    public double getPrecio_detal() {
        return precio_detal;
    }

    public void setPrecio_detal(double precio_detal) {
        this.precio_detal = precio_detal;
    }

    public byte[] getImagen_producto() {
        return imagen_producto;
    }

    public void setImagen_producto(byte[] imagen_producto) {
        this.imagen_producto = imagen_producto;
    }

    
}
