package com.ceiba.pedido.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.pedido.comando.ComandoPedido;
import com.ceiba.pedido.comando.fabrica.FabricaPedido;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.servicio.ServicioCambiarEstadoPedido;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCambiarEstadoPedido implements ManejadorComando<ComandoPedido> {

    private final FabricaPedido fabricaPedido;
    private final ServicioCambiarEstadoPedido servicioCambiarEstadoPedido;

    public ManejadorCambiarEstadoPedido(FabricaPedido fabricaPedido, ServicioCambiarEstadoPedido servicioCambiarEstadoPedido) {
        this.fabricaPedido = fabricaPedido;
        this.servicioCambiarEstadoPedido = servicioCambiarEstadoPedido;
    }

    public void ejecutar(ComandoPedido comandoPedido) {
        Pedido pedido = this.fabricaPedido.crear(comandoPedido);
        this.servicioCambiarEstadoPedido.ejecutar(pedido);
    }
}
