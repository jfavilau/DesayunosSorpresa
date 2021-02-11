package com.ceiba.producto.servicio.testdatabuilder;

import com.ceiba.producto.modelo.entidad.Producto;

public class ProductoTestDataBuilder {
    private Long id;
    private String nombre;
    private String descripcion;
    private String imagen;
    private Double precio;

    public ProductoTestDataBuilder() {
        nombre = "Desayuno día de san valentin";
        descripcion = "Sandwich, jugo de naranja, fruta";
        imagen = "assets/desayuno-ancheta-de-mi-tierra.jpg";
        precio = 145000.00;
    }

    public ProductoTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ProductoTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public Producto build() {
        return new Producto(id,nombre, descripcion,imagen, precio);
    }}
