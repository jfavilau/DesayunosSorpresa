package com.ceiba.pedido.servicio.testdatabuilder;

import com.ceiba.pedido.modelo.entidad.Pedido;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PedidoTestDataBuilder {
    private Long id;
    private String email;
    private String nombresApellidos;
    private String de;
    private String para;
    private String direccion;
    private String barrio;
    private String celular;
    private String mensaje;
    private Double precio;
    private LocalDateTime fechaPedido;
    private LocalDate fechaEntrega;
    private String estado;

    public PedidoTestDataBuilder() {
        email = "test@test.com";
        nombresApellidos = "Juan Perez";
        fechaPedido = LocalDateTime.now();
        fechaEntrega = LocalDate.now().minusDays(1);
        de = "Juan Perez";
        para = "Andrea Alsina";
        direccion = "Carrera 43 # 24-56";
        barrio = "Robledo";
        celular = "3154679807";
        mensaje = "Esto es un evío de prueba";
        precio = 158900.00;
        estado = "GENERADO";

    }

    public PedidoTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public PedidoTestDataBuilder conFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
        return this;
    }

    public PedidoTestDataBuilder conFechaEntregaId(LocalDate fechaEntrega, Long id) {
        this.id = id;
        this.fechaEntrega = fechaEntrega;
        return this;
    }

    public Pedido build() {
        return new Pedido(id,email, nombresApellidos,de,para,direccion,barrio,celular,mensaje,precio,fechaEntrega,estado);
    }}
