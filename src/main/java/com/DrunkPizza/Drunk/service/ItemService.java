package com.DrunkPizza.Drunk.service;

;
import com.DrunkPizza.Drunk.entity.Item;
import java.util.List;
import org.apache.catalina.servlets.CGIServlet;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;
import com.DrunkPizza.Drunk.entity.Item;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;
import com.DrunkPizza.Drunk.entity.Item;
import java.util.List;
import org.apache.catalina.servlets.CGIServlet;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;
import com.DrunkPizza.Drunk.entity.Item;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;



@Service
public class ItemService implements IItemService {

    @Override
    public List<Item> getAllItems() {
        return listaItems;
    }

    @Override
    public void saveItem(Item item) {
        boolean existe = false;
        for (Item c : listaItems) {
            //Busca si ya existe el articulo en el carrito
            if (Objects.equals(c.getId_producto(), item.getId_producto())) {
                c.setCantidad(c.getCantidad() + 1);

            }
            existe = true;
            break;
        }
        if (!existe) {//Si no esta el producto en el carrito entonces lo agrega cantidad = 1.
            item.setCantidad(1);
            listaItems.add(item);
        }
    }

    @Override
    public void delete(Item item) {
        var posicion = -1;
        var existe = false;
        for (Item c : listaItems) {
            ++posicion;
            if (Objects.equals(c.getId_producto(), item.getId_producto())) {
                existe = true;
                break;
            }
        }
        if (existe) {
            listaItems.remove(posicion);
        }
    }

    @Override
    public Item getItem(Item item) {
        for (Item c : listaItems) {
            if (Objects.equals(c.getId_producto(), item.getId_producto())) {
                return c;
            }
        }
        return null;
    }

    @Override
    public void actualiza(Item item) {
        for (Item i : listaItems) {
            if (Objects.equals(i.getId_producto(), item.getId_producto())) {
                i.setCantidad((item.getCantidad()));
                break;
            }
        }
    }

    @Override
    public void facturar() {
        for (Item i : listaItems) {
            //Proceso de facturacion
        }
        listaItems.clear();
    }
}
