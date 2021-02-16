package com.ceiba.producto.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoProducto {
    private Long id;
    private String nombre;
    private String descripcion;
    private String imagen;
    private Double precio;
    private int cantidad;

}
