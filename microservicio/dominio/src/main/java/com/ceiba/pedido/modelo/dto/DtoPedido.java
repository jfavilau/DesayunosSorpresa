package com.ceiba.pedido.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoPedido {
    private Long id;
    private String email;
    private String nombresApellidos;
    private String envia;
    private String recibe;
    private String direccion;
    private String barrio;
    private String celular;
    private String mensaje;
    private Double total;
    private LocalDateTime fechaPedido;
    private LocalDate fechaEntrega;
    private String estado;
}
