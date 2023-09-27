package uniandes.edu.co.proyecto.modelo;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="establecimientos_c")
public class EstablecimientoC extends Servicio{
    
    private String nombre;
    private String tipo;

    public EstablecimientoC(){
        ;
    }

    public EstablecimientoC(String nombre,String tipo){
        this.nombre=nombre;
        this.tipo=tipo;
    }

        
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
