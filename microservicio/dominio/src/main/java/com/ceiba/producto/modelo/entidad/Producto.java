package com.ceiba.producto.modelo.entidad;

import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import static com.ceiba.dominio.ValidadorArgumento.validarPositivo;

@Getter
public class Producto {

    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DEL_PRODUCTO = "Se debe ingresar el nombre del producto";
    private static final String SE_DEBE_INGRESAR_PRECIO_POSITIVO = "El valor del precio debe ser positivo";
    private static final String SE_DEBE_INGRESAR_PRECIO = "Se debe ingresar un valor para el precio";

    private Long id;
    private String nombre;
    private String descripcion;
    private String imagen;
    private Double precio;

    public Producto(Long id,String nombre, String descripcion, String imagen, Double precio) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.precio = precio;
    }

}
