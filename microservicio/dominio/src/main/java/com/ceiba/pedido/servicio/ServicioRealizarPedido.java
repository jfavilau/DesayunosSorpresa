package com.ceiba.pedido.servicio;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.puerto.repositorio.RepositorioPedido;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ServicioRealizarPedido {

    private static final String FECHA_DE_ENTREGA_ANTES_FECHA_PEDIDO = "La fecha de entrega debe ser posterior a la fecha actual";
    private static final String FECHA_DE_ENTREGA_MISMO_DIA_DEL_PEDIDO = "No aceptamos pedidos para entrega el mismo día que se hace el pedido, debe realizarlo con al menos un día de anterioridad. ";

    private final RepositorioPedido repositorioPedido;

    public ServicioRealizarPedido(RepositorioPedido repositorioPedido) {
        this.repositorioPedido = repositorioPedido;
    }

    public Long ejecutar(Pedido pedido) {
        LocalDateTime fechaPedido = pedido.getFechaPedido();
        LocalDate fechaEntrega = pedido.getFechaEntrega();

        validarFEntregaMenorFPedido(fechaPedido, fechaEntrega);
        validarEntregaMismoDia(fechaPedido, fechaEntrega);
        return this.repositorioPedido.realizarPedido(pedido);
    }

    private void validarFEntregaMenorFPedido(LocalDateTime fechaPedido, LocalDate fechaEntrega) {
        boolean fechaEntregaDespuesPedido = fechaEntrega.isAfter(fechaPedido.toLocalDate()) || fechaEntrega.isEqual(fechaPedido.toLocalDate());

        if (!fechaEntregaDespuesPedido){
            throw new ExcepcionValorInvalido(FECHA_DE_ENTREGA_ANTES_FECHA_PEDIDO);
        }
    }
    private void validarEntregaMismoDia(LocalDateTime fechaPedido, LocalDate fechaEntrega) {

        boolean fechaMismoDia = fechaEntrega.isEqual(fechaPedido.toLocalDate());
        LocalDate fechaEntregaSugerida = fechaPedido.plusDays(1).toLocalDate();

        if (fechaMismoDia){
            throw new ExcepcionValorInvalido(FECHA_DE_ENTREGA_MISMO_DIA_DEL_PEDIDO +" Fecha sugerida: "+fechaEntregaSugerida.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        }
    }

}
