package com.DrunkPizza.Drunk.repository;

import com.DrunkPizza.Drunk.entity.productos_pedido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author angel
 */
@Repository
public interface Productos_PedidoRepository extends CrudRepository <productos_pedido,Long> {
    
}
