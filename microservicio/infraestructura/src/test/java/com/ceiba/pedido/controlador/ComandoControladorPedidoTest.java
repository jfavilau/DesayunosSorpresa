package com.ceiba.pedido.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.pedido.comando.ComandoPedido;
import com.ceiba.pedido.servicio.testdatabuilder.ComandoPedidoTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorPedido.class)
public class ComandoControladorPedidoTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void realizarPedidoDiaFestivoTest() throws Exception{
        // arrange
        ComandoPedido pedido = new ComandoPedidoTestDataBuilder().conFechaEntrega(LocalDate.of(2023,12,25)).build();

        // act - assert
        mocMvc.perform(post("/pedidos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(pedido)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));
    }

    @Test
    public void realizarPedidoFechaErronea() throws Exception{
        // arrange
        ComandoPedido pedido = new ComandoPedidoTestDataBuilder().conFechaEntrega(LocalDate.of(2024,2,9)).build();

        // act - assert
        mocMvc.perform(post("/pedidos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(pedido)))
                .andExpect(status().isInternalServerError())
                .andExpect(content().json("{'nombreExcepcion': \"ExcepcionTecnica\"}"));
    }

    @Test
    public void cambiarEstadoPedidoTest() throws Exception{
        // arrange
        Long id = 2L;
        ComandoPedido pedido = new ComandoPedidoTestDataBuilder().build();

        // act - assert
        mocMvc.perform(put("/pedidos/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(pedido)))
                .andExpect(status().isOk());
    }
}
