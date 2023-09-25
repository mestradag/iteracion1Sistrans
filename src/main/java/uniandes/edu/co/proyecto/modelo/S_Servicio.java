package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="serviciosSpa")
public class S_Servicio extends Servicio{
    
    private String nombre;
    

    public S_Servicio(){
        ;
    }

    public S_Servicio(String nombre){
        this.nombre=nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

     
}
