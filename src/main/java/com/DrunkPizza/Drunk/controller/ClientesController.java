package com.DrunkPizza.Drunk.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.DrunkPizza.Drunk.entity.Clientes;
import com.DrunkPizza.Drunk.repository.ClienteRepository;
import com.DrunkPizza.Drunk.service.IClientesService;

@Controller
public class ClientesController {
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    @Autowired
    private IClientesService clientesService;


    @GetMapping("/cliente")
    public String index(Model model) {
        List<Clientes> listaClientes = clientesService.getAllClientes();
        model.addAttribute("titulo", "Cliente");
        model.addAttribute("cliente", listaClientes);
        return "/perfil";
    }

    @GetMapping("clienteNuevo")
    public String crearCliente(Model model) {
        model.addAttribute("cliente", new Clientes());
        return "clienteNuevo";
    }
    
    
    @PostMapping("/saveCliente")
    public String guardarCliente(@ModelAttribute Clientes cliente){
        clientesService.saveCliente(cliente);
        return "redirect:/cliente";
    }
    
    @GetMapping("/editClientes/{id}")
    public String editarCliente(@PathVariable("id")Long idCliente, Model model){
        Clientes cliente = clientesService.getClienteById(idCliente);
        model.addAttribute("cliente", cliente);
        return "clienteNuevo";
    }
    
    @GetMapping("/deleteCliente/{id}")
    public String eliminarCliente(@PathVariable("id") Long idCliente){
        clientesService.delete(idCliente);
        return "redirect:/cliente";
    }
    
    @GetMapping("/perfil/{id}")
    public String perfil(@PathVariable("id") Long idCliente, Model model) {
        Clientes cliente = clientesService.getClienteById(idCliente);
        model.addAttribute("cliente", cliente);
        return "/perfil";
    }
    
}

