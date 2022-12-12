package com.DrunkPizza.Drunk.repository;
import com.DrunkPizza.Drunk.entity.Clientes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository <Clientes,Long> {
    public Clientes findByNombre(String nombre);

}


