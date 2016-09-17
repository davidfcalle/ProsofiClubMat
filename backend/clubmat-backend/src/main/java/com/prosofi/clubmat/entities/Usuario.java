package com.prosofi.clubmat.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "usuario")
@XmlRootElement
public class Usuario implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "idusuario")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idusuario;
    
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    
    @Size(max = 50)
    @Column(name = "apellido")
    private String apellido;
    
    @Size(max = 30)
    @Column(name = "ciudad")
    private String ciudad;
    
    @Column(name = "rol")
    private String rol;
    
    @Column(name = "telefono")
    private Integer telefono;
    
    @Column(name = "puntaje")
    private Integer puntaje;
    
    @Size(max = 50)
    @Column(name = "usuario")
    private String usuario;
    
    @Size(max = 50)
    @Column(name = "email")
    private String email;
    
    @Size(max = 50)
    @Column(name = "contrasena")
    private String contrasena;  
    
    @JsonIgnore
    @ManyToMany(mappedBy = "usuarioList")
    private List<Olimpiada> olimpiadaList;
    
    @JsonIgnore
    @JoinColumn(name = "idclub", referencedColumnName = "idclub")
    @ManyToOne
    private Clubmatematicas idclub;
    
    
    @JsonIgnore
    @JoinColumn(name = "idinstitucion", referencedColumnName = "idinstitucion")
    @ManyToOne
    private Institucion idinstitucion;
    
    
    @JsonIgnore
    @OneToMany(mappedBy = "idusuario")
    private List<Prueba> pruebaList;
    
    
    @JsonIgnore
    @OneToMany(mappedBy = "idusuario")
    private List<UsuarioOlimpiada> usuarioOlimpiadaList;
   

    public Usuario() {
    }

    public Usuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @XmlTransient
    public List<UsuarioOlimpiada> getUsuarioOlimpiadaList() {
        return usuarioOlimpiadaList;
    }

    public void setUsuarioOlimpiadaList(List<UsuarioOlimpiada> usuarioOlimpiadaList) {
        this.usuarioOlimpiadaList = usuarioOlimpiadaList;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Integer getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }

   
    
    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @XmlTransient
    public List<Olimpiada> getOlimpiadaList() {
        return olimpiadaList;
    }

    public void setOlimpiadaList(List<Olimpiada> olimpiadaList) {
        this.olimpiadaList = olimpiadaList;
    }

     

    public Clubmatematicas getIdclub() {
        return idclub;
    }

    public void setIdclub(Clubmatematicas idclub) {
        this.idclub = idclub;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    
    @XmlTransient
    public List<Prueba> getPruebaList() {
        return pruebaList;
    }

    public void setPruebaList(List<Prueba> pruebaList) {
        this.pruebaList = pruebaList;
    }
    
    public Institucion getIdinstitucion() {
        return idinstitucion;
    }

    public void setIdinstitucion(Institucion idinstitucion) {
        this.idinstitucion = idinstitucion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusuario != null ? idusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idusuario == null && other.idusuario != null) || (this.idusuario != null && !this.idusuario.equals(other.idusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.javeriana.clubmat.entidades.Usuario[ idusuario=" + idusuario + " ]";
    }
    
}

