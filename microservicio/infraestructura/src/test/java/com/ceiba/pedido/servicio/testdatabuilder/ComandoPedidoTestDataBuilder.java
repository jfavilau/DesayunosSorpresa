package com.ceiba.pedido.servicio.testdatabuilder;

import com.ceiba.pedido.comando.ComandoPedido;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ComandoPedidoTestDataBuilder {

    private Long id;
    private String email;
    private String nombresApellidos;
    private LocalDateTime fechaPedido;
    private LocalDate fechaEntrega;
    private String estado;

    public ComandoPedidoTestDataBuilder() {
        email = "test@test";
        nombresApellidos = "1234";
        fechaPedido = LocalDateTime.now();
        fechaEntrega = LocalDate.now().plusDays(2);
        estado = "GENERADO";
    }

    public ComandoPedidoTestDataBuilder conEmail(String nombre) {
        this.email = nombre;
        return this;
    }

    public ComandoPedido build() {
        return new ComandoPedido(id,email, nombresApellidos,fechaPedido, fechaEntrega, estado);
    }
}
