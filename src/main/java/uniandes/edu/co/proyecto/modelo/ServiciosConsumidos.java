package uniandes.edu.co.proyecto.modelo;
import java.security.Timestamp;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="s_consumidos")
public class ServiciosConsumidos {
    @EmbeddedId
    private ServiciosConsumidosPK id;
    private Timestamp fecha;
    public ServiciosConsumidos(CuentaConsumo idCuenta, Servicio idServicio, Timestamp fecha) {
        super();
        this.id = new ServiciosConsumidosPK(idCuenta, idServicio);
    }
    public ServiciosConsumidos()
    {;}
    public ServiciosConsumidosPK getId() {
        return id;
    }
    public void setId(ServiciosConsumidosPK id) {
        this.id = id;
    }  
    public Timestamp getFecha() {
        return fecha;
    }
    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }
    
}
