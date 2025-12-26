package com.apisienteproto.protoapisiente.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="costos_fijos_productos")
public class CostosFijosModel {
    
    @Id
    @Column(name = "id_producto", insertable = false, updatable = false)
    private int idProducto;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_producto")
    private ProductosModel producto;

    @Column
    private double costoLuz;

    @Column
    private double costoAgua;

    @Column
    private double costoGas;

    @Column
    private double costoAseo;

    @Column
    private double costoInternet;

    @Column
    private double manoDeObra;

    @Column
    private String comentarioManoDeObra;

    @Column
    private double costoTransporte;

    @Column
    private double costoPerdidas;

    @Column
    private double costoHerramientas;

    @Column
    private double costoMarketingRedes;

    @Column
    private double costoMarketingDisenador;

    @Column
    private double costoAdmin;

    @Column
    private double costoEtiqueta;

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public ProductosModel getProducto() {
        return producto;
    }

    public void setProducto(ProductosModel producto) {
        this.producto = producto;
    }

    public double getCostoLuz() {
        return costoLuz;
    }

    public void setCostoLuz(double costoLuz) {
        this.costoLuz = costoLuz;
    }

    public double getCostoAgua() {
        return costoAgua;
    }

    public void setCostoAgua(double costoAgua) {
        this.costoAgua = costoAgua;
    }

    public double getCostoGas() {
        return costoGas;
    }

    public void setCostoGas(double costoGas) {
        this.costoGas = costoGas;
    }

    public double getCostoAseo() {
        return costoAseo;
    }

    public void setCostoAseo(double costoAseo) {
        this.costoAseo = costoAseo;
    }

    public double getCostoInternet() {
        return costoInternet;
    }

    public void setCostoInternet(double costoInternet) {
        this.costoInternet = costoInternet;
    }

    public double getManoDeObra() {
        return manoDeObra;
    }

    public void setManoDeObra(double manoDeObra) {
        this.manoDeObra = manoDeObra;
    }

    public String getComentarioManoDeObra() {
        return comentarioManoDeObra;
    }

    public void setComentarioManoDeObra(String comentarioManoDeObra) {
        this.comentarioManoDeObra = comentarioManoDeObra;
    }

    public double getCostoTransporte() {
        return costoTransporte;
    }

    public void setCostoTransporte(double costoTransporte) {
        this.costoTransporte = costoTransporte;
    }

    public double getCostoPerdidas() {
        return costoPerdidas;
    }

    public void setCostoPerdidas(double costoPerdidas) {
        this.costoPerdidas = costoPerdidas;
    }

    public double getCostoHerramientas() {
        return costoHerramientas;
    }

    public void setCostoHerramientas(double costoHerramientas) {
        this.costoHerramientas = costoHerramientas;
    }

    public double getCostoMarketingRedes() {
        return costoMarketingRedes;
    }

    public void setCostoMarketingRedes(double costoMarketingRedes) {
        this.costoMarketingRedes = costoMarketingRedes;
    }

    public double getCostoMarketingDisenador() {
        return costoMarketingDisenador;
    }

    public void setCostoMarketingDisenador(double costoMarketingDisenador) {
        this.costoMarketingDisenador = costoMarketingDisenador;
    }

    public double getCostoAdmin() {
        return costoAdmin;
    }

    public void setCostoAdmin(double costoAdmin) {
        this.costoAdmin = costoAdmin;
    }

    public double getCostoEtiqueta() {
        return costoEtiqueta;
    }

    public void setCostoEtiqueta(double costoEtiqueta) {
        this.costoEtiqueta = costoEtiqueta;
    }

    
    
}
