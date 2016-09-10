package com.prosofi.clubmat.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

public class ClubMatematicas {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Size(min = 2)
    @Column(unique = true, nullable = false, length = 50)
    private String nombre;
    
    @Size(min = 3)
    @Column(nullable = false, length = 250)
    private String lema;
    
    @JoinColumn(unique = true, name = "registrador", referencedColumnName = "id", nullable = false)
    @OneToOne
    private Usuario registrador;
    
    @JoinColumn(unique = true, name = "institucion", referencedColumnName = "id", nullable = false)
    @OneToOne
    private Institucion institucion;

    public ClubMatematicas() {
    }

    public ClubMatematicas(Long id) {
        this.id = id;
    }

    public ClubMatematicas( String nombre, String lema, Institucion inst, Usuario us) {
        this.nombre = nombre;
        this.lema = lema;
        this.institucion = inst;
        this.registrador = us;
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

    public String getLema() {
        return lema;
    }

    public void setLema(String lema) {
        this.lema = lema;
    }

    public Usuario getRegistrador() {
        return registrador;
    }

    public void setRegistrador(Usuario registrador) {
        this.registrador = registrador;
    }

    public Institucion getInstitucion() {
        return institucion;
    }

    public void setInstitucion(Institucion institucion) {
        this.institucion = institucion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ClubMatematicas)) {
            return false;
        }
        ClubMatematicas other = (ClubMatematicas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPA.Clubmatematicas[ id=" + id + " ]";
    }
}
