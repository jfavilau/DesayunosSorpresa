package com.ceiba.pedido.servicio;

import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.puerto.repositorio.RepositorioPedido;
import com.ceiba.pedido.servicio.testdatabuilder.PedidoTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

public class ServicioCambiarEstadoPedidoTest {
    @Test
    public void ejecutarTest() {
        // arrange
        Pedido pedido = new PedidoTestDataBuilder().conFechaEntregaId(LocalDate.now().plusDays(2), 2L).build();
        RepositorioPedido repositorioPedido = Mockito.mock(RepositorioPedido.class);
        ServicioCambiarEstadoPedido servicioCambiarEstadoPedido = new ServicioCambiarEstadoPedido(repositorioPedido);
        // act - assert
        servicioCambiarEstadoPedido.ejecutar(pedido);
    }



}