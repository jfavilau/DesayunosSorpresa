package com.ceiba.pedido.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoPedido {

    private Long id;
    private String email;
    private String nombresApellidos;
    private LocalDateTime fechaPedido;
    private LocalDate fechaEntrega;
    private String estado;
}
