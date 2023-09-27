package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="hoteles")
public abstract class Hotel {
    @Id
    private String nombre;
    private String ciudad;
    
    // Constructor
    public Hotel(String nombre, String ciudad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
    }

    public Hotel(){;}

    //Getters and Setters
    public String getNombre() {
        return nombre;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}

