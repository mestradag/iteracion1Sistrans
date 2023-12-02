package uniandes.edu.co.proyecto.modelo;

import java.security.Timestamp;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="reservas_servicio")
public class ReservaServicio {


    private Timestamp fechaReserva;
    public Integer duracion;
    public Integer idservicio;

    public Integer idcuentaconsumo;


    public ReservaServicio(){
    ;
    }
    
    public ReservaServicio(Timestamp fechaReserva, Integer duracion,  Integer idservicio, Integer idcuentaconsumo){
        this.fechaReserva=fechaReserva;
        this.duracion=duracion;
        this.idservicio=idservicio;
        this.idcuentaconsumo = idcuentaconsumo;

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
        return idservicio;
    }

    public void setServicioID(Integer idservicio) {
        this.idservicio = idservicio;
    }


}