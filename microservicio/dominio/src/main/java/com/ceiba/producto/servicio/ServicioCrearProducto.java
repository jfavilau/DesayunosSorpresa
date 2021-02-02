package com.ceiba.producto.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.puerto.repositorio.RepositorioProducto;


public class ServicioCrearProducto {

    private static final String EL_PRODUCTO_CON_ESE_NOMBRE_YA_EXISTE_EN_EL_SISTEMA = "El producto con ese nombe ya existe en el sistema";

    private final RepositorioProducto repositorioProducto;

    public ServicioCrearProducto(RepositorioProducto repositorioProducto) {
        this.repositorioProducto = repositorioProducto;
    }

    public Long ejecutar(Producto producto) {
        validarExistenciaPrevia(producto);
        return this.repositorioProducto.crear(producto);
    }

    private void validarExistenciaPrevia(Producto producto) {
        boolean existe = this.repositorioProducto.existe(producto.getNombre());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_PRODUCTO_CON_ESE_NOMBRE_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
