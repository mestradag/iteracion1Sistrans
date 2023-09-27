package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String nombre;
    private String correo;
    private TipoUsuario rol;

    @ManyToOne
    @JoinColumn(name = "id_hotel", referencedColumnName = "nombre")
    private Hotel id_hotel;

    // Constructor
    public Usuario(Integer id, String nombre, String correo, TipoUsuario rol, Hotel id_hotel){
        this.id=id;
        this.nombre=nombre;
        this.correo=correo;
        this.rol=rol;
        this.id_hotel=id_hotel; 
    }

    public Usuario(){;}

    //Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public TipoUsuario getRol() {
        return rol;
    }

    public void setRol(TipoUsuario rol) {
        this.rol = rol;
    }

    public Hotel getId_hotel() {
        return id_hotel;
    }

    public void setId_hotel(Hotel id_hotel) {
        this.id_hotel = id_hotel;
    }


    
}
