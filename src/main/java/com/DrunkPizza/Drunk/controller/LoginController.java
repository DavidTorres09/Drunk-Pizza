/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DrunkPizza.Drunk.controller;

import com.DrunkPizza.Drunk.entity.usuario;
import com.DrunkPizza.Drunk.service.IUsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author angel
 */
public class LoginController {
    
    @Autowired
    private IUsuarioService usuarioService;
    
    
    @GetMapping("/login")
    public String index(Model model) {
        List<usuario> listaUsuario =usuarioService.getAllUsuarios();
        model.addAttribute("titulo", "usuario");
        model.addAttribute("usuario", listaUsuario);
        return "login";
    }

    @GetMapping("usuarioNuevo")
    public String crearUsuario(Model model) {
        model.addAttribute("usuario", new usuario());
        return "crearUsuario";
    }
    
    
    @PostMapping("/savePersona")
    public String guardarUsuario(@ModelAttribute usuario usuario){
        usuarioService.saveUsuario(usuario);
        return "redirect:/login";
    }
    
    @GetMapping("/editClientes/{id}")
    public String editarUsuario(@PathVariable("id")Long idUsuario, Model model){
        usuario usuario = usuarioService.getUsuarioById(idUsuario);
        model.addAttribute("usuario", usuario);
        return "crearUsuario";
    }
    
    @GetMapping("/deleteUsuario/{id}")
    public String eliminarUsuario(@PathVariable("id") Long Usuario){
        usuarioService.delete(Usuario);
        return "redirect:/login";
    }
    
}
