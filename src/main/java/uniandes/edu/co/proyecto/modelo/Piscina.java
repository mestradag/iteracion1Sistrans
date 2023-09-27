package uniandes.edu.co.proyecto.modelo;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="piscinas")
public class Piscina extends Servicio{
    
    private Integer profundidad;
    private Timestamp horaInicio;
    private Timestamp horaFin;

    public Piscina(){
        ;
    }

    public Piscina(Integer profundidad, Timestamp horaInicio, Timestamp horaFin){
        this.profundidad=profundidad;
        this.horaInicio=horaInicio;
        this.horaFin=horaFin;
    }

    public Integer getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(Integer profundidad) {
        this.profundidad = profundidad;
    }

    public Timestamp getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Timestamp horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Timestamp getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Timestamp horaFin) {
        this.horaFin = horaFin;
    }

    
    
    
}
