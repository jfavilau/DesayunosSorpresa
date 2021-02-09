package com.ceiba.pedido.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.puerto.repositorio.RepositorioPedido;

public class ServicioRealizarPedido {

    private static final String FECHA_DE_ENTREGA_NO_VALIDA = "La fecha de entrega imgresada no es válida, recuerde hacer el pedido con un día de anterioridad";

    private final RepositorioPedido repositorioPedido;

    public ServicioRealizarPedido(RepositorioPedido repositorioPedido) {
        this.repositorioPedido = repositorioPedido;
    }

    public Long ejecutar(Pedido pedido) {
        validarFechaEntrega(pedido);
        return this.repositorioPedido.realizarPedido(pedido);
    }

    private void validarFechaEntrega(Pedido pedido) {
        boolean fechaValida = true;
        if(!fechaValida) {
            throw new ExcepcionDuplicidad(FECHA_DE_ENTREGA_NO_VALIDA);
        }
    }
}
