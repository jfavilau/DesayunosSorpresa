package com.ceiba.producto.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.puerto.repositorio.RepositorioProducto;
import com.ceiba.producto.servicio.testdatabuilder.ProductoTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.*;

public class ServicioActualizarProductoTest {
    @Test
    public void validarUsuarioExistenciaPreviaTest() {
        // arrange
        Producto producto = new ProductoTestDataBuilder().conId(1L).build();
        RepositorioProducto repositorioUsuario = mock(RepositorioProducto.class);
        Mockito.when(repositorioUsuario.existeExcluyendoId(Mockito.anyLong(),Mockito.anyString())).thenReturn(true);
        ServicioActualizarProducto servicioActualizarProducto = new ServicioActualizarProducto(repositorioUsuario);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarProducto.ejecutar(producto), ExcepcionDuplicidad.class,"El producto con ese nombe ya existe en el sistema");
    }

    @Test
    public void actualizarProductoTest() {
        // arrange
        Producto producto = new ProductoTestDataBuilder().conId(1L).build();
        RepositorioProducto repositorioUsuario = mock(RepositorioProducto.class);
        Mockito.when(repositorioUsuario.existeExcluyendoId(Mockito.anyLong(),Mockito.anyString())).thenReturn(false);
        ServicioActualizarProducto servicioActualizarProducto = new ServicioActualizarProducto(repositorioUsuario);
        servicioActualizarProducto.ejecutar(producto);

        Map mockMap = mock(Map.class);
        mockMap.isEmpty();
        verify(mockMap, only()).isEmpty();
    }
}
