package com.ceiba.producto.modelo.entidad;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class ProductoTest {

    @Test
    public void productoTest() {
        // arrange
        Producto producto = new Producto(1L, "test", "test", "test", 120000.00);

        // act - assert
        Assertions.assertEquals(new Long(1L), producto.getId());
        Assertions.assertEquals("test", producto.getNombre());
        Assertions.assertEquals("test", producto.getDescripcion());
        Assertions.assertEquals("test", producto.getImagen());
        Assertions.assertEquals(new Double(120000.00), producto.getPrecio());
    }

}