/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DrunkPizza.Drunk.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 *
 * @author Alonso
 */
@Entity
@Table(name = "metodo_pago")
public class metodo_pago {
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String metodo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }
    
}
