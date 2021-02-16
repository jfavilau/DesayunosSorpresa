package com.ceiba.pedido.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.pedido.comando.ComandoPedido;
import com.ceiba.pedido.comando.fabrica.FabricaPedido;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.servicio.ServicioRealizarPedido;
import com.ceiba.pedidoproducto.comando.ComandoPedidoProducto;
import com.ceiba.pedidoproducto.comando.fabrica.FabricaPedidoProducto;
import com.ceiba.pedidoproducto.modelo.entidad.PedidoProducto;
import com.ceiba.pedidoproducto.servicio.ServicioCrearPedidoProducto;
import com.ceiba.producto.modelo.entidad.Producto;
import org.springframework.stereotype.Component;

@Component
public class ManejadorRealizarPedido implements ManejadorComandoRespuesta<ComandoPedido, ComandoRespuesta<Long>> {

    private final FabricaPedido fabricaPedido;
    private final FabricaPedidoProducto fabricaPedidoProducto;
    private final ServicioRealizarPedido servicioRealizarPedido;
    private final ServicioCrearPedidoProducto servicioCrearPedidoProducto;

    public ManejadorRealizarPedido(FabricaPedido fabricaPedido, ServicioRealizarPedido servicioRealizarPedido,
                                   FabricaPedidoProducto fabricaPedidoProducto, ServicioCrearPedidoProducto servicioCrearPedidoProducto) {
        this.fabricaPedido = fabricaPedido;
        this.fabricaPedidoProducto = fabricaPedidoProducto;
        this.servicioRealizarPedido = servicioRealizarPedido;
        this.servicioCrearPedidoProducto = servicioCrearPedidoProducto;

    }

    public ComandoRespuesta<Long> ejecutar(ComandoPedido comandoPedido) {
        Pedido pedido = this.fabricaPedido.crear(comandoPedido);
        Long pedidoId = this.servicioRealizarPedido.ejecutar(pedido);
        for (Producto item : pedido.getProducto()) {
            ComandoPedidoProducto prod = new ComandoPedidoProducto(pedidoId, item.getId(),item.getCantidad());
            PedidoProducto pedidoProducto = this.fabricaPedidoProducto.crear(prod);
            this.servicioCrearPedidoProducto.ejecutar(pedidoProducto);
        }
        return new ComandoRespuesta<>(pedidoId);
    }
}
