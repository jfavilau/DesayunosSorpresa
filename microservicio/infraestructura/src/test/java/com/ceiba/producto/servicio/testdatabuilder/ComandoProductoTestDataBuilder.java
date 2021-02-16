package com.ceiba.producto.servicio.testdatabuilder;

import com.ceiba.producto.comando.ComandoProducto;

import java.util.UUID;

public class ComandoProductoTestDataBuilder {

    private Long id;
    private String nombre;
    private String descripcion;
    private String imagen;
    private Double precio;
    private int cantidad;

    public ComandoProductoTestDataBuilder() {
        nombre = UUID.randomUUID().toString();
        descripcion = "1234";
        imagen = "https://as1.ftcdn.net/jpg/02/15/71/58/500_F_215715894_U2mmLeqcySfnDAnjKvLc03neRkL9DoSX.jpg";
        precio = 10000.00;
        cantidad = 1;
    }

    public ComandoProductoTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ComandoProducto build() {
        return new ComandoProducto(id,nombre, descripcion,imagen, precio, cantidad);
    }
}
