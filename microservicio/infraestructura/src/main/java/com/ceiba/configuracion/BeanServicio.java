package com.ceiba.configuracion;

import com.ceiba.pedido.puerto.repositorio.RepositorioPedido;
import com.ceiba.pedido.servicio.ServicioCambiarEstadoPedido;
import com.ceiba.pedido.servicio.ServicioRealizarPedido;
import com.ceiba.pedidoProductos.puerto.repositorio.RepositorioPedidoProducto;
import com.ceiba.pedidoProductos.servicio.ServicioCrearPedidoProducto;
import com.ceiba.producto.puerto.repositorio.RepositorioProducto;
import com.ceiba.producto.servicio.ServicioActualizarProducto;
import com.ceiba.producto.servicio.ServicioCrearProducto;
import com.ceiba.producto.servicio.ServicioEliminarProducto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearProducto servicioCrearProducto(RepositorioProducto repositorioProducto) {
        return new ServicioCrearProducto(repositorioProducto);
    }

    @Bean
    public ServicioEliminarProducto servicioEliminarProducto(RepositorioProducto repositorioProducto) {
        return new ServicioEliminarProducto(repositorioProducto);
    }

    @Bean
    public ServicioActualizarProducto servicioActualizarProducto(RepositorioProducto repositorioProducto) {
        return new ServicioActualizarProducto(repositorioProducto);
    }

    @Bean
    public ServicioRealizarPedido servicioRealizarPedido(RepositorioPedido repositorioPedido) {
        return new ServicioRealizarPedido(repositorioPedido);
    }

    @Bean
    public ServicioCambiarEstadoPedido servicioCambiarEstadoPedido(RepositorioPedido repositorioPedido) {
        return new ServicioCambiarEstadoPedido(repositorioPedido);
    }
    @Bean
    public ServicioCrearPedidoProducto servicioCrearPedidoProducto(RepositorioPedidoProducto repositorioPedidoProducto) {
        return new ServicioCrearPedidoProducto(repositorioPedidoProducto);
    }

}
