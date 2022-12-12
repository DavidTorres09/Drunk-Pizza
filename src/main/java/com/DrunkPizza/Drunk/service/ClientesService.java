package com.DrunkPizza.Drunk.service;
import com.DrunkPizza.Drunk.entity.Clientes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.DrunkPizza.Drunk.repository.ClienteRepository;
/**
 *
 * @author angel
 */
@Service
public class ClientesService implements IClientesService {
    
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Clientes> getAllClientes() {
        return (List<Clientes>)clienteRepository.findAll();
    }

    @Override
    public Clientes getClienteById(long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public void saveCliente(Clientes cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public void delete(long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public Clientes findByNombre(String nombre) {
        return clienteRepository.findByNombre(nombre);
    }
    
}
