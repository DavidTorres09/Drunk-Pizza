package com.DrunkPizza.Drunk.repository;

import com.DrunkPizza.Drunk.entity.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author angel
 */
@Repository
public interface ProductoRepository extends CrudRepository <Producto,Long> {
    
}
