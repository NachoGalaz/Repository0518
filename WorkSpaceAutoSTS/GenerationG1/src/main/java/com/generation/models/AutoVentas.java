package com.generation.models;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="autos_ventas")
//Tabla relacional
public class AutoVentas {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer cantidad;
    private float subtotal;
    private Date fecha;

    //ManyToOne Auto
    @ManyToOne(fetch = FetchType.LAZY)
	//EAGER carga automaticamente las relaciones LAZY cuando ud. la quiere consumir
	@JoinColumn(name="auto_id") //PK de la otra entidad, en este caso en cliente se llama id
    //un cliente puede tener muchas compras, pero las compras estaran asociadas a un cliente
    private Auto auto;

    //ManyToOne CompraVenta
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="compras_ventas_id") //PK de la otra entidad, en este caso en cliente se llama id
    private CompraVenta compraVenta;

    public AutoVentas() {
    }

    public AutoVentas(Integer cantidad, float subtotal, Date fecha, Auto auto, CompraVenta compraVenta) {
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.fecha = fecha;
        this.auto = auto;
        this.compraVenta = compraVenta;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public CompraVenta getCompraVenta() {
        return compraVenta;
    }

    public void setCompraVenta(CompraVenta compraVenta) {
        this.compraVenta = compraVenta;
    }
    


}

