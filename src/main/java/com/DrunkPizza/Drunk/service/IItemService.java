/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DrunkPizza.Drunk.service;

import com.DrunkPizza.Drunk.entity.Item;
import java.util.ArrayList;
import java.util.List;


public interface IItemService {
    
    //En lugar de una tabla de BD se usa una ArrayList para registro temporal
    public List<Item> listaItems = new ArrayList<>();
    
    public List<Item> getAllItems();
    
    public Item getItem (Item item);
    
    public void saveItem (Item item);
    
    public void delete (Item item);
    
    public void actualiza(Item item);
    
    public void facturar();
    
}
