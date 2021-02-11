package com.ceiba.pedido.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@AllArgsConstructor
public class DtoPedido {
    private Long id;
    private String email;
    private String nombresApellidos;
    private LocalDateTime fechaPedido;
    private LocalDate fechaEntrega;
    private String estado;
}
