package com.DrunkPizza.Drunk.controller;

import com.DrunkPizza.Drunk.entity.Producto;
import com.DrunkPizza.Drunk.service.IProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author angel
 */
@Controller
public class ProductoController {
    
    @Autowired
    private IProductoService productoService;



    @GetMapping("/producto")
    public String index(Model model) {
        List<Producto> listaProducto = productoService.getAllProducto();
        model.addAttribute("titulo", "Productos");
        model.addAttribute("producto", listaProducto);
        return "producto";
    }

    @GetMapping("productoNuevo")
    public String crearPersona(Model model) {
        model.addAttribute("producto", new Producto());
        return "crear";
    }
    
    
    @PostMapping("/save")
    public String guardarPersona(@ModelAttribute Producto producto){
        productoService.saveProducto(producto);
        return "redirect:/producto";
    }
    
    @GetMapping("/editPersona/{id}")
    public String editarPersona(@PathVariable("id")Long idProducto, Model model){
        Producto producto = productoService.getProductoById(idProducto);
        model.addAttribute("producto", producto);
        return "crear";
    }
    
    @GetMapping("/deleteProducto/{id}")
    public String eliminarPersona(@PathVariable("id") Long idProducto){
        productoService.delete(idProducto);
        return "redirect:/producto";
    }
    
}
