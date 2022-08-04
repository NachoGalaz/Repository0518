package com.generation.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name="roles")
public class Rol {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;

    //ManyToMany es lo mismo que tener 2 OneToMany
    @ManyToMany(mappedBy = "roles",fetch=FetchType.LAZY)
    private List<Usuario> listaUsuario;


    //Hay que ver si es necesario agregar createdAt o updatedAt
    @Column(updatable= false)
	private Date createdAt;
	private Date updatedAt;
    
    
    public Rol() {
    }

    public Rol(String nombre, String descripcion, List<Usuario> usuarios) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.listaUsuario = listaUsuario;

    }

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public void setListaUsuario(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
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
