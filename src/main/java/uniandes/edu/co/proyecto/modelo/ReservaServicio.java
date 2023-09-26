package uniandes.edu.co.proyecto.modelo;

import java.security.Timestamp;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="reservas_servicio")
public class ReservaServicio {
    @EmbeddedId
    private ReservaServicioPK id;
    public ReservaServicio(Habitacion idHabitacion, Servicio idServicio, Timestamp fechaReserva, Integer duracion) {
        super();
        this.id = new ReservaServicioPK(idHabitacion, idServicio, fechaReserva, duracion);
    }
    public ReservaServicio()
    {;}
    public ReservaServicioPK getId() {
        return id;
    }
    public void setId(ReservaServicioPK id) {
        this.id = id;
    }
    
}
