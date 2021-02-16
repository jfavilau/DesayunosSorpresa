package com.ceiba.pedido.modelo.dto;

import com.ceiba.producto.modelo.dto.DtoProducto;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DtoPedidoTest {

    @Test
    public void dtoPedidoTest() {
        DtoPedido dtoPedido = new DtoPedido(2L, "test@test.com", "Jhon Avila","Juan Perez", "Andrea Alsina","Carrera 43 # 24-56", "Robledo", "3154679807", "Esto es un evío de prueba", 152900.00, LocalDateTime.now(), LocalDate.now(), "Generado");

// act - assert
        Assertions.assertEquals(new Long(2L), dtoPedido.getId());
        Assertions.assertEquals("test@test.com", dtoPedido.getEmail());
        Assertions.assertEquals("Jhon Avila", dtoPedido.getNombresApellidos());
        Assertions.assertEquals(LocalDate.now(), dtoPedido.getFechaEntrega());
        Assertions.assertEquals("Generado", dtoPedido.getEstado());
        Assertions.assertEquals("Juan Perez", dtoPedido.getDe());
        Assertions.assertEquals("Andrea Alsina", dtoPedido.getPara());
        Assertions.assertEquals("Carrera 43 # 24-56", dtoPedido.getDireccion());
        Assertions.assertEquals("Robledo", dtoPedido.getBarrio());
        Assertions.assertEquals("3154679807", dtoPedido.getCelular());
        Assertions.assertEquals("Esto es un evío de prueba", dtoPedido.getMensaje());
        Assertions.assertEquals(new Double(152900.00), dtoPedido.getPrecio());


    }
}