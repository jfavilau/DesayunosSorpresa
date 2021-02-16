package com.ceiba.pedido.comando;

import com.ceiba.producto.modelo.entidad.Producto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoPedido {

    private Long id;
    private String email;
    private String nombresApellidos;
    private List<Producto> producto;
    private String envia;
    private String recibe;
    private String direccion;
    private String barrio;
    private String celular;
    private String mensaje;
    private Double zona;
    private LocalDate fechaEntrega;
}
