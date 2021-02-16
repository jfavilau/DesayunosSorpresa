package com.ceiba.pedidoProductos.modelo.entidad;

import lombok.Getter;

@Getter
public class PedidoProducto {

    private Long pedidoId;
    private Long productoId;
    private int cantidad;

    public PedidoProducto(Long pedidoId, Long productoId, int cantidad) {
        this.pedidoId = pedidoId;
        this.productoId = productoId;
        this.cantidad = cantidad;
    }
}
