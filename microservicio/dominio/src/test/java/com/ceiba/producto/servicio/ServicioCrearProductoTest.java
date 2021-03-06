package com.ceiba.producto.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.puerto.repositorio.RepositorioProducto;
import com.ceiba.producto.servicio.testdatabuilder.ProductoTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

import org.junit.jupiter.api.Assertions;

public class ServicioCrearProductoTest {

    @Test
    public void validarUsuarioExistenciaPreviaTest() {
        // arrange
        Producto producto = new ProductoTestDataBuilder().build();
        RepositorioProducto repositorioProducto = Mockito.mock(RepositorioProducto.class);
        Mockito.when(repositorioProducto.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearProducto servicioCrearProducto = new ServicioCrearProducto(repositorioProducto);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearProducto.ejecutar(producto), ExcepcionDuplicidad.class,"El producto con ese nombe ya existe en el sistema");
    }

    @Test
    public void crearProductoTest() {
        // arrange
        Producto producto = new ProductoTestDataBuilder().conId(3L).build();
        RepositorioProducto repositorioProducto = Mockito.mock(RepositorioProducto.class);
        Mockito.when(repositorioProducto.existe(Mockito.anyString())).thenReturn(false);
        ServicioCrearProducto servicioCrearProducto = new ServicioCrearProducto(repositorioProducto);
        servicioCrearProducto.ejecutar(producto);
        // act - assert
    }

    @Test
    public void crearProductoConDescripcionTest() {
        // arrange
        Producto producto = new ProductoTestDataBuilder().conDescripcion("Esto es una prueba").build();
        RepositorioProducto repositorioProducto = Mockito.mock(RepositorioProducto.class);
        Mockito.when(repositorioProducto.existe(Mockito.anyString())).thenReturn(false);
        ServicioCrearProducto servicioCrearProducto = new ServicioCrearProducto(repositorioProducto);
        servicioCrearProducto.ejecutar(producto);
        // act - assert
    }

    @Test(expected = ExcepcionValorObligatorio.class)
    public void crearProductoConNombreNullTest() {
        // arrange
        Producto producto = new ProductoTestDataBuilder().conNombre(null).build();
        RepositorioProducto repositorioProducto = Mockito.mock(RepositorioProducto.class);
        Mockito.when(repositorioProducto.existe(Mockito.anyString())).thenReturn(false);
        ServicioCrearProducto servicioCrearProducto = new ServicioCrearProducto(repositorioProducto);
        servicioCrearProducto.ejecutar(producto);
        // act - assert
    }

    @Test(expected = ExcepcionValorInvalido.class)
    public void crearProductoConPrecioNegativoTest() {
        // arrange
        Producto producto = new ProductoTestDataBuilder().conPrecio(-142000.00).build();
        RepositorioProducto repositorioProducto = Mockito.mock(RepositorioProducto.class);
        Mockito.when(repositorioProducto.existe(Mockito.anyString())).thenReturn(false);
        ServicioCrearProducto servicioCrearProducto = new ServicioCrearProducto(repositorioProducto);
        servicioCrearProducto.ejecutar(producto);
        // act - assert
    }

    @Test(expected = ExcepcionValorObligatorio.class)
    public void crearProductoConPrecioNullTest() {
        // arrange
        Producto producto = new ProductoTestDataBuilder().conPrecio(null).build();
        RepositorioProducto repositorioProducto = Mockito.mock(RepositorioProducto.class);
        Mockito.when(repositorioProducto.existe(Mockito.anyString())).thenReturn(false);
        ServicioCrearProducto servicioCrearProducto = new ServicioCrearProducto(repositorioProducto);
        servicioCrearProducto.ejecutar(producto);
        // act - assert
    }
}

