package com.ceiba.pedido.puerto.repositorio;

import java.time.LocalDate;

public interface IRepositorioFestivosColombia {
    boolean validarDiaFestivo(LocalDate fechaEntrega);
}
