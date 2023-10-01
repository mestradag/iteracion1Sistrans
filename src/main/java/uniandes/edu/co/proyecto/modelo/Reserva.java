package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="reservas")
public class Reserva {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idReserva;
    private Date fechaInicio;
    private Date fechaFin;
    private Integer duracion;
    private Integer numAcompanantes;

    @ManyToOne
    @JoinColumn(name = "idHabitacion", referencedColumnName = "idHabitacion")
    private Habitacion idHabitacion;

    @ManyToOne
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    private Usuario idUsuario;

    @ManyToOne
    @JoinColumn(name = "idPlanConsumo", referencedColumnName = "idPlanConsumo")
    private PlanConsumo idPlanConsumo;

    //Constructor
    public Reserva(Integer idReserva, Date fechaInicio,  Date fechaFin, Integer duracion, Integer numAcompanantes, Habitacion idHabitacion, Usuario idUsuario, PlanConsumo idPlanConsumo){
        this.idReserva=idReserva;
        this.fechaInicio=fechaInicio;
        this.fechaFin=fechaFin;
        this.duracion=duracion;
        this.numAcompanantes=numAcompanantes;
        this.idHabitacion=idHabitacion;
        this.idUsuario=idUsuario;
        this.idPlanConsumo=idPlanConsumo;

    }

    public Reserva(){;}

    //Getters and Setters
    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public Integer getNumAcompanantes() {
        return numAcompanantes;
    }

    public void setNumAcompanantes(Integer numAcompanantes) {
        this.numAcompanantes = numAcompanantes;
    }

    public Habitacion getIdHabitacion() {
        return idHabitacion;
    }

    public void setId_habitacion(Habitacion idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setId_usuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public PlanConsumo getIdPlanConsumo() {
        return idPlanConsumo;
    }

    public void setIdPlanConsumo(PlanConsumo idPlanConsumo) {
        this.idPlanConsumo = idPlanConsumo;
    }


}
