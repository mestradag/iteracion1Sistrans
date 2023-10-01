package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="internet")
public class Internet extends Servicio{
    
    @Id
    @OneToOne
    @JoinColumn(name = "idServicio", referencedColumnName = "idServicio")
    private Reserva idServicio;
    
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
