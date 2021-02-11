package com.ceiba.pedido.modelo.entidad;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PedidoTest {

    @Test
    public void productoTest() {
        Pedido pedido = new Pedido(2L, "test@test.com", "Jhon Avila", LocalDate.now(), "Generado");

        // act - assert
        Assertions.assertEquals(new Long(2L), pedido.getId());
        Assertions.assertEquals("test@test.com", pedido.getEmail());
        Assertions.assertEquals("Jhon Avila", pedido.getNombresApellidos());
        Assertions.assertEquals(LocalDate.now(), pedido.getFechaEntrega());
        Assertions.assertTrue(LocalDateTime.now().isAfter(pedido.getFechaPedido()));
        Assertions.assertEquals("Generado", pedido.getEstado());
    }
}