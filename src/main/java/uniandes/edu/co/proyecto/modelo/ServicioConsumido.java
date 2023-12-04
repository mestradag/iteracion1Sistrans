package uniandes.edu.co.proyecto.modelo;



import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
import org.springframework.data.annotation.Id;

@Document(collection="servicios_consumidos")
public class ServicioConsumido {

    @Id
    private Integer _id;

    private Date fechaReserva;
    private Integer idservicio;

    private Integer idcuentaconsumo;

    public ServicioConsumido(){
    ;
    }
    
    public ServicioConsumido(Date fechaReserva, Integer idservicio, Integer idcuentaconsumo){
        this.fechaReserva=fechaReserva;
        this.idservicio=idservicio;
        this.idcuentaconsumo = idcuentaconsumo;
    
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
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