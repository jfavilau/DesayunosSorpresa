package com.ceiba.pedido.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.puerto.repositorio.RepositorioPedido;
import com.ceiba.pedido.servicio.testdatabuilder.PedidoTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;

public class ServicioRealizarPedidoTest {

    @Test
    public void validarFEntregaMenorFPedidoTest() {
        // arrange
        Pedido pedido = new PedidoTestDataBuilder().build();
        RepositorioPedido repositorioPedido = Mockito.mock(RepositorioPedido.class);
        ServicioRealizarPedido servicioRealizarPedido = new ServicioRealizarPedido(repositorioPedido);
        // act - assert
        BasePrueba.assertThrows(() -> servicioRealizarPedido.ejecutar(pedido), ExcepcionValorInvalido.class,"La fecha de entrega debe ser posterior a la fecha actual");
    }

    @Test
    public void validarEntregaMismoDiaTest() {
        // arrange
        Pedido pedido = new PedidoTestDataBuilder().conFechaEntrega().build();
        RepositorioPedido repositorioPedido = Mockito.mock(RepositorioPedido.class);
        ServicioRealizarPedido servicioRealizarPedido = new ServicioRealizarPedido(repositorioPedido);
        // act - assert
        BasePrueba.assertThrows(() -> servicioRealizarPedido.ejecutar(pedido), ExcepcionValorInvalido.class,"No aceptamos pedidos para entrega el mismo día que se hace el pedido, debe realizarlo con al menos un día de anterioridad. "
                + " Fecha sugerida: "+pedido.getFechaPedido().plusDays(1).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }

    @Test
    public void ejecutarTest() {
        // arrange
        Pedido pedido = new PedidoTestDataBuilder().conFechaEntregaMayorDosDias().build();
        RepositorioPedido repositorioPedido = Mockito.mock(RepositorioPedido.class);
        ServicioRealizarPedido servicioRealizarPedido = new ServicioRealizarPedido(repositorioPedido);
        // act - assert
        Long numeroPedido = servicioRealizarPedido.ejecutar(pedido);
        assertEquals("0", numeroPedido.toString());
    }



}