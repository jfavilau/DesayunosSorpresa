package com.ceiba.pedidoproducto.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoPedidoProducto {
    private Long pedidoId;
    private Long productoId;
    private int cantidad;

}
