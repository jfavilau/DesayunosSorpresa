package com.ceiba.pedido.modelo.entidad;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
public class Pedido {

    private Long id;
    private String email;
    private String nombresApellidos;
    private LocalDateTime fechaPedido;
    private Date fechaEntrega;
    private String estado;

    public Pedido(Long id, String email, String nombresApellidos, Date fechaEntrega, String estado) {
        this.id = id;
        this.email = email;
        this.nombresApellidos = nombresApellidos;
        this.fechaPedido = LocalDateTime.now();
        this.fechaEntrega = fechaEntrega;
        this.estado = estado;
    }
}
