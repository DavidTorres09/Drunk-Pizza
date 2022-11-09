/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.DrunkPizza.Drunk.service;

import com.DrunkPizza.Drunk.entity.usuario;
import java.util.List;

/**
 *
 * @author angel
 */
public interface IUsuarioService {
    
    public List<usuario> getAllUsuarios();
    public usuario getProductosUsuarioById (long id);
    public void saveUsuario (usuario usuario);
    public void delete (long id);
}
