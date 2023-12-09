package com.tienda.service;

import com.tienda_v2.domain.Producto;
import java.util.List;

public interface ProductoService {

    // Se obtiene un listado de categorias en un List
    public List<Producto> getProductos(boolean activos);

    // Se obtiene un Producto, a partir del id de un categoria
    public Producto getProducto(Producto categoria);

    // Se inserta un nuevo categoria si el id del categoria esta vacÃ­o
    // Se actualiza un categoria si el id del categoria NO esta vacÃ­o
    public void save(Producto categoria);

    // Se elimina el categoria que tiene el id pasado por parÃ¡metro
    public void delete(Producto categoria);

    public List<Producto> getByPrecio(double precioInf, double precioSup);

    //Lista de productos utilizando consultas con JPQL    
    public List<Producto> metodoJPQL(double precioInf, double precioSup);

    //Lista de productos utilizando consultas con SQL Nativo
    public List<Producto> consultaNativo(double precioInf, double precioSup);

}
