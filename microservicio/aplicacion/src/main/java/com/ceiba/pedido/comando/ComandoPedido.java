package com.ceiba.pedido.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoPedido {

    private Long id;
    private String email;
    private String nombresApellidos;
    private LocalDate fechaPedido;
    private Date fechaEntrega;
    private String estado;
}
