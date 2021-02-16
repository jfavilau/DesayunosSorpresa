package com.ceiba.pedido.modelo.entidad;

import com.ceiba.pedido.servicio.testdatabuilder.PedidoTestDataBuilder;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PedidoTest {

    @Test
    public void productoTest() {
        Pedido pedido = new PedidoTestDataBuilder().conFechaEntrega(LocalDate.now().plusDays(2)).build();

        // act - assert
        Assertions.assertEquals(null, pedido.getId());
        Assertions.assertEquals("test@test.com", pedido.getEmail());
        Assertions.assertEquals("Juan Perez", pedido.getNombresApellidos());
        Assertions.assertEquals(new Long(1L), pedido.getProducto().get(0).getId());
        Assertions.assertEquals(LocalDate.now().plusDays(2), pedido.getFechaEntrega());
        Assertions.assertTrue(LocalDateTime.now().plusDays(1).isAfter(pedido.getFechaPedido()));
        Assertions.assertEquals("Juan Perez", pedido.getEnvia());
        Assertions.assertEquals("Andrea Alsina", pedido.getRecibe());
        Assertions.assertEquals("Carrera 43 # 24-56", pedido.getDireccion());
        Assertions.assertEquals("Robledo", pedido.getBarrio());
        Assertions.assertEquals("3154679807", pedido.getCelular());
        Assertions.assertEquals("Esto es un evío de prueba", pedido.getMensaje());
        Assertions.assertEquals(new Double(10000.00), pedido.getDomicilioZona());
        Assertions.assertEquals(new Double(0.0), pedido.getTotal());
        Assertions.assertEquals("GENERADO", pedido.getEstado());
    }

    @Test
    public void calcularSubTotalTest() {
        Pedido pedido = new PedidoTestDataBuilder().conFechaEntrega(LocalDate.now().plusDays(2)).build();
        pedido.calcularSubTotal();

        // act - assert
        Assertions.assertEquals(new Double(152000.0), pedido.getSubtotalProductos());
    }
}