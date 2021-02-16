package com.ceiba.pedidoproducto.comando.fabrica;

import com.ceiba.pedidoproducto.comando.ComandoPedidoProducto;
import com.ceiba.pedidoproducto.modelo.entidad.PedidoProducto;
import org.springframework.stereotype.Component;

@Component
public class FabricaPedidoProducto {

    public PedidoProducto crear(ComandoPedidoProducto comandoPedidoProducto) {
        return new PedidoProducto(
                comandoPedidoProducto.getPedidoId(),
                comandoPedidoProducto.getProductoId(),
                comandoPedidoProducto.getCantidad()
        );
    }

}
