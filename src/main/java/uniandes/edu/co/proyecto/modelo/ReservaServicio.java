package uniandes.edu.co.proyecto.modelo;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.annotation.Id;


@Document(collection="reservas_servicios")
public class ReservaServicio {

    @Id
    private Integer _id;

    private Date fechareserva;
    public Integer duracion;
    public String idservicio;

    public ReservaServicio(){
    ;
    }
    
    public ReservaServicio(Date fechaReserva, Integer duracion,  String idservicio){
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

    public String getServicioID() {
        return idservicio;
    }

    public void setServicioID(String idservicio) {
        this.idservicio = idservicio;
    }


}