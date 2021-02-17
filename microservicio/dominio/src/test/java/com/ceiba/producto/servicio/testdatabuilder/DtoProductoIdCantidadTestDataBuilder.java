package com.ceiba.producto.servicio.testdatabuilder;

import com.ceiba.producto.modelo.dto.DtoProductoIdCantidad;

public class DtoProductoIdCantidadTestDataBuilder {
    private Long id;
    private int cantidad;

    public DtoProductoIdCantidadTestDataBuilder() {
        id = 1L;
        cantidad = 2;
    }

    public DtoProductoIdCantidadTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public DtoProductoIdCantidadTestDataBuilder conCantidad(int cantidad) {
        this.cantidad = cantidad;
        return this;
    }


    public DtoProductoIdCantidad build() {
        DtoProductoIdCantidad dtoProductoIdCantidad = new DtoProductoIdCantidad();
        dtoProductoIdCantidad.setId(id);
        dtoProductoIdCantidad.setCantidad(cantidad);
        return dtoProductoIdCantidad;
    }
}
