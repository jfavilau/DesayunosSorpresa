package com.ceiba.pedido.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.pedido.modelo.dto.DtoPedido;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class MapeoPedido implements RowMapper<DtoPedido>, MapperResult {

    @Override
    public DtoPedido mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String emailContacto = resultSet.getString("email");
        String nombresApellidos = resultSet.getString("nombres_apellidos");
        LocalDateTime fechaPedido = resultSet.getTimestamp("fecha_pedido").toLocalDateTime();
        Date fechaEntrega = resultSet.getDate("fecha_entrega");
        String estado = resultSet.getString("estado");

        return new DtoPedido(id, emailContacto, nombresApellidos, fechaPedido, fechaEntrega, estado);
    }

}
