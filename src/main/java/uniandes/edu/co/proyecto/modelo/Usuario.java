package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name="usuarios")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Integer idusuario;
    
    public String nombre;
    private String correo;
    private String rol;
    private List<Reserva> reservas;

    @ManyToOne
    @JoinColumn(name = "nombrehotel", referencedColumnName = "nombre")
    private Hotel nombrehotel;

    public Usuario(){;}
    // Constructor
    public Usuario(String nombre, String correo, String rol, Hotel nombrehotel){
        this.nombre=nombre;
        this.correo=correo; 
        this.rol=rol;
        this.nombrehotel=nombrehotel; 
    }

    

    //Getters and Setters
    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario=idusuario;
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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Hotel getNombrehotel() {
        return nombrehotel;
    }

    public void setNombrehotel(Hotel nombrehotel) {
        this.nombrehotel = nombrehotel;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }
    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idusuario=" + idusuario +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", rol=" + rol +
                ", nombrehotel=" + nombrehotel.getNombre() +
                '}';
    }

    
}

