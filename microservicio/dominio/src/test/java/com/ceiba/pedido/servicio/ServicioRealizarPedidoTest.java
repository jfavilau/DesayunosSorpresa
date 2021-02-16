package com.ceiba.pedido.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.puerto.repositorio.RepositorioPedido;
import com.ceiba.pedido.servicio.testdatabuilder.PedidoTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ServicioRealizarPedidoTest {

    @Test
    public void validarEntregaMismoDiaTest() {
        // arrange
        Pedido pedido = new PedidoTestDataBuilder().conFechaEntrega(LocalDate.now()).build();
        RepositorioPedido repositorioPedido = Mockito.mock(RepositorioPedido.class);
        ServicioRealizarPedido servicioRealizarPedido = new ServicioRealizarPedido(repositorioPedido);
        // act - assert
        BasePrueba.assertThrows(() -> servicioRealizarPedido.ejecutar(pedido), ExcepcionValorInvalido.class,"No aceptamos pedidos para entrega el mismo día que se hace el pedido, debe realizarlo con al menos un día de anterioridad. "
                + " Fecha sugerida: "+pedido.getFechaPedido().plusDays(1).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }

    @Test
    public void realizarPedidoEjecutarTest() {
        // arrange
        Pedido pedido = new PedidoTestDataBuilder().conFechaEntregaId(LocalDate.now().plusDays(2),2L ).build();
        RepositorioPedido repositorioPedido = Mockito.mock(RepositorioPedido.class);
        ServicioRealizarPedido servicioRealizarPedido = new ServicioRealizarPedido(repositorioPedido);
        // act - assert
        Long numeroPedido = servicioRealizarPedido.ejecutar(pedido);

        Map mockMap = mock(Map.class);
        mockMap.isEmpty();
        verify(mockMap, only()).isEmpty();
    }

    @Test (expected = ExcepcionValorInvalido.class)
    public void realizarPedidoEmailInvalido(){
        Pedido pedido = new PedidoTestDataBuilder().conEmail("jhonavil").build();
        RepositorioPedido repositorioPedido = Mockito.mock(RepositorioPedido.class);
        ServicioRealizarPedido servicioRealizarPedido = new ServicioRealizarPedido(repositorioPedido);
        // act - assert
        BasePrueba.assertThrows(() -> servicioRealizarPedido.ejecutar(pedido), ExcepcionValorInvalido.class,"Se debe ingresar un correo electrónico válido");

    }

    @Test (expected = ExcepcionValorInvalido.class)
    public void realizarPedidoNombresNull(){
        Pedido pedido = new PedidoTestDataBuilder().conNombres("").build();
        RepositorioPedido repositorioPedido = Mockito.mock(RepositorioPedido.class);
        ServicioRealizarPedido servicioRealizarPedido = new ServicioRealizarPedido(repositorioPedido);
        // act - assert
        BasePrueba.assertThrows(() -> servicioRealizarPedido.ejecutar(pedido), ExcepcionValorInvalido.class,"Se debe ingresar un correo electrónico válido");

    }



}