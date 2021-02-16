package com.ceiba.pedido.comando.fabrica;

import com.ceiba.pedido.comando.ComandoPedido;
import com.ceiba.pedido.modelo.entidad.Pedido;
import org.springframework.stereotype.Component;

@Component
public class FabricaPedido {

    public Pedido crear(ComandoPedido comandoPedido){
        return new Pedido(
                comandoPedido.getId(),
                comandoPedido.getEmail(),
                comandoPedido.getNombresApellidos(),
                comandoPedido.getProducto(),
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
