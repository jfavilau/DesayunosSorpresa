package com.ceiba.producto.modelo.entidad;

import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.Test;

public class ProductoTest {

    @Test(expected = ExcepcionValorObligatorio.class)
    public void productoTest() {
        // arrange

        Producto producto = new Producto(1L, null, "test", "test",120000.00);
        // act - assert
    }

}