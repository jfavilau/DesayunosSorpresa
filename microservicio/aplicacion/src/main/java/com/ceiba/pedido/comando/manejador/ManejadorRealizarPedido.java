package com.ceiba.pedido.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.pedido.comando.ComandoPedido;
import com.ceiba.pedido.comando.fabrica.FabricaPedido;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.servicio.ServicioRealizarPedido;
import com.ceiba.pedidoproducto.comando.fabrica.FabricaPedidoProducto;
import com.ceiba.producto.modelo.dto.DtoProductoCantidad;
import com.ceiba.producto.modelo.dto.DtoProductoIdCantidad;
import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.puerto.repositorio.RepositorioProducto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ManejadorRealizarPedido implements ManejadorComandoRespuesta<ComandoPedido, ComandoRespuesta<Long>> {

    private final FabricaPedido fabricaPedido;
    private final ServicioRealizarPedido servicioRealizarPedido;
    private final RepositorioProducto repositorioProducto;

    public ManejadorRealizarPedido(FabricaPedido fabricaPedido, ServicioRealizarPedido servicioRealizarPedido,
                                   FabricaPedidoProducto fabricaPedidoProducto,
                                   RepositorioProducto repositorioProducto) {
        this.fabricaPedido = fabricaPedido;
        this.servicioRealizarPedido = servicioRealizarPedido;
        this.repositorioProducto = repositorioProducto;

    }

    public ComandoRespuesta<Long> ejecutar(ComandoPedido comandoPedido) {
        List<DtoProductoCantidad> listaProductosCantidad = new ArrayList<>();
        for (DtoProductoIdCantidad item : comandoPedido.getProducto()){
            Producto productoObtenido = this.repositorioProducto.buscarProductoPorId(item.getId());
            DtoProductoCantidad productoCantidad = new DtoProductoCantidad(productoObtenido, item.getCantidad());
            listaProductosCantidad.add(productoCantidad);
        }
        Pedido pedido = this.fabricaPedido.crear(comandoPedido, listaProductosCantidad);

        return new ComandoRespuesta<>(this.servicioRealizarPedido.ejecutar(pedido));
    }
}
