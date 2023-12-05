package uniandes.edu.co.proyecto.modelo;



import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
import org.springframework.data.annotation.Id;

@Document(collection="servicios_consumidos")
public class ServicioConsumido {

    @Id
    private Integer _id;

    private Date fechaReserva;
    private String idservicio;

    private String idcuentaconsumo;

    public ServicioConsumido(){
    ;
    }
    
    public ServicioConsumido(Date fechaReserva, String idservicio, String idcuentaconsumo){
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

    public String getIdServicio() {
        return idservicio;
    }

    public void setIdServicio(String idservicio) {
        this.idservicio = idservicio;
    }

    public String getIdCuenta() {
        return idcuentaconsumo;
    }

    public void setIdCuenta(String idcuentaconsumo) {
        this.idcuentaconsumo = idcuentaconsumo;
    }

}