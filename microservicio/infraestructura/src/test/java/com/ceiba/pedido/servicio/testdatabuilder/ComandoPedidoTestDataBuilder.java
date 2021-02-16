package com.ceiba.pedido.servicio.testdatabuilder;

import com.ceiba.pedido.comando.ComandoPedido;
import com.ceiba.pedido.modelo.entidad.Pedido;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ComandoPedidoTestDataBuilder {

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

    public ComandoPedidoTestDataBuilder() {
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

    public ComandoPedidoTestDataBuilder conEmail(String nombre) {
        this.email = nombre;
        return this;
    }

    public ComandoPedido build() {
        return new ComandoPedido(id,email,nombresApellidos,de,para,direccion,barrio,celular,mensaje,precio,fechaPedido,fechaEntrega,estado);
    }
}
