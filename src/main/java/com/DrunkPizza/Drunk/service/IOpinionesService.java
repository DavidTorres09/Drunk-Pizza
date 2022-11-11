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
