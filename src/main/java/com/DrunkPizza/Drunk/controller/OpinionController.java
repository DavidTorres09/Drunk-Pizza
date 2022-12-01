/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DrunkPizza.Drunk.controller;

import com.DrunkPizza.Drunk.entity.opiniones;
import com.DrunkPizza.Drunk.service.IOpinionesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author angel
 */
@Controller
public class OpinionController {
    
    @Autowired
    private IOpinionesService opinionesService;
    
    @GetMapping("/opinion")
    public String index(Model model) {
        List<opiniones> listaOpinion = opinionesService.getAllOpiniones();
        model.addAttribute("titulo", "Opiniones");
        model.addAttribute("opinion", listaOpinion);
        return "opinion";
    }
    
}
