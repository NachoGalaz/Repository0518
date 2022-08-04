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
@Table(name="compras_ventas")
public class CompraVenta {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Range(min=0) //Valor minimo a insertar debe ser 0
    private Float monto;
    //para float por lo general se utilzia range, valor minimo
    //y no size, por lo decimales que no podemos establecer un valor minimo

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date fecha;

    @Column(updatable=false)
    private Date createdAt;
	private Date updatedAt;

    //OneToMany o ManyToOne dependiendo desde donde se vea
    //ManyToOne FK quien tena JoinColumn va tener en su tabla la FK
    @ManyToOne(fetch = FetchType.LAZY)
	//EAGER carga automaticamente las relaciones LAZY cuando ud. la quiere consumir
	@JoinColumn(name="cliente_id") //PK de la otra entidad, en este caso en cliente se llama id
    //un cliente puede tener muchas compras, pero las compras estaran asociadas a un cliente
    private Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public CompraVenta(Cliente cliente) {
        this.cliente = cliente;
    }
    //ManyToMny AutosVentas
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
		name="autos_ventas",//Nombre de la tabla relacional
		//tabla intermedia
		joinColumns = @JoinColumn(name="compras_ventas_id") ,//desde donde estamos posicionados (entidad)
		inverseJoinColumns= @JoinColumn(name="auto_id") // aca seria desde la otra tabla
	    )
	private List<Auto> autos;


    //Constructores

    public List<Auto> getAutos() {
        return autos;
    }

    public void setAutos(List<Auto> autos) {
        this.autos = autos;
    }

    public CompraVenta(List<Auto> autos) {
        this.autos = autos;
    }

    public CompraVenta() {
    }

    public CompraVenta(@Range(min = 0) Float monto, Date fecha) {
        this.monto = monto;
        this.fecha = fecha;
    }

        //Getter y setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
