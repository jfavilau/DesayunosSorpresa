package com.ceiba.pedidoProductos.servicio;

import com.ceiba.pedidoProductos.modelo.entidad.PedidoProducto;
import com.ceiba.pedidoProductos.puerto.repositorio.RepositorioPedidoProducto;


public class ServicioCrearPedidoProducto {

    private final RepositorioPedidoProducto repositorioPedidoProducto;

    public ServicioCrearPedidoProducto(RepositorioPedidoProducto repositorioPedidoProducto) {
        this.repositorioPedidoProducto = repositorioPedidoProducto;
    }

    public Long ejecutar(PedidoProducto pedidoProducto) {
        return this.repositorioPedidoProducto.crearPedidoProducto(pedidoProducto);
    }
}



