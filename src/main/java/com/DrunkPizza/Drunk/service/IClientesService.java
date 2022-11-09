/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
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
