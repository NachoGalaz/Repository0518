package com.generation.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import java.util.List;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="autos")
public class Auto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String marca;
	private String modelo;
	private Float velocidad;
	private String color;
	private Float valor;
	
    public Float getValor() {
		return valor;
	}
	public void setValor(Float valor) {
		this.valor = valor;
	}
	public Auto(Float valor) {
		this.valor = valor;
	}
	//ManyToMany AutosVentas
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
		name="autos_ventas",//Nombre de la tabla relacional
		//tabla intermedia
		joinColumns = @JoinColumn(name="auto_id") ,//desde donde estamos posicionados (entidad)
		inverseJoinColumns= @JoinColumn(name="compras_ventas_id") // aca seria desde la otra tabla
	    )
		
	private List<CompraVenta> comprasVentas;

	public List<CompraVenta> getComprasVentas() {
		return comprasVentas;
	}
	public void setComprasVentas(List<CompraVenta> comprasVentas) {
		this.comprasVentas = comprasVentas;
	}
	public Auto(List<CompraVenta> comprasVentas) {
		this.comprasVentas = comprasVentas;
	}
	@Column(updatable= false)
	private Date createdAt;
	private Date updatedAt;
	
	public Auto() {
		super();
	}
	public Auto(Long id, String marca, String modelo, Float velocidad, String color) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.velocidad = velocidad;
		this.color = color;
	}
	public Long getId() {
		return id;
	}
	public String getMarca() {
		return marca;
	}
	public String getModelo() {
		return modelo;
	}
	public Float getVelocidad() {
		return velocidad;
	}
	public String getColor() {
		return color;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public void setVelocidad(Float velocidad) {
		this.velocidad = velocidad;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

}
