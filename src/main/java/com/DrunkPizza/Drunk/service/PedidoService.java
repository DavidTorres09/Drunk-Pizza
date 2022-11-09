/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DrunkPizza.Drunk.service;

import com.DrunkPizza.Drunk.entity.pedido;
import com.DrunkPizza.Drunk.repository.PedidoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author angel
 */
@Service
public class PedidoService implements IPedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    
    @Override
    public List<pedido> getAllPedidos() {
        return (List<pedido>)pedidoRepository.findAll();
    }

    @Override
    public pedido getPedidoById(long id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    @Override
    public void savePedido(pedido pedido) {
        pedidoRepository.save(pedido);
    }

    @Override
    public void delete(long id) {
        pedidoRepository.deleteById(id);
    }
    
}
