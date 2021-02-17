package com.ceiba.pedido.servicio.testdatabuilder;

import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.producto.modelo.dto.DtoProductoCantidad;
import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.servicio.testdatabuilder.DtoProductoCantidadTestDataBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PedidoTestDataBuilder {
    private Long id;
    private String email;
    private String nombresApellidos;
    private List<DtoProductoCantidad> producto;
    private String envia;
    private String recibe;
    private String direccion;
    private String barrio;
    private String celular;
    private String mensaje;
    private Double domicilioZona;
    private Double total;
    private LocalDateTime fechaPedido;
    private LocalDate fechaEntrega;
    private String estado;

    public PedidoTestDataBuilder() {
        List<DtoProductoCantidad> lista = new ArrayList<>();
        DtoProductoCantidad productoCantidad =  new DtoProductoCantidadTestDataBuilder().build();
        lista.add(productoCantidad);

        email = "test@test.com";
        nombresApellidos = "Juan Perez";
        fechaPedido = LocalDateTime.now();
        fechaEntrega = LocalDate.now().minusDays(1);
        envia = "Juan Perez";
        recibe = "Andrea Alsina";
        direccion = "Carrera 43 # 24-56";
        barrio = "Robledo";
        celular = "3154679807";
        mensaje = "Esto es un evío de prueba";
        domicilioZona = 10000.00;
        total = 0.00;
        estado = "GENERADO";
        producto = lista;

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

    public PedidoTestDataBuilder conEmail(String email) {
        this.email = email;
        return this;
    }

    public PedidoTestDataBuilder conNombres(String email) {
        this.email = email;
        return this;
    }

    public Pedido build() {
        return new Pedido(id,email,nombresApellidos,producto,envia,recibe,direccion,barrio,celular,mensaje,domicilioZona,fechaEntrega);
    }}
