package com.ceiba.pedidoproducto.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.pedidoproducto.comando.ComandoPedidoProducto;
import com.ceiba.pedidoproducto.comando.fabrica.FabricaPedidoProducto;
import com.ceiba.pedidoproducto.modelo.entidad.PedidoProducto;
import com.ceiba.pedidoproducto.servicio.ServicioCrearPedidoProducto;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearPedidoProducto implements ManejadorComandoRespuesta<ComandoPedidoProducto, ComandoRespuesta<Long>> {

    private final FabricaPedidoProducto fabricaPedidoProducto;
    private final ServicioCrearPedidoProducto servicioCrearPedidoProducto;

    public ManejadorCrearPedidoProducto(FabricaPedidoProducto fabricaPedidoProducto, ServicioCrearPedidoProducto servicioCrearPedidoProducto) {
        this.fabricaPedidoProducto = fabricaPedidoProducto;
        this.servicioCrearPedidoProducto = servicioCrearPedidoProducto;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoPedidoProducto comandoPedidoProducto) {
        PedidoProducto pedidoProducto = this.fabricaPedidoProducto.crear(comandoPedidoProducto);
        return new ComandoRespuesta<>(this.servicioCrearPedidoProducto.ejecutar(pedidoProducto));
    }
}
