package com.ceiba.pedido.servicio.testdatabuilder;

import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.producto.modelo.entidad.Producto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PedidoTestDataBuilder {
    private Long id;
    private String email;
    private String nombresApellidos;
    private LocalDateTime fechaPedido;
    private LocalDate fechaEntrega;
    private String estado;

    public PedidoTestDataBuilder() {
        email = "test@test.com";
        nombresApellidos = "Juan Perez";
        fechaPedido = LocalDateTime.now();
        fechaEntrega = LocalDate.now().minusDays(1);
        estado = "GENERADO";

    }

    public PedidoTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public PedidoTestDataBuilder conFechaEntrega() {
        this.fechaEntrega = LocalDate.now();
        return this;
    }

    public Pedido build() {
        return new Pedido(id,email, nombresApellidos,fechaEntrega, estado);
    }}
