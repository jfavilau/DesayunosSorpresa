package com.ceiba.pedido.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.pedido.modelo.dto.DtoPedido;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class MapeoPedido implements RowMapper<DtoPedido>, MapperResult {

    @Override
    public DtoPedido mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String emailContacto = resultSet.getString("email");
        String nombresApellidos = resultSet.getString("nombres_apellidos");
        String envia = resultSet.getString("envia");
        String recibe = resultSet.getString("recibe");
        String direccion = resultSet.getString("direccion");
        String barrio = resultSet.getString("barrio");
        String celular = resultSet.getString("celular");
        String mensaje = resultSet.getString("mensaje");
        Double total = resultSet.getDouble("total");
        LocalDateTime fechaPedido = resultSet.getTimestamp("fecha_pedido").toLocalDateTime();
        LocalDate fechaEntrega = resultSet.getTimestamp("fecha_entrega").toLocalDateTime().toLocalDate();
        String estado = resultSet.getString("estado");

        return new DtoPedido(id, emailContacto, nombresApellidos,envia,recibe,direccion,barrio,celular,mensaje,total,fechaPedido, fechaEntrega, estado);
    }

}
