package com.DrunkPizza.Drunk.service;

import com.DrunkPizza.Drunk.entity.pedido;
import java.util.List;

/**
 *
 * @author angel
 */
public interface IPedidoService {
    
    public List<pedido> getAllPedidos();
    public pedido getPedidoById (long id);
    public void savePedido (pedido pedido);
    public void delete (long id);
    
    
}
