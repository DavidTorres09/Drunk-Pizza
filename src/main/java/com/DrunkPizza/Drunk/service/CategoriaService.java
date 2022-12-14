/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DrunkPizza.Drunk.service;

import com.DrunkPizza.Drunk.entity.Categoria;
import com.DrunkPizza.Drunk.repository.CategoriaRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author angel
 */
@Service
public class CategoriaService implements ICategoriaService {

    
   @Autowired
    private CategoriaRepository categoriaRepository;
    
    @Override
    public List<Categoria> listCategoria() {
        return (List<Categoria>)categoriaRepository.findAll();
    }
    






    
}
