package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="reservas")
public class Reserva {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private Date fechaInicio;
    private Date fechaFin;
    private Integer duracion;
    private Integer numAcompanantes;

    //Constructor
    public Reserva(Integer id, Date fechaInicio,  Date fechaFin, Integer duracion, Integer numAcompanantes){
        this.id=id;
        this.fechaInicio=fechaInicio;
        this.fechaFin=fechaFin;
        this.duracion=duracion;
        this.numAcompanantes=numAcompanantes;
    }

    public Reserva(){;}

    //Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    
}
