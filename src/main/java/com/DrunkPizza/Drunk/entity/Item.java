
package com.DrunkPizza.Drunk.entity;

import lombok.Data;

@Data
public class Item extends Producto {
    private int cantidad; //Almacena la cantidad de items de un producto

    public Item() {
        
    }
    
    public Item(Producto producto){
        super.setId_producto(producto.getId_producto());
        super.setId_categoria(producto.getId_categoria());
        super.setNombre(producto.getNombre());
        super.setRutaImagen(producto.getRutaImagen());
        super.setDescripcion(producto.getDescripcion());
        super.setPrecio(producto.getPrecio());
        this.cantidad=0;
    
    }
    
    
    
    
}
