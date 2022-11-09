/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DrunkPizza.Drunk.service;

import com.DrunkPizza.Drunk.entity.opiniones;
import com.DrunkPizza.Drunk.repository.OpinionesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author angel
 */
@Service
public class OpinionesService implements IOpinionesService {

    @Autowired
    private OpinionesRepository opinionesRepository;
    
    @Override
    public List<opiniones> getAllOpiniones() {
        return (List<opiniones>)opinionesRepository.findAll();
    }

    @Override
    public opiniones getOpinionById(long id) {
        return opinionesRepository.findById(id).orElse(null);
    }

    @Override
    public void saveOpinion(opiniones opinion) {
       opinionesRepository.save(opinion);
    }

    @Override
    public void delete(long id) {
       opinionesRepository.deleteById(id);
    }
    
}
