package com.ceiba.pedido.servicio.testdatabuilder;

import com.ceiba.pedido.comando.ComandoPedido;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.producto.modelo.dto.DtoProductoIdCantidad;
import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.servicio.testdatabuilder.ComandoProductoTestDataBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ComandoPedidoTestDataBuilder {

    private Long id;
    private String email;
    private String nombresApellidos;
    private List<DtoProductoIdCantidad> producto;
    private String envia;
    private String recibe;
    private String direccion;
    private String barrio;
    private String celular;
    private String mensaje;
    private Double zona;
    private LocalDate fechaEntrega;

    public ComandoPedidoTestDataBuilder() {

        List<DtoProductoIdCantidad> listaProductos = new ArrayList<>();
        DtoProductoIdCantidad productoIdCantidad = new DtoProductoIdCantidadTestDataBuilder().build();
        listaProductos.add(productoIdCantidad);
        email = "test@test.com";
        nombresApellidos = "Juan Perez";
        fechaEntrega = LocalDate.now();
        envia = "Juan Perez";
        recibe = "Andrea Alsina";
        direccion = "Carrera 43 # 24-56";
        barrio = "Robledo";
        celular = "3154679807";
        zona = 10000.0;
        mensaje = "Esto es un evío de prueba";
        producto = listaProductos;
    }

    public ComandoPedidoTestDataBuilder conEmail(String nombre) {
        this.email = nombre;
        return this;
    }

    public ComandoPedidoTestDataBuilder conFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
        return this;
    }

    public ComandoPedido build() {
        return new ComandoPedido(id,email,nombresApellidos,producto,envia,recibe,direccion,barrio,celular,mensaje,zona,fechaEntrega);
    }
}
