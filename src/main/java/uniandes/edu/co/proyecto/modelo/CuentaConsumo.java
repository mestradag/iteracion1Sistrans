package uniandes.edu.co.proyecto.modelo;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;   
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.GenerationType;
import java.util.List;


@Entity
@Table(name="cuentas_c")
public class CuentaConsumo {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idcuenta;
    
    private boolean estado;
    private Timestamp checkin;
    private Timestamp checkout;
    private List<Integer> productosConsumidos;



    @OneToOne
    @JoinColumn(name = "idhabitacion", referencedColumnName = "idhabitacion")
    private Habitacion idhabitacion;

    public CuentaConsumo(
        Boolean estado, 
        Timestamp checkin, 
        Timestamp checkout,
        Habitacion idhabitacion
        ) {
        this.estado = estado;
        this.checkin = checkin;
        this.checkout = checkout;
        this.idhabitacion = idhabitacion;
    }

    public CuentaConsumo()
    {;}
    
    public Integer getIdcuenta() {
        return idcuenta;
    }
    public Boolean getEstado() {
        return estado;
    }
    public Timestamp getCheckin() {
        return checkin;
    }
    public Timestamp getCheckout() {
        return checkout;
    }
    public void setIdcuenta(Integer id) {
        this.idcuenta = id;
    }
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    public void setCheckin(Timestamp checkin) {
        this.checkin = checkin;
    }
    public void setCheckout(Timestamp checkout) {
        this.checkout = checkout;
    }
    public Habitacion getIdhabitacion() {
        return idhabitacion;
    }

    public void setIdHabitacion(Habitacion idHabitacion) {
        this.idhabitacion = idHabitacion;
    }

    public List<Integer> getProductos() {
        return productosConsumidos;
    }

    public void setProductos(List<Integer> productosConsumidos) {
        this.productosConsumidos = productosConsumidos;
    }
    
    
}
