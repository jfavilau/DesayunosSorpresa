package com.ceiba.producto.modelo.dto;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class DtoProductoTest {

    @Test
    public void dtoProductoTest() {
        DtoProducto dtoProducto = new DtoProducto(1L, "test", "test", "test", 120000.00, 1);

        // act - assert
        Assertions.assertEquals(new Long(1L), dtoProducto.getId());
        Assertions.assertEquals("test", dtoProducto.getNombre());
        Assertions.assertEquals("test", dtoProducto.getDescripcion());
        Assertions.assertEquals("test", dtoProducto.getImagen());
        Assertions.assertEquals(new Double(120000.00), dtoProducto.getPrecio());
        Assertions.assertEquals(1, dtoProducto.getCantidad());
    }

}