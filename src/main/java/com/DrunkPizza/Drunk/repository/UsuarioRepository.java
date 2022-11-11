package com.DrunkPizza.Drunk.repository;

import com.DrunkPizza.Drunk.entity.usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author angel
 */
@Repository
public interface UsuarioRepository extends CrudRepository <usuario,Long> {
    
}
