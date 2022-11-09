/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DrunkPizza.Drunk.service;

import com.DrunkPizza.Drunk.entity.productos_pedido;
import com.DrunkPizza.Drunk.repository.Productos_PedidoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author angel
 */
@Service
public class ProductoPedidoService implements IProductosPedidoService {

    @Autowired
    private Productos_PedidoRepository productospedidoRepository;
    
    @Override
    public List<productos_pedido> getAllProductosPedido() {
        return (List<productos_pedido>)productospedidoRepository.findAll();
    }

    @Override
    public productos_pedido getProductosPedidoById(long id) {
        return productospedidoRepository.findById(id).orElse(null);
    }

    @Override
    public void saveProductosPedido(productos_pedido productos_pedido) {
         productospedidoRepository.save(productos_pedido);
    }

    @Override
    public void delete(long id) {
         productospedidoRepository.deleteById(id);
    }
    
}
