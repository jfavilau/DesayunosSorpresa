package com.ceiba.pedidoProductos.puerto.dao;

import com.ceiba.pedidoProductos.modelo.dto.DtoPedidoProducto;


import java.util.List;

public interface DaoPedidoProducto {

    /**
     * Permite listar usuarios
     * @return los usuarios
     */
    List<DtoPedidoProducto> listar();
}
