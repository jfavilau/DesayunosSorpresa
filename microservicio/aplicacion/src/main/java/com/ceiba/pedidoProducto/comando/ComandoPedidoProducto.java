package com.ceiba.pedidoproducto.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoPedidoProducto {

    private Long pedidoId;
    private Long productoId;
    private int cantidad;
}
