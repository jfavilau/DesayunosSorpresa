package com.ceiba.pedido.comando.fabrica;

import com.ceiba.pedido.comando.ComandoPedido;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.producto.modelo.dto.DtoProductoCantidad;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FabricaPedido {

    public Pedido crear(ComandoPedido comandoPedido, List<DtoProductoCantidad> productos){
        return new Pedido(
                comandoPedido.getId(),
                comandoPedido.getEmail(),
                comandoPedido.getNombresApellidos(),
                productos,
                comandoPedido.getEnvia(),
                comandoPedido.getRecibe(),
                comandoPedido.getDireccion(),
                comandoPedido.getBarrio(),
                comandoPedido.getCelular(),
                comandoPedido.getMensaje(),
                comandoPedido.getZona(),
                comandoPedido.getFechaEntrega()
        );
    }
}
