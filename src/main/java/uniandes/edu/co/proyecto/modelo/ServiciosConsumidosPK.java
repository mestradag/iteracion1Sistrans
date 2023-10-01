package uniandes.edu.co.proyecto.modelo;
import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Embeddable
public class ServiciosConsumidosPK implements Serializable{

    @ManyToOne
    @JoinColumn(name="idCuenta", referencedColumnName="idCuenta")
    private CuentaConsumo idCuenta;

    @ManyToOne
    @JoinColumn(name="idServicio", referencedColumnName="idServicio")
    private Servicio idServicio;

    public ServiciosConsumidosPK(CuentaConsumo idCuenta, Servicio idServicio) {
        super();
        this.idCuenta = idCuenta;
        this.idServicio = idServicio;
    }

    public CuentaConsumo getIdCuenta() {
        return idCuenta;
    }

    public Servicio getIdServicio() {
        return idServicio;
    }

    public void setIdCuenta(CuentaConsumo idCuenta) {
        this.idCuenta = idCuenta;
    }

    public void setIdServicio(Servicio idServicio) {
        this.idServicio = idServicio;
    }
    
}
