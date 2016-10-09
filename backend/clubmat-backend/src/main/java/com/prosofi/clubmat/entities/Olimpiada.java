package com.prosofi.clubmat.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "olimpiada")
@XmlRootElement
public class Olimpiada implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Basic(optional = false)
    @Column(name = "idolimpiada")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idolimpiada;
	
    @Size(max = 30)
    @Column(name = "nombre")
    private String nombre; 
    
    
    @Size(max = 30)
    @Column(name = "ciudad")
    private String ciudad;
    
    
    @Size(max = 50)
    @Column(name = "lugar")
    private String lugar;
    
    @Size(max = 15)
    @Column(name = "hora")
    private String hora;
    
    @Size(max = 50)
    @Column(name = "direccion")
    private String direccion;
    
    @Size(max = 30)
    @Column(name = "activacion")
    private String activacion;
    
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    
    @Column(name = "telefono")
    private Integer telefono;
    
    
    @JsonIgnore
    @JoinTable(name = "usuario_olimpiada", joinColumns = {
        @JoinColumn(name = "olimpiada_idolimpiada", referencedColumnName = "idolimpiada")}, inverseJoinColumns = {
        @JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario")})
    @ManyToMany()
    private List<Usuario> usuarioList;
    
    
    @JsonIgnore
    @JoinColumn(name = "organizador", referencedColumnName = "idusuario")
    @ManyToOne
    private Usuario organizador;
    
    
    @JsonIgnore
    @JoinColumn(name = "idprueba", referencedColumnName = "idprueba")
    @ManyToOne
    private Prueba idprueba;
    
    
    @JsonIgnore
    @JoinColumn(name = "idclub", referencedColumnName = "idclub")
    @ManyToOne
    private Clubmatematicas idclub;
    
    
    @JsonIgnore
    @OneToMany(mappedBy = "idolimpiada")
    private List<UsuarioOlimpiada> usuarioOlimpiadaList;

    public Olimpiada() {
    }

    public Olimpiada(Integer idolimpiada) {
        this.idolimpiada = idolimpiada;
    }

    public Integer getIdolimpiada() {
        return idolimpiada;
    }

    public void setIdolimpiada(Integer idolimpiada) {
        this.idolimpiada = idolimpiada;
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

    public String getActivacion() {
        return activacion;
    }

    public void setActivacion(String activacion) {
        this.activacion = activacion;
    }        

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public Prueba getIdprueba() {
        return idprueba;
    }

    public void setIdprueba(Prueba idprueba) {
        this.idprueba = idprueba;
    }

    public List<UsuarioOlimpiada> getUsuarioOlimpiadaList() {
        return usuarioOlimpiadaList;
    }

    public void setUsuarioOlimpiadaList(List<UsuarioOlimpiada> usuarioOlimpiadaList) {
        this.usuarioOlimpiadaList = usuarioOlimpiadaList;
    }

    public Usuario getOrganizador() {
        return organizador;
    }

    public void setOrganizador(Usuario organizador) {
        this.organizador = organizador;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public Clubmatematicas getIdclub() {
        return idclub;
    }

    public void setIdclub(Clubmatematicas idclub) {
        this.idclub = idclub;
    }

    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idolimpiada != null ? idolimpiada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Olimpiada)) {
            return false;
        }
        Olimpiada other = (Olimpiada) object;
        if ((this.idolimpiada == null && other.idolimpiada != null) || (this.idolimpiada != null && !this.idolimpiada.equals(other.idolimpiada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.javeriana.clubmat.entidades.Olimpiada[ idolimpiada=" + idolimpiada + " ]";
    }
	
}
