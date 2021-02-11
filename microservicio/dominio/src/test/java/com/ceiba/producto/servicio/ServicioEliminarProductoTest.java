package com.ceiba.producto.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.puerto.repositorio.RepositorioProducto;
import com.ceiba.producto.servicio.testdatabuilder.ProductoTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioEliminarProductoTest {

    @Test
    public void eliminarProductoTest() {
        // arrange
        Producto producto = new ProductoTestDataBuilder().conId(1L).build();
        RepositorioProducto repositorioProducto = Mockito.mock(RepositorioProducto.class);
        Mockito.when(repositorioProducto.existe(Mockito.anyString())).thenReturn(false);
        ServicioEliminarProducto servicioEliminarProducto = new ServicioEliminarProducto(repositorioProducto);
        servicioEliminarProducto.ejecutar(producto.getId());
        // act - assert
    }
}

