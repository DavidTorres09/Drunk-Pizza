package com.DrunkPizza.Drunk.controller;

import com.DrunkPizza.Drunk.entity.Categoria;
import com.DrunkPizza.Drunk.entity.Producto;
import com.DrunkPizza.Drunk.service.CategoriaService;
import com.DrunkPizza.Drunk.service.ICategoriaService;
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

    @Autowired
    private ICategoriaService categoriaService;

    @GetMapping("/")
    public String index(Model model) {
        List<Producto> listaProducto = productoService.getAllProducto();
        model.addAttribute("titulo", "Productos");
        model.addAttribute("producto", listaProducto);
        return "index";
    }

    @GetMapping("/productos")
    public String opcionesProductos(Model model) {
        List<Producto> listaProducto = productoService.getAllProducto();
        model.addAttribute("titulo", "Productos");
        model.addAttribute("producto", listaProducto);
        return "/productos/productos";
    }

    @GetMapping("/CrearProducto")
    public String crearProducto(Model model) {
        List<Categoria> listaCategoria = categoriaService.listCategoria();
        
        model.addAttribute("producto", new Producto());
        model.addAttribute("descripcion", listaCategoria);
        
        return "/productos/productoModificar";
    }

    @PostMapping("/saveProducto")
    public String guardarProducto(@ModelAttribute Producto producto) {
        productoService.saveProducto(producto);        
        return "redirect:/productos";
    }

    @GetMapping("/editProducto/{id}")
    public String editarProducto(@PathVariable("id") Long idProducto, Model model) {
        Producto producto = productoService.getProductoById(idProducto);
        List<Categoria> listaCategoria = categoriaService.listCategoria();
        
        model.addAttribute("descripcion", listaCategoria);
        model.addAttribute("producto", producto);

        return "/productos/productoModificar";
    }

    @GetMapping("/deleteProducto/{id}")
    public String eliminarProducto(@PathVariable("id") Long idProducto) {
        productoService.delete(idProducto);
        return "redirect:/";
    }

}
