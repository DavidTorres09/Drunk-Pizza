package com.DrunkPizza.Drunk.service;
import com.DrunkPizza.Drunk.entity.clientes;
import com.DrunkPizza.Drunk.repository.ClientesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author angel
 */
@Service
public class ClientesService implements IClientesService {
    
    @Autowired
    private ClientesRepository clienteRepository;

    @Override
    public List<clientes> getAllClientes() {
        return (List<clientes>)clienteRepository.findAll();
    }

    @Override
    public clientes getClienteById(long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public void saveCliente(clientes cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public void delete(long id) {
        clienteRepository.deleteById(id);
    }
    
}
