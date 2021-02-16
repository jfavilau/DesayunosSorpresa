package com.ceiba.pedidoProducto.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.pedidoproducto.modelo.entidad.PedidoProducto;
import com.ceiba.pedidoproducto.puerto.repositorio.RepositorioPedidoProducto;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioPedidoProductoMysql implements RepositorioPedidoProducto {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="pedido_producto", value="crear")
    private static String sqlCrearPedidoProducto;

    public RepositorioPedidoProductoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crearPedidoProducto(PedidoProducto pedidoProducto) {
        return this.customNamedParameterJdbcTemplate.crear(pedidoProducto, sqlCrearPedidoProducto);
    }

}

