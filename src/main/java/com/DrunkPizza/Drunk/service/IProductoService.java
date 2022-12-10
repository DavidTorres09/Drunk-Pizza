package com.DrunkPizza.Drunk.service;

import com.DrunkPizza.Drunk.entity.Producto;
import java.util.List;

/**
 *
 * @author angel
 */
public interface IProductoService {
     public List<Producto> getAllProducto();
    public Producto getProductoById (long id);
    public void saveProducto (Producto producto);
    public void delete (long id);
    public Producto getProducto (Producto producto);
    
    
}
