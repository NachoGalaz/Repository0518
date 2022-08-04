package com.generation.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import java.util.List;


@Entity
@Table(name="clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String email;

//OneToMany o ManyToOne dependiendo desde donde se vea
    @OneToMany(mappedBy = "cliente",cascade=CascadeType.ALL ,fetch = FetchType.LAZY) 
    //un cliente puede tener muchas compras, pero las compras estaran asociadas a un cliente
    private List<CompraVenta> comprasVentas;
    //Se crea pq un cliente tendar mas de una compra, al consultar po run cliente
    //y teng mas de una compra la unica forma de traerla es con una lista
    
    

    @Column(updatable=false)
    private Date createdAt;
	private Date updatedAt;

    //Constructores
    
    public Cliente() {
    }
    
    //No agregamos id al constructor ya que se genera solo y autoincrementa
    public Cliente(String nombre, String apellido, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

        //Getter y setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
