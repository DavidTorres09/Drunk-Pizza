/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
