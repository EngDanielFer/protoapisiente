package com.apisienteproto.protoapisiente.models;

import java.util.List;

public class ProductoCompletoDTO {

    private int id;
    private String nombre_producto;
    private String descripcion_producto;
    private int peso_producto;
    private byte[] imagen_producto;
    private Double costo_produccion;
    private Double ganancia_por_mayor;
    private Double ganancia_detal;
    private Double precio_por_mayor;
    private Double precio_detal;
    private List<InsumoProductoDTO> insumos;
    private double costo_luz;
    private double costo_agua;
    private double costo_gas;
    private double costo_aseo;
    private double costo_internet;
    private double costo_mano_obra;
    private String comentario_mano_obra;
    private double costo_transporte;
    private double costo_perdidas;
    private double costo_herramientas;
    private double costo_mark_redes;
    private double costo_mark_disenador;
    private double costo_admin;
    private double costo_etiqueta;

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

    public byte[] getImagen_producto() {
        return imagen_producto;
    }

    public void setImagen_producto(byte[] imagen_producto) {
        this.imagen_producto = imagen_producto;
    }

    public Double getCosto_produccion() {
        return costo_produccion;
    }

    public void setCosto_produccion(Double costo_produccion) {
        this.costo_produccion = costo_produccion;
    }

    public Double getGanancia_por_mayor() {
        return ganancia_por_mayor;
    }

    public void setGanancia_por_mayor(Double ganancia_por_mayor) {
        this.ganancia_por_mayor = ganancia_por_mayor;
    }

    public Double getGanancia_detal() {
        return ganancia_detal;
    }

    public void setGanancia_detal(Double ganancia_detal) {
        this.ganancia_detal = ganancia_detal;
    }

    public Double getPrecio_por_mayor() {
        return precio_por_mayor;
    }

    public void setPrecio_por_mayor(Double precio_por_mayor) {
        this.precio_por_mayor = precio_por_mayor;
    }

    public Double getPrecio_detal() {
        return precio_detal;
    }

    public void setPrecio_detal(Double precio_detal) {
        this.precio_detal = precio_detal;
    }

    public List<InsumoProductoDTO> getInsumos() {
        return insumos;
    }

    public void setInsumos(List<InsumoProductoDTO> insumos) {
        this.insumos = insumos;
    }

    public double getCosto_luz() {
        return costo_luz;
    }

    public void setCosto_luz(double costo_luz) {
        this.costo_luz = costo_luz;
    }

    public double getCosto_agua() {
        return costo_agua;
    }

    public void setCosto_agua(double costo_agua) {
        this.costo_agua = costo_agua;
    }

    public double getCosto_gas() {
        return costo_gas;
    }

    public void setCosto_gas(double costo_gas) {
        this.costo_gas = costo_gas;
    }

    public double getCosto_aseo() {
        return costo_aseo;
    }

    public void setCosto_aseo(double costo_aseo) {
        this.costo_aseo = costo_aseo;
    }

    public double getCosto_internet() {
        return costo_internet;
    }

    public void setCosto_internet(double costo_internet) {
        this.costo_internet = costo_internet;
    }

    public double getCosto_mano_obra() {
        return costo_mano_obra;
    }

    public void setCosto_mano_obra(double costo_mano_obra) {
        this.costo_mano_obra = costo_mano_obra;
    }

    public String getComentario_mano_obra() {
        return comentario_mano_obra;
    }

    public void setComentario_mano_obra(String comentario_mano_obra) {
        this.comentario_mano_obra = comentario_mano_obra;
    }

    public double getCosto_transporte() {
        return costo_transporte;
    }

    public void setCosto_transporte(double costo_transporte) {
        this.costo_transporte = costo_transporte;
    }

    public double getCosto_perdidas() {
        return costo_perdidas;
    }

    public void setCosto_perdidas(double costo_perdidas) {
        this.costo_perdidas = costo_perdidas;
    }

    public double getCosto_herramientas() {
        return costo_herramientas;
    }

    public void setCosto_herramientas(double costo_herramientas) {
        this.costo_herramientas = costo_herramientas;
    }

    public double getCosto_mark_redes() {
        return costo_mark_redes;
    }

    public void setCosto_mark_redes(double costo_mark_redes) {
        this.costo_mark_redes = costo_mark_redes;
    }

    public double getCosto_mark_disenador() {
        return costo_mark_disenador;
    }

    public void setCosto_mark_disenador(double costo_mark_disenador) {
        this.costo_mark_disenador = costo_mark_disenador;
    }

    public double getCosto_admin() {
        return costo_admin;
    }

    public void setCosto_admin(double costo_admin) {
        this.costo_admin = costo_admin;
    }

    public double getCosto_etiqueta() {
        return costo_etiqueta;
    }

    public void setCosto_etiqueta(double costo_etiqueta) {
        this.costo_etiqueta = costo_etiqueta;
    }

}
