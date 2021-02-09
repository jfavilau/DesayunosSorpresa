package com.ceiba.pedido.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.pedido.comando.ComandoPedido;
import com.ceiba.pedido.comando.fabrica.FabricaPedido;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.servicio.ServicioRealizarPedido;
import org.springframework.stereotype.Component;

@Component
public class ManejadorRealizarPedido implements ManejadorComandoRespuesta<ComandoPedido, ComandoRespuesta<Long>> {

    private final FabricaPedido fabricaPedido;
    private final ServicioRealizarPedido servicioRealizarPedido;

    public ManejadorRealizarPedido(FabricaPedido fabricaPedido, ServicioRealizarPedido servicioRealizarPedido) {
        this.fabricaPedido = fabricaPedido;
        this.servicioRealizarPedido = servicioRealizarPedido;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoPedido comandoPedido) {
        Pedido pedido = this.fabricaPedido.crear(comandoPedido);
        return new ComandoRespuesta<>(this.servicioRealizarPedido.ejecutar(pedido));
    }
}
