package com.DrunkPizza.Drunk.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClientesController {
    
    @Autowired
    private IClienteService clienteService;



    @GetMapping("/cliente")
    public String index(Model model) {
        List<Clientes> listaClientes = clienteService.getAllClientes();
        model.addAttribute("titulo", "Cliente");
        model.addAttribute("cliente", listaClientes);
        return "cliente";
    }

    @GetMapping("clienteNuevo")
    public String crearCliente(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "crear";
    }
    
    
    @PostMapping("/save")
    public String guardarPersona(@ModelAttribute Cliente cliente){
        productoService.saveCliente(cliente);
        return "redirect:/producto";
    }
    
    @GetMapping("/editPersona/{id}")
    public String editarPersona(@PathVariable("id")Long idCliente, Model model){
        Cliente cliente = clienteService.getClienteById(idCliente);
        model.addAttribute("cliente", cliente);
        return "crear";
    }
    
    @GetMapping("/deleteCliente/{id}")
    public String eliminarPersona(@PathVariable("id") Long idCliente){
        clienteService.delete(idCliente);
        return "redirect:/cliente";
    }
    
}

