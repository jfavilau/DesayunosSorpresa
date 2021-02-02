package com.ceiba.producto.servicio.testdatabuilder;

import com.ceiba.producto.comando.ComandoProducto;

import java.util.UUID;

public class ComandoProductoTestDataBuilder {

    private Long id;
    private String nombre;
    private String descripcion;
    private Double precio;

    public ComandoProductoTestDataBuilder() {
        nombre = UUID.randomUUID().toString();
        descripcion = "1234";
        precio = 10000.00;
    }

    public ComandoProductoTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ComandoProducto build() {
        return new ComandoProducto(id,nombre, descripcion,precio);
    }
}
