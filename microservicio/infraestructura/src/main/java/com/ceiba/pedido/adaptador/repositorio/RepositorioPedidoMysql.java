package com.ceiba.pedido.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.puerto.repositorio.RepositorioPedido;
import com.ceiba.pedidoproducto.modelo.entidad.PedidoProducto;
import com.ceiba.producto.modelo.dto.DtoProductoCantidad;
import org.springframework.stereotype.Repository;

@Repository
public class  RepositorioPedidoMysql implements RepositorioPedido {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="pedido", value="realizarPedido")
    private static String sqlRealizarPedido;

    @SqlStatement(namespace="pedido", value="cambiarEstadoPedido")
    private static String sqlActualizarPedido;

    @SqlStatement(namespace="pedido_producto", value="crear")
    private static String sqlCrearPedidoProducto;

    public RepositorioPedidoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crearPedido(Pedido pedido) {

        Long pedidoId = this.customNamedParameterJdbcTemplate.crear(pedido, sqlRealizarPedido);
        for (DtoProductoCantidad item: pedido.getProducto()){
            PedidoProducto pedidoProducto = new PedidoProducto(pedidoId,item.getProducto().getId(), item.getCantidad());
            this.customNamedParameterJdbcTemplate.crear(pedidoProducto, sqlCrearPedidoProducto);
        }
        return pedidoId;
    }


    @Override
    public void cambiarEstadoPedido(Pedido pedido) {
        this.customNamedParameterJdbcTemplate.actualizar(pedido, sqlActualizarPedido);
    }

}

