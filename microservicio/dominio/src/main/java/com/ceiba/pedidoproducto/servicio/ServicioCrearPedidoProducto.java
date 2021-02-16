package com.ceiba.pedidoproducto.servicio;

import com.ceiba.pedidoproducto.modelo.entidad.PedidoProducto;
import com.ceiba.pedidoproducto.puerto.repositorio.RepositorioPedidoProducto;


public class ServicioCrearPedidoProducto {

    private final RepositorioPedidoProducto repositorioPedidoProducto;

    public ServicioCrearPedidoProducto(RepositorioPedidoProducto repositorioPedidoProducto) {
        this.repositorioPedidoProducto = repositorioPedidoProducto;
    }

    public Long ejecutar(PedidoProducto pedidoProducto) {
        return this.repositorioPedidoProducto.crearPedidoProducto(pedidoProducto);
    }
}



