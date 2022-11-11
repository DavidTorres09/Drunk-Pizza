package com.DrunkPizza.Drunk.service;

import com.DrunkPizza.Drunk.entity.clientes;
import java.util.List;

/**
 *
 * @author angel
 */

public interface IClientesService {
    
    public List<clientes> getAllClientes();
    public clientes getClienteById (long id);
    public void saveCliente (clientes cliente);
    public void delete (long id);
    
}
