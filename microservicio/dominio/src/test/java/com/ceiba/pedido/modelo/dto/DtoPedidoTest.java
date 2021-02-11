package com.ceiba.pedido.modelo.dto;

import com.ceiba.producto.modelo.dto.DtoProducto;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DtoPedidoTest {

    @Test
    public void dtoPedidoTest() {
        DtoPedido dtoPedido = new DtoPedido(2L, "test@test.com", "Jhon Avila", LocalDateTime.now(), LocalDate.now(), "Generado");

// act - assert
        Assertions.assertEquals(new Long(2L), dtoPedido.getId());
        Assertions.assertEquals("test@test.com", dtoPedido.getEmail());
        Assertions.assertEquals("Jhon Avila", dtoPedido.getNombresApellidos());
        Assertions.assertEquals(LocalDate.now(), dtoPedido.getFechaEntrega());
        Assertions.assertTrue(LocalDateTime.now().isAfter(dtoPedido.getFechaPedido()));
        Assertions.assertEquals("Generado", dtoPedido.getEstado());
    }
}