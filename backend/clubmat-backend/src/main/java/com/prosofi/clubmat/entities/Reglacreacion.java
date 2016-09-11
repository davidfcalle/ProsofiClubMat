package com.prosofi.clubmat.entities;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "reglacreacion")
@XmlRootElement
public class Reglacreacion {
	
	@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idregla")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idregla;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 30)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "idclub", referencedColumnName = "idclub")
    @ManyToOne
    private Clubmatematicas idclub;
    @Lob
    @Column(name = "documento")    
    private byte[] documento;

    public Reglacreacion() {
    }

    public Reglacreacion(Integer idregla) {
        this.idregla = idregla;
    }

    public Integer getIdregla() {
        return idregla;
    }

    public void setIdregla(Integer idregla) {
        this.idregla = idregla;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Clubmatematicas getIdclub() {
        return idclub;
    }

    public void setIdclub(Clubmatematicas idclub) {
        this.idclub = idclub;
    }

    public byte[] getDocumento() {
        return documento;
    }

    public void setDocumento(byte[] documento) {
        this.documento = documento;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idregla != null ? idregla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reglacreacion)) {
            return false;
        }
        Reglacreacion other = (Reglacreacion) object;
        if ((this.idregla == null && other.idregla != null) || (this.idregla != null && !this.idregla.equals(other.idregla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.javeriana.clubmat.entidades.Reglacreacion[ idregla=" + idregla + " ]";
    }
}
