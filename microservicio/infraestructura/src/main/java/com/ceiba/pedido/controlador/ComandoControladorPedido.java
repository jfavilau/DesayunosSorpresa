package com.ceiba.pedido.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.pedido.comando.ComandoPedido;
import com.ceiba.pedido.comando.manejador.ManejadorCambiarEstadoPedido;
import com.ceiba.pedido.comando.manejador.ManejadorRealizarPedido;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
@Api(tags = { "Controlador comando producto"})
public class ComandoControladorPedido {

    private final ManejadorRealizarPedido manejadorRealizarPedido;
    private final ManejadorCambiarEstadoPedido manejadorCambiarEstadoPedido;

    @Autowired
    public ComandoControladorPedido( ManejadorRealizarPedido manejadorRealizarPedido, ManejadorCambiarEstadoPedido manejadorCambiarEstadoPedido) {
        this.manejadorRealizarPedido = manejadorRealizarPedido;
        this.manejadorCambiarEstadoPedido = manejadorCambiarEstadoPedido;
    }

    @PostMapping
    @ApiOperation("Realizar Pedido")
    public ComandoRespuesta<Long> realizarPedido(@RequestBody ComandoPedido comandoPedido) {
        return manejadorRealizarPedido.ejecutar(comandoPedido);
    }


    @PutMapping(value="/{id}")
    @ApiOperation("Actualizar estado del pedido")
    public void actualizarEstadoPedido(@RequestBody ComandoPedido comandoPedido, @PathVariable Long id) {
        comandoPedido.setId(id);
        manejadorCambiarEstadoPedido.ejecutar(comandoPedido);
    }
}