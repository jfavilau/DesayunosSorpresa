package com.ceiba.pedidoproducto.puerto.dao;

import com.ceiba.pedidoproducto.modelo.dto.DtoPedidoProducto;

import java.util.List;

public interface DaoPedidoProducto {

    /**
     * Permite listar usuarios
     * @return los usuarios
     */
    List<DtoPedidoProducto> listar();
}
