/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.DrunkPizza.Drunk.service;

import com.DrunkPizza.Drunk.entity.productos_pedido;
import java.util.List;

/**
 *
 * @author angel
 */
public interface IProductosPedidoService {
    
    public List<productos_pedido> getAllProductosPedido();
    public productos_pedido getProductosPedidoById (long id);
    public void saveProductosPedido (productos_pedido productos_pedido);
    public void delete (long id);
    
}