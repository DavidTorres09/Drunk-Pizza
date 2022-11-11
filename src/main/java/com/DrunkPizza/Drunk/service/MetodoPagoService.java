
package com.DrunkPizza.Drunk.service;

import com.DrunkPizza.Drunk.entity.metodo_pago;
import com.DrunkPizza.Drunk.repository.Metodo_PagoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author angel
 */
@Service
public class MetodoPagoService implements IMetodoPagoService {
    
    @Autowired
    private Metodo_PagoRepository metodopagoRepository;
    
    @Override
    public List<metodo_pago> listCategory() {
        return (List<metodo_pago>) metodopagoRepository.findAll();
    }
    
}
