package com.ceiba.pedido.modelo.entidad;

import com.ceiba.pedido.servicio.testdatabuilder.PedidoTestDataBuilder;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PedidoTest {

    @Test
    public void productoTest() {
        Pedido pedido = new PedidoTestDataBuilder().build();

        // act - assert
        Assertions.assertEquals(null, pedido.getId());
        Assertions.assertEquals("test@test.com", pedido.getEmail());
        Assertions.assertEquals("Juan Perez", pedido.getNombresApellidos());
        Assertions.assertEquals(LocalDate.now().minusDays(1), pedido.getFechaEntrega());
        Assertions.assertTrue(LocalDateTime.now().plusDays(1).isAfter(pedido.getFechaPedido()));
        Assertions.assertEquals("Juan Perez", pedido.getDe());
        Assertions.assertEquals("Andrea Alsina", pedido.getPara());
        Assertions.assertEquals("Carrera 43 # 24-56", pedido.getDireccion());
        Assertions.assertEquals("Robledo", pedido.getBarrio());
        Assertions.assertEquals("3154679807", pedido.getCelular());
        Assertions.assertEquals("Esto es un evío de prueba", pedido.getMensaje());
        Assertions.assertEquals(new Double(158900.00), pedido.getPrecio());
        Assertions.assertEquals("GENERADO", pedido.getEstado());
    }
}