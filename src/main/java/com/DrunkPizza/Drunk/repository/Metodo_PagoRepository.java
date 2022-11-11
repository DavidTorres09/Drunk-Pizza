package com.DrunkPizza.Drunk.repository;

import com.DrunkPizza.Drunk.entity.metodo_pago;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author angel
 */
@Repository
public interface Metodo_PagoRepository extends CrudRepository <metodo_pago,Long> {
    
}
