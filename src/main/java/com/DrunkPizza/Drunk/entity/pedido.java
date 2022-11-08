package com.DrunkPizza.Drunk.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Alonso
 */
@Entity
public class pedido implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_pedido;
    private String precio_total;
    private String orden_cliente;
    @ManyToOne
    @JoinColumn(name="id_producto_pedido")
 
    private productos_pedido productos_pedido;
    @ManyToOne
    @JoinColumn(name="id_metodo_pago")
    private metodo_pago metodo_pago;

    public long getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(long id_pedido) {
        this.id_pedido = id_pedido;
    }

    public String getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(String precio_total) {
        this.precio_total = precio_total;
    }

    public String getOrden_cliente() {
        return orden_cliente;
    }

    public void setOrden_cliente(String orden_cliente) {
        this.orden_cliente = orden_cliente;
    }

    public productos_pedido getProductos_pedido() {
        return productos_pedido;
    }

    public void setProductos_pedido(productos_pedido productos_pedido) {
        this.productos_pedido = productos_pedido;
    }

    public metodo_pago getMetodo_pago() {
        return metodo_pago;
    }

    public void setMetodo_pago(metodo_pago metodo_pago) {
        this.metodo_pago = metodo_pago;
    }
    
}
