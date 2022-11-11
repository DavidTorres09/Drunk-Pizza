package com.DrunkPizza.Drunk.repository;

import com.DrunkPizza.Drunk.entity.opiniones;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author angel
 */
@Repository
public interface OpinionesRepository extends CrudRepository <opiniones,Long> {
    
}
