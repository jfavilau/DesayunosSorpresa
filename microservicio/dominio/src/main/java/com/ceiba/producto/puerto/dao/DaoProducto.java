package com.ceiba.producto.puerto.dao;

import com.ceiba.producto.modelo.dto.DtoProducto;

import java.util.List;

public interface DaoProducto {

    /**
     * Permite listar usuarios
     * @return los usuarios
     */
    List<DtoProducto> listar();
}
