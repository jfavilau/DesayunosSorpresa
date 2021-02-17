package com.ceiba.producto.servicio.testdatabuilder;

import com.ceiba.producto.modelo.dto.DtoProductoCantidad;
import com.ceiba.producto.modelo.entidad.Producto;

public class DtoProductoCantidadTestDataBuilder {
    private Producto producto;
    private int cantidad;

    public DtoProductoCantidadTestDataBuilder() {
        producto = new ProductoTestDataBuilder().build();
        cantidad = 2;
    }

    public DtoProductoCantidadTestDataBuilder conProducto(Producto producto) {
        this.producto = producto;
        return this;
    }

    public DtoProductoCantidadTestDataBuilder conCantidad(int cantidad) {
        this.cantidad = cantidad;
        return this;
    }


    public DtoProductoCantidad build() {
        return new DtoProductoCantidad(producto,cantidad);
    }}
