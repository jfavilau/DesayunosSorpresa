package com.ceiba.pedido.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.pedido.comando.ComandoPedido;
import com.ceiba.pedido.comando.fabrica.FabricaPedido;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.servicio.ServicioCambiarEstadoPedido;
import com.ceiba.producto.modelo.dto.DtoProducto;
import com.ceiba.producto.modelo.dto.DtoProductoCantidad;
import com.ceiba.producto.modelo.dto.DtoProductoIdCantidad;
import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.puerto.repositorio.RepositorioProducto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ManejadorCambiarEstadoPedido implements ManejadorComando<ComandoPedido> {

    private final FabricaPedido fabricaPedido;
    private final ServicioCambiarEstadoPedido servicioCambiarEstadoPedido;
    private final RepositorioProducto repositorioProducto;

    public ManejadorCambiarEstadoPedido(FabricaPedido fabricaPedido, ServicioCambiarEstadoPedido servicioCambiarEstadoPedido,
                                        RepositorioProducto repositorioProducto) {
        this.fabricaPedido = fabricaPedido;
        this.servicioCambiarEstadoPedido = servicioCambiarEstadoPedido;
        this.repositorioProducto = repositorioProducto;
    }

    public void ejecutar(ComandoPedido comandoPedido) {
        List<DtoProductoCantidad> listaProductosCantidad = new ArrayList<>();
        for (DtoProductoIdCantidad item : comandoPedido.getProducto()){
            Producto productoObtenido = this.repositorioProducto.buscarProductoPorId(item.getId());
            DtoProductoCantidad productoCantidad = new DtoProductoCantidad(productoObtenido, item.getCantidad());
            listaProductosCantidad.add(productoCantidad);
        }
        Pedido pedido = this.fabricaPedido.crear(comandoPedido, listaProductosCantidad);
        this.servicioCambiarEstadoPedido.ejecutar(pedido);
    }
}
