package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="spas")
public class Spa extends Servicio{
    
    @Id
    @OneToOne
    @JoinColumn(name = "idServicio", referencedColumnName = "idServicio")
    private Reserva idServicio;
    
    private String nombre;
    

    public Spa(){
        ;
    }

    public Spa(String nombre){
        this.nombre=nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

     
}
