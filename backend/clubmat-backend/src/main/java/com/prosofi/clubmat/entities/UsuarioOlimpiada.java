package com.prosofi.clubmat.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author julianortega
 */

@Entity
@Table(name = "usuariolimpiada")
@XmlRootElement
public class UsuarioOlimpiada implements Serializable {
    
	private static final long serialVersionUID = 1L;
	
    @Id
    @Basic(optional = false)
    @Column(name = "idusuariolimpiada")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idusuariolimpiada;
    
    @JsonIgnore
    @JoinColumn(name = "idolimpiada", referencedColumnName = "idolimpiada")
    @ManyToOne
    private Olimpiada idolimpiada;
    
    @JsonIgnore
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    @ManyToOne
    private Usuario idusuario;

    public Integer getIdusuariolimpiada() {
        return idusuariolimpiada;
    }

    public void setIdusuariolimpiada(Integer idusuariolimpiada) {
        this.idusuariolimpiada = idusuariolimpiada;
    }

    public Olimpiada getIdolimpiada() {
        return idolimpiada;
    }

    public void setIdolimpiada(Olimpiada idolimpiada) {
        this.idolimpiada = idolimpiada;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }
    
    
}

