package com.ceiba.pedido.servicio;

import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.puerto.repositorio.RepositorioPedido;

public class ServicioCambiarEstadoPedido {

    private final RepositorioPedido repositorioPedido;

    public ServicioCambiarEstadoPedido(RepositorioPedido repositorioPedido) {
        this.repositorioPedido = repositorioPedido;
    }

    public void ejecutar(Pedido pedido) {
        this.repositorioPedido.cambiarEstadoPedido(pedido);
    }
}
