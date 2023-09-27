package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ReservaServicioPK implements Serializable{
    @ManyToOne
    @JoinColumn(name="idHabitacion", referencedColumnName="id")
    private Habitacion idHabitacion;

    @ManyToOne
    @JoinColumn(name="idServicio", referencedColumnName="id")
    private Servicio idServicio;

    private Timestamp fechaReserva;

    private Integer duracion;

    public ReservaServicioPK(Habitacion idHabitacion, Servicio idServicio, Timestamp fechaReserva, Integer duracion) {
        super();
        this.idHabitacion = idHabitacion;
        this.idServicio = idServicio;
        this.fechaReserva = fechaReserva;
        this.duracion = duracion;
    }

    public Habitacion getIdHabitacion() {
        return idHabitacion;
    }

    public Servicio getIdServicio() {
        return idServicio;
    }

    public Timestamp getFechaReserva() {
        return fechaReserva;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setIdHabitacion(Habitacion idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public void setIdServicio(Servicio idServicio) {
        this.idServicio = idServicio;
    }

    public void setFechaReserva(Timestamp fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    
    
}
