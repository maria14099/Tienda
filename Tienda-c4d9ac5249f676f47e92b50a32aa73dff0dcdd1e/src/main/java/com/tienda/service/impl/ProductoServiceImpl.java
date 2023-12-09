package com.tienda.service.impl;

import com.tienda.dao.ProductoDao;
import com.tienda.service.ProductoService;
import com.tienda_v2.domain.Producto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoDao categoriaDao;

    @Override

    public List<Producto> getProductos(boolean activos) {
        var lista = categoriaDao.findAll();

        if (activos) {
            lista.removeIf(e -> !e.isActivo());

        }

        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Producto getProducto(Producto categoria) {

        return null;

    }

    @Override
    @Transactional
    public void save(Producto categoria) {
        categoriaDao.save(categoria);
    }

    @Override
    @Transactional
    public void delete(Producto categoria) {
        categoriaDao.delete(categoria);
    }

    @Override
    public List<Producto> getByPrecio(double precioInf, double precioSup) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Producto> metodoJPQL(double precioInf, double precioSup) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Producto> consultaNativo(double precioInf, double precioSup) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
