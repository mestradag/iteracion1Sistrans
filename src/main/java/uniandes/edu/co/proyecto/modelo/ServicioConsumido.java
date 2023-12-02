package uniandes.edu.co.proyecto.modelo;

import java.security.Timestamp;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="servicios_consumidos")
public class ServicioConsumido {

    private Timestamp fechaReserva;
    private Integer idservicio;

    private Integer idcuentaconsumo;

    public ServicioConsumido(){
    ;
    }
    
    public ServicioConsumido(Timestamp fechaReserva, Integer idservicio, Integer idcuentaconsumo){
        this.fechaReserva=fechaReserva;
        this.idservicio=idservicio;
        this.idcuentaconsumo = idcuentaconsumo;
    
    }

    public Timestamp getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Timestamp fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public Integer getIdServicio() {
        return idservicio;
    }

    public void setIdServicio(Integer idservicio) {
        this.idservicio = idservicio;
    }

    public Integer getIdCuenta() {
        return idcuentaconsumo;
    }

    public void setIdCuenta(Integer idcuentaconsumo) {
        this.idcuentaconsumo = idcuentaconsumo;
    }

}