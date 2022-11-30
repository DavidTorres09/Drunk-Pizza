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



    @GetMapping("/")
    public String index(Model model) {
        List<Producto> listaProducto = productoService.getAllProducto();
        model.addAttribute("titulo", "Productos");
        model.addAttribute("producto", listaProducto);
        return "index";
    }

    @GetMapping("productoN")
    public String crearProducto(Model model) {
        model.addAttribute("producto", new Producto());
        return "productoNuevo";
    }
    
    
    @PostMapping("/saveProducto")
    public String guardarProducto(@ModelAttribute Producto producto){
        productoService.saveProducto(producto);
        return "redirect:/";
    }
    
    @GetMapping("/editProducto/{id}")
    public String editarProducto(@PathVariable("id")Long idProducto, Model model){
        Producto producto = productoService.getProductoById(idProducto);
        model.addAttribute("producto", producto);
        return "redirect:/";
    }
    
    @GetMapping("/deleteProducto/{id}")
    public String eliminarProducto(@PathVariable("id") Long idProducto){
        productoService.delete(idProducto);
        return "redirect:/";
    }
    
}
