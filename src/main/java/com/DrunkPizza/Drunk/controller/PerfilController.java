/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DrunkPizza.Drunk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author angel
 */
@Controller
public class PerfilController {

    @GetMapping("/perfil")
    public String index() {
        return "/perfil";
    }

}
