package com.DrunkPizza.Drunk.controller;

import com.DrunkPizza.Drunk.entity.Item;
import com.DrunkPizza.Drunk.entity.Producto;
import com.DrunkPizza.Drunk.service.IItemService;
import com.DrunkPizza.Drunk.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CarritoController {

    @Autowired
    private IItemService itemService;

    @Autowired
    private IProductoService productoService;

    //Para ver el carrito
    @GetMapping("/carritoListado")
    public String inicio(Model model) {
        var items = itemService.getAllItems();
        model.addAttribute("items", items);
        var carritoTotalVenta = 0;
        for (Item i : items) {
            carritoTotalVenta += (i.getCantidad() * i.getPrecio());
        }
        model.addAttribute("carritoTotal", carritoTotalVenta);
        return "/carritoListado";
    }

    //Para agregar un articulo al carrito
    @GetMapping("/carrito/agregar/{id}")
    public ModelAndView agregarProducto(Model model, Item item) {
        Item item2 = itemService.getItem(item);
        
        if (item2 == null) {
            Producto producto = productoService.getProducto(item);
            item2 = new Item(producto);
        }  
        itemService.saveItem(item2);
        var lista = itemService.getAllItems();
        var totalCarritos = 0;
        var carritoTotalVenta = 0;
        for (Item i : lista) {
            totalCarritos += i.getCantidad();
            carritoTotalVenta += (i.getCantidad() * i.getPrecio());
        }
        model.addAttribute("listaItems", lista);
        model.addAttribute("listaTotal", totalCarritos);
        model.addAttribute("carritoTotal", carritoTotalVenta);
        return new ModelAndView("/carritoFragmentos :: verCarrito");
    }

    //Para modificar articulo de carrito
    @GetMapping("/carrito/modificar/{id}")
    public String modificarCarrito(Item item, Model model) {
        item = itemService.getItem(item);
        model.addAttribute("item", item);
        return "/carrito/modificar";
    }

    //Para elminar producto del carrito
    @GetMapping("/carrito/eliminar/{id}")
    public String eliminaritem(Item item) {
        itemService.delete(item);
        return "redirect:carrito/listado";
    }

    //Para actualizar un articulo del carrito (Cantidad)
    @PostMapping("/carrito/guardar")
    public String guardaritem(Item item) {
        itemService.actualiza(item);
        return "redirect:/carrito/listado";
    }

    //Para facturar los articulos del carrito... no implementado...
    @GetMapping("facturar/carrito")
    public String facturarCarrito() {
        itemService.facturar();
        return "redirect:/";
    }

}
