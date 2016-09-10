package com.prosofi.clubmat.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

import com.prosofi.clubmat.enums.EstadoUsuario;

public class Usuario {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Size(min = 2)
    @Column(unique = true, nullable = false, length = 30)
    private String nomusuario;
    
    @Size(min = 3)
    @Column(nullable = false, length = 30)
    private String passw;
    
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(min = 5)
    @Column(nullable = false, length = 50)
    private String email;
    
    @Size(min = 3)
    @Column(nullable = false, length = 50)
    private String nombres;
    
    @Size(min = 3)
    @Column(nullable = false, length = 50)
    private String apellidos;
    
    @Size(min = 4)
    @Column(nullable = false, length = 100)
    private String direccion;
    
    @Size(min = 3)
    @Column(nullable = false, length = 30)
    private String ciudad;
    
    @Size(min = 3)
    @Column(nullable = false, length = 30)
    private String celular;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadoUsuario estado;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "creador", fetch = FetchType.LAZY)
    private Institucion institucion;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "registrador", fetch = FetchType.LAZY)
    private ClubMatematicas club;

    @JoinColumn(name = "rol", referencedColumnName = "id", nullable = false)
    @ManyToOne
    private Rol rol;

    public Usuario() {
        rol = new Rol( );
    }

    public Usuario(Long id) {
        this.id = id;
        rol = new Rol( );
    }

    public Usuario( String nomusuario, String passw, String email, String nombres, String apellidos, String direccion, String ciudad, String celular, String estado, Rol rol ) {
        this.nomusuario = nomusuario;
        this.passw = passw;
        this.email = email;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.celular = celular;
        
        if( estado.equalsIgnoreCase("ACTIVO") )
            this.estado = EstadoUsuario.ACTIVO;
        else this.estado = EstadoUsuario.INACTIVO;
        
        this.rol = rol;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomusuario() {
        return nomusuario;
    }

    public void setNomusuario(String nomusuario) {
        this.nomusuario = nomusuario;
    }

    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Institucion getInstitucion() {
        return institucion;
    }

    public void setInstitucion(Institucion institucion) {
        this.institucion = institucion;
    }
    
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public ClubMatematicas getClub() {
        return club;
    }

    public void setClub(ClubMatematicas club) {
        this.club = club;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public EstadoUsuario getEstado() {
        return estado;
    }

    public void setEstado(EstadoUsuario estado) {
        this.estado = estado;
    }

    public Rol getRol() {
        return rol;
    }
    
    public String getNombreRol( )
    {
        return this.rol.getNombrerol( );
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPA.Usuario[ id=" + id + " ]";
    }
}
