package com.ceiba.pedidoProducto.comando.fabrica;

import com.ceiba.pedidoProducto.comando.ComandoPedidoProducto;
import com.ceiba.pedidoProductos.modelo.entidad.PedidoProducto;
import com.ceiba.producto.comando.ComandoProducto;
import com.ceiba.producto.modelo.entidad.Producto;
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
