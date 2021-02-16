package com.ceiba.pedidoProducto.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.pedidoProducto.comando.ComandoPedidoProducto;
import com.ceiba.pedidoProducto.comando.fabrica.FabricaPedidoProducto;
import com.ceiba.pedidoProductos.modelo.entidad.PedidoProducto;
import com.ceiba.pedidoProductos.servicio.ServicioCrearPedidoProducto;
import com.ceiba.producto.comando.ComandoProducto;
import com.ceiba.producto.comando.fabrica.FabricaProducto;
import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.servicio.ServicioCrearProducto;
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
