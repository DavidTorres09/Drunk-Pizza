package com.DrunkPizza.Drunk.service;

import com.DrunkPizza.Drunk.entity.usuario;
import com.DrunkPizza.Drunk.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author angel
 */
@Service
public class UsuarioService implements IUsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Override
    public List<usuario> getAllUsuarios() {
        return (List<usuario>)usuarioRepository.findAll();
    }

    @Override
    public usuario getUsuarioById(long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public void saveUsuario(usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public void delete(long id) {
        usuarioRepository.deleteById(id);
    }
    
}
