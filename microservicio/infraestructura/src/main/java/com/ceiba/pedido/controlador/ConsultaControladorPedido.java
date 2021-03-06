package com.ceiba.pedido.controlador;

import com.ceiba.pedido.consulta.ManejadorListarPedidos;
import com.ceiba.pedido.modelo.dto.DtoPedido;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pedidos/listar")
@Api(tags={"Controlador consulta producto"})
public class ConsultaControladorPedido {

    private final ManejadorListarPedidos manejadorListarPedidos;

    public ConsultaControladorPedido(ManejadorListarPedidos manejadorListarPedidos) {
        this.manejadorListarPedidos = manejadorListarPedidos;
    }

    @GetMapping
    @ApiOperation("Listar Pedidos")
    public List<DtoPedido> listar() {
        return this.manejadorListarPedidos.ejecutar();
    }

}