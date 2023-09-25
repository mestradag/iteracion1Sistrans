package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="prestamos")
public class Prestamo extends Servicio{
    
    private String utensilio;
    private Integer cantidad;

    public Prestamo(){
        ;
    }

    public Prestamo(String utensilio, Integer cantidad){
        this.utensilio=utensilio;
        this.cantidad=cantidad;
    }

    public String getUtensilio() {
        return utensilio;
    }

    public void setUtensilio(String utensilio) {
        this.utensilio = utensilio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    
    
}
