package com.ceiba.pedido.servicio;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.puerto.repositorio.IRepositorioFestivosColombia;
import com.ceiba.pedido.puerto.repositorio.RepositorioPedido;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ServicioRealizarPedido {

    private static final String FECHA_DE_ENTREGA_MISMO_DIA_DEL_PEDIDO = "No aceptamos pedidos para entrega el mismo día que se hace el pedido, debe realizarlo con al menos un día de anterioridad. ";

    private final RepositorioPedido repositorioPedido;
    private final IRepositorioFestivosColombia repositorioFestivosColombia;

    public ServicioRealizarPedido(RepositorioPedido repositorioPedido, IRepositorioFestivosColombia repositorioFestivosColombia) {
        this.repositorioPedido = repositorioPedido;
        this.repositorioFestivosColombia = repositorioFestivosColombia;
    }

    public Long ejecutar(Pedido pedido) {
        LocalDateTime fechaPedido = pedido.getFechaPedido();
        LocalDate fechaEntrega = pedido.getFechaEntrega();
        boolean esFestivo = this.repositorioFestivosColombia.validarDiaFestivo(fechaEntrega);

        validarEntregaMismoDia(fechaPedido, fechaEntrega);
        pedido.calcularSubTotalProductos();
        pedido.calcularDomicilioTotal(esFestivo);
        pedido.calcularTotal();
        return this.repositorioPedido.crearPedido(pedido);
    }

    private void validarEntregaMismoDia(LocalDateTime fechaPedido, LocalDate fechaEntrega) {

        boolean fechaMismoDia = fechaEntrega.isEqual(fechaPedido.toLocalDate());
        LocalDate fechaEntregaSugerida = fechaPedido.plusDays(1).toLocalDate();

        if (fechaMismoDia){
            throw new ExcepcionValorInvalido(FECHA_DE_ENTREGA_MISMO_DIA_DEL_PEDIDO +" Fecha sugerida: "+fechaEntregaSugerida.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        }
    }





}
