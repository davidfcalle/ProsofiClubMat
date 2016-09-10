package com.prosofi.clubmat.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "clubmatematicas")
@XmlRootElement
public class Clubmatematicas implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idclub")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idclub;
	
    @Size(max = 50)
    @Column(name = "nombreclub")
    private String nombreclub;
    
    @Size(max = 200)
    @Column(name = "lema")
    private String lema;
    
    @Size(max = 30)
    @Column(name = "porcentajereglas")
    private String porcentajeReglas;
    
    @Lob
    @Column(name = "foto")
    private byte[] foto;
    
    
    @OneToMany(mappedBy = "idclub")
    private List<Olimpiada> olimpiadaList;
    
    @OneToMany(mappedBy = "idclub")
    private List<Noticia> noticiaList;
    
    @JoinColumn(name = "idinstitucion", referencedColumnName = "idinstitucion")
    @ManyToOne
    private Institucion idinstitucion;
    
    @OneToMany(mappedBy = "idclub")
    private List<Usuario> usuarioList;
    
    @OneToMany(mappedBy = "idclub")
    private List<Reglacreacion> reglacreacionList;
    

    public Clubmatematicas() {
    }

    public Clubmatematicas(Integer idclub) {
        this.idclub = idclub;
    }

    public Integer getIdclub() {
        return idclub;
    }

    public void setIdclub(Integer idclub) {
        this.idclub = idclub;
    }

    public String getNombreclub() {
        return nombreclub;
    }

    public void setNombreclub(String nombreclub) {
        this.nombreclub = nombreclub;
    }

    public String getLema() {
        return lema;
    }

    public void setLema(String lema) {
        this.lema = lema;
    }

    public String getPorcentajeReglas() {
        return porcentajeReglas;
    }

    public void setPorcentajeReglas(String porcentajeReglas) {
        this.porcentajeReglas = porcentajeReglas;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
        
    
    public List<Olimpiada> getOlimpiadaList() {
        return olimpiadaList;
    }

    public void setOlimpiadaList(List<Olimpiada> olimpiadaList) {
        this.olimpiadaList = olimpiadaList;
    }
        
    
    public List<Noticia> getNoticiaList() {
        return noticiaList;
    }

    public void setNoticiaList(List<Noticia> noticiaList) {
        this.noticiaList = noticiaList;
    }

    public Institucion getIdinstitucion() {
        return idinstitucion;
    }

    public void setIdinstitucion(Institucion idinstitucion) {
        this.idinstitucion = idinstitucion;
    }
        
    
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }
        
    
    public List<Reglacreacion> getReglacreacionList() {
        return reglacreacionList;
    }

    public void setReglacreacionList(List<Reglacreacion> reglacreacionList) {
        this.reglacreacionList = reglacreacionList;
    }
   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idclub != null ? idclub.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clubmatematicas)) {
            return false;
        }
        Clubmatematicas other = (Clubmatematicas) object;
        if ((this.idclub == null && other.idclub != null) || (this.idclub != null && !this.idclub.equals(other.idclub))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.javeriana.clubmat.entidades.Clubmatematicas[ idclub=" + idclub + " ]";
    }
}
