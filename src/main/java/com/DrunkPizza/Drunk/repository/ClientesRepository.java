package com.DrunkPizza.Drunk.repository;
import com.DrunkPizza.Drunk.entity.clientes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author angel
 */
@Repository
public interface ClientesRepository extends CrudRepository <clientes,Long> {
    
}
