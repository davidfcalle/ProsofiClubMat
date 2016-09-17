package com.prosofi.clubmat.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "institucion")
@XmlRootElement
public class Institucion implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idinstitucion")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idinstitucion;
	 
	
    @Size(max = 30)
    @Column(name = "nombre")
    private String nombre;
    
    @Size(max = 30)
    @Column(name = "ciudad")
    private String ciudad;
    
    @Size(max = 15)
    @Column(name = "localidad")
    private String localidad;
    
    @Size(max = 50)
    @Column(name = "direccion")
    private String direccion;
    
    @Column(name = "telefono")
    private Integer telefono;
    
    @Size(max = 50)
    @Column(name = "rector")
    private String rector;
    
    @Size(max = 30)
    @Column(name = "tipo")
    private String tipo;
    
    
    @JsonIgnore
    @OneToMany(mappedBy = "idinstitucion")
    private List<Clubmatematicas> clubmatematicasList;


    public String getRector() {
        return rector;
    }

    public void setRector(String rector) {
        this.rector = rector;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    public Institucion() {
    }

    public Institucion(Integer idinstitucion) {
        this.idinstitucion = idinstitucion;
    }

    public Integer getIdinstitucion() {
        return idinstitucion;
    }

    public void setIdinstitucion(Integer idinstitucion) {
        this.idinstitucion = idinstitucion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }
    
    public List<Clubmatematicas> getClubmatematicasList() {
        return clubmatematicasList;
    }

    public void setClubmatematicasList(List<Clubmatematicas> clubmatematicasList) {
        this.clubmatematicasList = clubmatematicasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idinstitucion != null ? idinstitucion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Institucion)) {
            return false;
        }
        Institucion other = (Institucion) object;
        if ((this.idinstitucion == null && other.idinstitucion != null) || (this.idinstitucion != null && !this.idinstitucion.equals(other.idinstitucion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.javeriana.clubmat.entidades.Institucion[ idinstitucion=" + idinstitucion + " ]";
    }
}
