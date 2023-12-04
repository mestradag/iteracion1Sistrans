package uniandes.edu.co.proyecto.modelo;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;


@Document(collection="reservas_servicios")
public class ReservaServicio {

    @Id
    private Integer _id;

    private Date fechareserva;
    public Integer duracion;
    public Integer idservicio;

    public ReservaServicio(){
    ;
    }
    
    public ReservaServicio(Date fechaReserva, Integer duracion,  Integer idservicio){
        this.fechareserva=fechaReserva;
        this.duracion=duracion;
        this.idservicio=idservicio;

    }

    public Date getFechaReserva() {
        return fechareserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechareserva = fechaReserva;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public Integer getServicioID() {
        return idservicio;
    }

    public void setServicioID(Integer idservicio) {
        this.idservicio = idservicio;
    }


}