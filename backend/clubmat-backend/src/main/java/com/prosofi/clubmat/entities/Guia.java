package com.prosofi.clubmat.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "guia")
@XmlRootElement
public class Guia implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Basic(optional = false)
    @Column(name = "idguia")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idguia;
	
    @Column(name = "grado")
    private Integer grado; 
    
    @Size(max = 500)
    @Column(name = "comentarios")
    private String comentarios;
    
    
    @JsonIgnore
    @Lob
    @Column(name = "documento")    
    private byte[] documento;

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public byte[] getDocumento() {
        return documento;
    }

    public void setDocumento(byte[] documento) {
        this.documento = documento;
    }
    

    public Guia() {
    }

    public Guia(Integer idguia) {
        this.idguia = idguia;
    }

    public Integer getIdguia() {
        return idguia;
    }

    public void setIdguia(Integer idguia) {
        this.idguia = idguia;
    }

    public Integer getGrado() {
        return grado;
    }

    public void setGrado(Integer grado) {
        this.grado = grado;
    }  

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idguia != null ? idguia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Guia)) {
            return false;
        }
        Guia other = (Guia) object;
        if ((this.idguia == null && other.idguia != null) || (this.idguia != null && !this.idguia.equals(other.idguia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.javeriana.clubmat.entidades.Guia[ idguia=" + idguia + " ]";
    }
}
