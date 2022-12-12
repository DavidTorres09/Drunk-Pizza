package com.DrunkPizza.Drunk.service;

import com.DrunkPizza.Drunk.entity.Clientes;
import java.util.List;

/**
 *
 * @author angel
 */

public interface IClientesService {
    
    public List<Clientes> getAllClientes();
    public Clientes getClienteById (long id);
    public void saveCliente (Clientes cliente);
    public void delete (long id);
    public Clientes findByNombre(String nombre);

}
