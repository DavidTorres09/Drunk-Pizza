package com.DrunkPizza.Drunk.repository;

import com.DrunkPizza.Drunk.entity.pedido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author angel
 */
@Repository
public interface PedidoRepository extends CrudRepository <pedido,Long> {
    
}
