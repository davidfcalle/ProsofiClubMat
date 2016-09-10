package com.prosofi.clubmat.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "noticia")
@XmlRootElement
public class Noticia implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idnoticia")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idnoticia;
	
    @Size(max = 200)
    @Column(name = "titulo")
    private String titulo;
    
    @Lob
    @Column(name = "foto")
    private byte[] foto;

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
    
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    
    
    @Size(max = 700)
    @Column(name = "contenido")
    private String contenido;  
    
    @Size(max = 50)
    @Column(name = "tipo")
    private String tipo;
    
    @JoinColumn(name = "idclub", referencedColumnName = "idclub")
    @ManyToOne
    private Clubmatematicas idclub;

    public Noticia() {
    }

    public Noticia(Integer idnoticia) {
        this.idnoticia = idnoticia;
    }

    public Integer getIdnoticia() {
        return idnoticia;
    }

    public void setIdnoticia(Integer idnoticia) {
        this.idnoticia = idnoticia;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    
    public Clubmatematicas getIdclub() {
        return idclub;
    }

    public void setIdclub(Clubmatematicas idclub) {
        this.idclub = idclub;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idnoticia != null ? idnoticia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Noticia)) {
            return false;
        }
        Noticia other = (Noticia) object;
        if ((this.idnoticia == null && other.idnoticia != null) || (this.idnoticia != null && !this.idnoticia.equals(other.idnoticia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.javeriana.clubmat.entidades.Noticia[ idnoticia=" + idnoticia + " ]";
    }

}
