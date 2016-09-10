package com.prosofi.clubmat.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

public class Institucion {
	
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Size(min = 4)
    @Column(unique = true, nullable = false, length = 60)
    private String nombreinst;
    
    @Size(min = 3)
    @Column(nullable = false, length = 40)
    private String localidad;
    
    @Size(min = 4)
    @Column(nullable = false, length = 100)
    private String direccion;
    
    @Size(min = 4)
    @Column(nullable = false, length = 40)
    private String telefono;
    
    @Size(min = 4)
    @Column(nullable = false, length = 60)
    private String rector;
    
    @Size(min = 3)
    @Column(nullable = false, length = 40)
    private String tipoinstitucion;
    
    @Size(min = 4)
    @Column(nullable = false, length = 30)
    private String ciudad;
    
    @JoinColumn(unique = true, name = "creador", referencedColumnName = "id", nullable = false)
    @OneToOne
    private Usuario creador;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "institucion", fetch = FetchType.LAZY)
    private ClubMatematicas club;

    public Institucion() {
    }

    public Institucion(Long id) {
        this.id = id;
    }

    public Institucion( String nombreinst, String ciudad, String localidad, String direccion, String telefono, String rector, String tipoinstitucion, Usuario creador) {
        this.nombreinst = nombreinst;
        this.ciudad = ciudad;
        this.localidad = localidad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.rector = rector;
        this.tipoinstitucion = tipoinstitucion;
        this.creador = creador;
    }

    public Long getIdinstitucion() {
        return id;
    }

    public void setIdinstitucion(Long idinstitucion) {
        this.id = idinstitucion;
    }

    public String getNombreinst() {
        return nombreinst;
    }

    public void setNombreinst(String nombreinst) {
        this.nombreinst = nombreinst;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRector() {
        return rector;
    }

    public void setRector(String rector) {
        this.rector = rector;
    }

    public Usuario getCreador() {
        return creador;
    }

    public void setCreador(Usuario registrador) {
        this.creador = registrador;
    }
    
    public String getTipoinstitucion() {
        return tipoinstitucion;
    }

    public void setTipoinstitucion(String tipoinstitucion) {
        this.tipoinstitucion = tipoinstitucion;
    }

    public ClubMatematicas getClub() {
        return club;
    }

    public void setClub(ClubMatematicas club) {
        this.club = club;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
    
    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Institucion)) {
            return false;
        }
        Institucion other = (Institucion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPA.Institucion[ id=" + id + " ]";
    }
}
