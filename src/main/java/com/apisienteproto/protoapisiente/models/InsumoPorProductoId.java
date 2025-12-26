package com.apisienteproto.protoapisiente.models;

import java.io.Serializable;
import java.util.Objects;

public class InsumoPorProductoId implements Serializable {

    private int idProducto;
    private int idInsumo;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InsumoPorProductoId)) {
            return false;
        }
        InsumoPorProductoId that = (InsumoPorProductoId) o;
        return idProducto == that.idProducto && idInsumo == that.idInsumo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProducto, idInsumo);
    }
}
