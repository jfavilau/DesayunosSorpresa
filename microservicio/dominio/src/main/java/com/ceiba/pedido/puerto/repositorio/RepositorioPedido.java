package com.ceiba.pedido.puerto.repositorio;

import com.ceiba.pedido.modelo.entidad.Pedido;

public interface RepositorioPedido {
    Long realizarPedido(Pedido pedido);
    void cambiarEstadoPedido(Pedido pedido);
}
