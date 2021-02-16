package com.ceiba.dominio.excepcion;

public class ExcepcionConsumoApi extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionConsumoApi(String mensaje) {
        super(mensaje);
    }
}
