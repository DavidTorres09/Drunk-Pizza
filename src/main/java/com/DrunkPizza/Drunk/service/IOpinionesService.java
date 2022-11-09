/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.DrunkPizza.Drunk.service;

import com.DrunkPizza.Drunk.entity.opiniones;
import java.util.List;

/**
 *
 * @author angel
 */
public interface IOpinionesService {
    
    public List<opiniones> getAllOpiniones();
    public opiniones getOpinionById (long id);
    public void saveOpinion (opiniones opinion);
    public void delete (long id);
    
    
}
