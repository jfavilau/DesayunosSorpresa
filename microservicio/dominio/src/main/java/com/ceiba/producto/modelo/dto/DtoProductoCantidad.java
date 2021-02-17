package com.ceiba.producto.modelo.dto;

import com.ceiba.producto.modelo.entidad.Producto;
import lombok.Getter;

@Getter
public class DtoProductoCantidad {
    private Producto producto;
    private int cantidad;

    public DtoProductoCantidad(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }
}
