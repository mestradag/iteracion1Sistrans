package uniandes.edu.co.proyecto.modelo;

import java.security.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="reservas_servicio")
public class ReservaServicio {


    private Timestamp fechaReserva;
    public Integer duracion;
    public Integer servicioID;


    public ReservaServicio(){
    ;
    }
    
    public ReservaServicio(Timestamp fechaReserva, Integer duracion,  Integer servicioID){
        this.fechaReserva=fechaReserva;
        this.duracion=duracion;
        this.servicioID=servicioID;
      

    }

    public Timestamp getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Timestamp fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public Integer getServicioID() {
        return servicioID;
    }

    public void setServicioID(Integer servicioID) {
        this.servicioID = servicioID;
    }


}