package uniandes.edu.co.proyecto.modelo;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="gimnasios")
public class Gimnasio extends Servicio{
    
    private Integer numeroMaquinas;
    private Timestamp horaInicio;
    private Timestamp horaFin;

    public Gimnasio(){
        ;
    }

    public Gimnasio(Integer numeroMaquinas, Timestamp horaInicio, Timestamp horaFin){
        this.numeroMaquinas=numeroMaquinas;
        this.horaInicio=horaInicio;
        this.horaFin=horaFin;
    }

    public Integer getNumeroMaquinas() {
        return numeroMaquinas;
    }

    public void setNumeroMaquinas(Integer numeroMaquinas) {
        this.numeroMaquinas = numeroMaquinas;
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
