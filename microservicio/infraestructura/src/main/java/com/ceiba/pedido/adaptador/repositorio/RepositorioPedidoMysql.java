package com.ceiba.pedido.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.puerto.repositorio.RepositorioPedido;
import org.springframework.stereotype.Repository;

@Repository
public class  RepositorioPedidoMysql implements RepositorioPedido {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="pedido", value="realizarPedido")
    private static String sqlRealizarPedido;

    @SqlStatement(namespace="pedido", value="cambiarEstadoPedido")
    private static String sqlActualizarPedido;

    public RepositorioPedidoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long realizarPedido(Pedido pedido) {
        return this.customNamedParameterJdbcTemplate.crear(pedido, sqlRealizarPedido);
    }


    @Override
    public void cambiarEstadoPedido(Pedido pedido) {
        this.customNamedParameterJdbcTemplate.actualizar(pedido, sqlActualizarPedido);
    }

}

