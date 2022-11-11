package com.DrunkPizza.Drunk.service;

import com.DrunkPizza.Drunk.entity.usuario;
import java.util.List;

/**
 *
 * @author angel
 */
public interface IUsuarioService {
    
    public List<usuario> getAllUsuarios();
    public usuario getUsuarioById (long id);
    public void saveUsuario (usuario usuario);
    public void delete (long id);
}
