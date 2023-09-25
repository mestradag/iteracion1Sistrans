package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="internet")
public class Internet extends Servicio{
    
    private Double bandaAncha;
    

    public Internet(){
        ;
    }

    public Internet(Double bandaAncha){
        this.bandaAncha=bandaAncha;
    }

    public Double getBandaAncha() {
        return bandaAncha;
    }

    public void setBandaAncha(Double bandaAncha) {
        this.bandaAncha = bandaAncha;
    }
    
    
    
}
