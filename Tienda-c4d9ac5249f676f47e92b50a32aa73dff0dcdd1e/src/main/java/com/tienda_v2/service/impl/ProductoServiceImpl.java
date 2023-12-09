package com.tienda_v2.service.impl;

import com.tienda.dao.ProductoDao;
import com.tienda.service.ProductoService;
import com.tienda_v2.domain.Producto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public abstract class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoDao productoDao;

    @Override
    @Transactional(readOnly = true)

    public List<Producto> getProductos(boolean activos) {

        var lista = productoDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());

        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Producto getProducto(Producto producto) {
        return productoDao.findById(producto.getIdProducto()).orElse(null);
    }

    @Override
    public void save(Producto producto) {
        productoDao.save(producto);
    }

    @Override
    public void delete(Producto producto) {
        productoDao.delete(producto);
    }

    @Transactional(readOnly = true)
    public List<Producto> getByPrecio(double precioInf, double precioSup) {
        return productoDao.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);
    }

}
